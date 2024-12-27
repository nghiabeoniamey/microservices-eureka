package oniamey.nghiabe.authservice.infrastructure.security.common.service;

import oniamey.nghiabe.authservice.infrastructure.security.model.request.AuthUserRequest;

import java.util.Optional;

public interface ProcessCommonClientService {

    Optional<AuthUserRequest> getUsersByEmail(String email);

    Optional<AuthUserRequest> getUserById(Long id);

    AuthUserRequest createUser(AuthUserRequest request);

}
