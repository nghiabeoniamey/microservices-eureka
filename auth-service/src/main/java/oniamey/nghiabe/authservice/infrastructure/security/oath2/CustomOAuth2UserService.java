package oniamey.nghiabe.authservice.infrastructure.security.oath2;

import lombok.RequiredArgsConstructor;
import oniamey.nghiabe.authservice.infrastructure.constant.auth.ActorConstants;
import oniamey.nghiabe.authservice.infrastructure.constant.auth.Role;
import oniamey.nghiabe.authservice.infrastructure.constant.auth.Status;
import oniamey.nghiabe.authservice.infrastructure.security.common.service.ProcessCommonClientService;
import oniamey.nghiabe.authservice.infrastructure.security.model.request.AuthUserRequest;
import oniamey.nghiabe.authservice.infrastructure.security.exception.OAuth2AuthenticationProcessingException;
import oniamey.nghiabe.authservice.infrastructure.security.oath2.user.OAuth2UserInfo;
import oniamey.nghiabe.authservice.infrastructure.security.oath2.user.OAuth2UserInfoFactory;
import oniamey.nghiabe.authservice.infrastructure.security.oath2.user.UserPrincipal;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    private final ProcessCommonClientService commonClientService;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest oAuth2UserRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(oAuth2UserRequest);
        try {
            return processOAuth2User(oAuth2UserRequest, oAuth2User);
        } catch (AuthenticationException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new InternalAuthenticationServiceException(ex.getMessage(), ex.getCause());
        }
    }

    private OAuth2User processOAuth2User(OAuth2UserRequest oAuth2UserRequest, OAuth2User oAuth2User) {
        OAuth2UserInfo oAuth2UserInfo = OAuth2UserInfoFactory
                .getOAuth2UserInfo(
                        oAuth2UserRequest.getClientRegistration().getRegistrationId(),
                        oAuth2User.getAttributes()
                );
        if (oAuth2UserInfo.getEmail() == null || oAuth2UserInfo.getEmail().isBlank()) {
            throw new OAuth2AuthenticationProcessingException("Email not found from OAuth2 provider");
        }

        Optional<AuthUserRequest> userAuthOptional = commonClientService.getUsersByEmail(oAuth2UserInfo.getEmail());

        if (userAuthOptional.isPresent()) {
            AuthUserRequest user = userAuthOptional.get();
            if(user.getStatus().equals(Status.INACTIVE)){
                throw new OAuth2AuthenticationProcessingException("The specified user is disabled");
            }
            AuthUserRequest userExist = (AuthUserRequest) updateExistingUser(user, oAuth2UserInfo);
            return UserPrincipal.create(userExist, oAuth2User.getAttributes(), userExist.getRole().name());
        }

        Object newUser = registerNewUser(oAuth2UserRequest, oAuth2UserInfo);
        if (newUser instanceof AuthUserRequest originUser) {
            return UserPrincipal.create(originUser, oAuth2User.getAttributes(), ActorConstants.USER);
        } else {
            throw new OAuth2AuthenticationProcessingException("Invalid email format");
        }
    }

    private Object registerNewUser(OAuth2UserRequest oAuth2UserRequest, OAuth2UserInfo oAuth2UserInfo) {
        AuthUserRequest user = new AuthUserRequest();
        user.setUserName(oAuth2UserInfo.getName());
        user.setEmail(oAuth2UserInfo.getEmail());
        user.setSubscriptionType(oAuth2UserInfo.getSubscriptionType());
        user.setProfilePicture(oAuth2UserInfo.getImageUrl());
        user.setStatus(Status.ACTIVE);
        user.setRole(Role.USER);
        user.setPassword(null);
        return commonClientService.createUser(user);
    }

    private Object updateExistingUser(AuthUserRequest existingUser, OAuth2UserInfo oAuth2UserInfo) {
        existingUser.setUserName(oAuth2UserInfo.getName());
        existingUser.setProfilePicture(oAuth2UserInfo.getImageUrl());
        existingUser.setSubscriptionType(oAuth2UserInfo.getSubscriptionType());
        if (existingUser.getStatus() == null) existingUser.setStatus(Status.ACTIVE);
        return commonClientService.createUser(existingUser);
    }

}
