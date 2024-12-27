package oniamey.nghiabe.authservice.infrastructure.security.service;

import lombok.RequiredArgsConstructor;
import oniamey.nghiabe.authservice.infrastructure.security.common.service.ProcessCommonClientService;
import oniamey.nghiabe.authservice.infrastructure.security.model.request.AuthUserRequest;
import oniamey.nghiabe.authservice.infrastructure.security.oath2.user.UserPrincipal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private static final Logger log = LoggerFactory.getLogger(CustomUserDetailsService.class);

    private final ProcessCommonClientService commonClientService;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        Optional<AuthUserRequest> userOptional = commonClientService.getUsersByEmail(email);
        if (userOptional.isPresent()) {
            AuthUserRequest user = userOptional.get();
            String role = user.getRole().name();
            return UserPrincipal.create(user, role);
        }

        throw new UsernameNotFoundException("user not found with email : " + email);
    }

}