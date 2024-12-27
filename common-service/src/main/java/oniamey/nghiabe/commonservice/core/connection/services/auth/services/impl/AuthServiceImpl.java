package oniamey.nghiabe.commonservice.core.connection.services.auth.services.impl;

import oniamey.nghiabe.commonservice.core.common.base.ResponseObject;
import oniamey.nghiabe.commonservice.core.connection.services.auth.model.request.AuthUsersRequest;
import oniamey.nghiabe.commonservice.core.connection.services.auth.repositories.AuthUsersRepository;
import oniamey.nghiabe.commonservice.core.connection.services.auth.services.AuthUsersService;
import oniamey.nghiabe.commonservice.entities.Users;
import oniamey.nghiabe.commonservice.infrastructure.module.Message;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthUsersService {

    private final AuthUsersRepository usersRepository;

    public AuthServiceImpl(AuthUsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public ResponseObject<?> getUserByMail(String mail) {
        return new ResponseObject<>(
                usersRepository.getUsersByEmail(mail),
                HttpStatus.OK,
                Message.Success.GET_SUCCESS
        );
    }

    @Override
    public ResponseObject<?> getUserById(Long id) {
        return new ResponseObject<>(
                usersRepository.getUsersById(id),
                HttpStatus.OK,
                Message.Success.GET_SUCCESS
        );
    }

    @Override
    public ResponseObject<?> createUser(AuthUsersRequest request) {
        Users users = new Users();
        users.setId(request.getId());
        users.setUserName(request.getUserName());
        users.setFirstName(request.getFirstName());
        users.setLastName(request.getLastName());
        users.setEmail(request.getEmail());
        users.setPhoneNumber(request.getPhoneNumber());
        users.setStatus(1L);
        users.setDepartmentId(request.getDepartmentId());
        users.setCreatedUser(request.getProcessUserId() != null ? request.getProcessUserId() : request.getId());
        users.setUpdatedUser(request.getProcessUserId() != null ? request.getProcessUserId() : request.getId());
        return new ResponseObject<>(
                usersRepository.save(users),
                HttpStatus.CREATED,
                Message.Success.CREATE_SUCCESS
        );
    }

}
