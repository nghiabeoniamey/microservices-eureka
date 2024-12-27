package oniamey.nghiabe.commonservice.core.connection.services.auth.services;

import oniamey.nghiabe.commonservice.core.common.base.ResponseObject;
import oniamey.nghiabe.commonservice.core.connection.services.auth.model.request.AuthUsersRequest;

public interface AuthUsersService {

    ResponseObject<?> getUserByMail(String mail);

    ResponseObject<?> getUserById(Long id);

    ResponseObject<?> createUser(AuthUsersRequest request);

}
