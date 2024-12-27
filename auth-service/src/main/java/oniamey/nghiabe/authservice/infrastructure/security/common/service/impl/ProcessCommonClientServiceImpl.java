package oniamey.nghiabe.authservice.infrastructure.security.common.service.impl;

import oniamey.nghiabe.authservice.core.common.base.ResponseObject;
import oniamey.nghiabe.authservice.infrastructure.security.common.service.CommonClientService;
import oniamey.nghiabe.authservice.infrastructure.security.common.service.ProcessCommonClientService;
import oniamey.nghiabe.authservice.infrastructure.security.model.request.AuthFindUsersRequest;
import oniamey.nghiabe.authservice.infrastructure.security.model.request.AuthUserRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProcessCommonClientServiceImpl implements ProcessCommonClientService {

    private final CommonClientService commonClientService;


    public ProcessCommonClientServiceImpl(CommonClientService commonClientService) {
        this.commonClientService = commonClientService;
    }

    @Override
    public Optional<AuthUserRequest> getUsersByEmail(String email) {
        try {
            ResponseObject<AuthUserRequest> authUser = commonClientService.getUserByEmail(new AuthFindUsersRequest(email));
            if (authUser.isSuccess() && authUser.getData() != null) {
                AuthUserRequest authUserRequest = authUser.getData();
                return Optional.of(authUserRequest);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return Optional.empty();
    }

    @Override
    public Optional<AuthUserRequest> getUserById(Long id) {
        try {
            ResponseObject<AuthUserRequest> authUser = commonClientService.getUserById(id);
            if (authUser.isSuccess() && authUser.getData() != null) {
                AuthUserRequest authUserRequest = authUser.getData();
                return Optional.of(authUserRequest);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return Optional.empty();
    }

    @Override
    public AuthUserRequest createUser(AuthUserRequest request) {
        try {
            ResponseObject<AuthUserRequest> authUser = commonClientService.createUser(request);
            if (authUser.isSuccess() && authUser.getData() != null) {
                return authUser.getData();
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }


}
