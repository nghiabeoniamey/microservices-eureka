package oniamey.nghiabe.commonservice.core.connection.services.auth.repositories;

import oniamey.nghiabe.commonservice.entities.Users;
import oniamey.nghiabe.commonservice.repositories.UsersRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthUsersRepository extends UsersRepository {

    Optional<Users> findByEmail(String email);

}
