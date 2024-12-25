package oniamey.nghiabe.commonservice.core.connection.services.auth.services.impl;

import oniamey.nghiabe.commonservice.core.connection.services.auth.repositories.AuthUsersRepository;
import oniamey.nghiabe.commonservice.core.connection.services.auth.services.AuthUsersService;
import oniamey.nghiabe.commonservice.entities.Users;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthUsersService {

    private final AuthUsersRepository usersRepository;

    public AuthServiceImpl(AuthUsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public Users getUserByMail(String mail) {
        return usersRepository.findByEmail(mail).orElse(null);
    }

}
