package oniamey.nghiabe.authservice.infrastructure.security.oath2.session;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import oniamey.nghiabe.authservice.infrastructure.constant.auth.Session;
import oniamey.nghiabe.authservice.infrastructure.security.model.response.InfoUserResponse;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InfoUserImpl implements InfoUser {

    private final HttpSession httpSession;

    @Override
    public Long getId() {
        return (Long) httpSession.getAttribute(Session.CURRENT_USER_ID);
    }

    @Override
    public String getUserName() {
        return httpSession.getAttribute(Session.CURRENT_USER_NAME).toString();
    }

    @Override
    public String getEmail() {
        return httpSession.getAttribute(Session.CURRENT_USER_EMAIL).toString();
    }

    @Override
    public String getSubscriptionType() {
        return httpSession.getAttribute(Session.CURRENT_USER_SUBSCRIPTION_TYPE).toString();
    }

    @Override
    public String getProfilePicture() {
        return httpSession.getAttribute(Session.CURRENT_USER_PROFILE_PICTURE).toString();
    }

    @Override
    public String getRoleCode() {
        return httpSession.getAttribute(Session.CURRENT_USER_ROLE_CODE).toString();
    }

    @Override
    public String getRoleName() {
        return httpSession.getAttribute(Session.CURRENT_USER_ROLE_NAME).toString();
    }

    @Override
    public String getHost() {
        return httpSession.getAttribute(Session.CURRENT_HOST).toString();
    }

    @Override
    public InfoUserResponse getInfoUser() {
        return new InfoUserResponse(
                getId(),
                getUserName(),
                getEmail(),
                getSubscriptionType(),
                getProfilePicture(),
                getRoleCode(),
                getRoleName(),
                getHost()
        );
    }
}
