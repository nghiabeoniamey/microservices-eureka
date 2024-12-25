package oniamey.nghiabe.commonservice.core.connection.services.auth.services;

import oniamey.nghiabe.commonservice.entities.Users;

public interface AuthUsersService {

    Users getUserByMail(String mail);

}
