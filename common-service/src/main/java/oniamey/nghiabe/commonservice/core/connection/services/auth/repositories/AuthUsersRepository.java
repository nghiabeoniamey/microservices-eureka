package oniamey.nghiabe.commonservice.core.connection.services.auth.repositories;

import oniamey.nghiabe.commonservice.core.connection.services.auth.model.response.AuthUsersResponse;
import oniamey.nghiabe.commonservice.entities.Users;
import oniamey.nghiabe.commonservice.repositories.UsersRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthUsersRepository extends UsersRepository {

    Optional<Users> findByEmail(String email);

    @Query(value = """
        SELECT
            u.user_id id,
            u.username as userName,
            u.first_name firstName,
            u.last_name lastName,
            u.email as email,
            u.phone_number phoneNumber,
            u.department_id departmentId,
            d.department_name departmentName,
            u.created_user createdUser,
            u.updated_user updatedUser
        FROM users u
        JOIN department d ON d.department_id = u.department_id
        WHERE u.email = :email AND u.status = 1
    """, nativeQuery = true)
    AuthUsersResponse getUsersByEmail(String email);

    @Query(value = """
        SELECT
            u.user_id id,
            u.username as userName,
            u.first_name firstName,
            u.last_name lastName,
            u.email as email,
            u.phone_number phoneNumber,
            u.department_id departmentId,
            d.department_name departmentName,
            u.created_user createdUser,
            u.updated_user updatedUser
        FROM users u
        JOIN department d ON d.department_id = u.department_id
        WHERE u.user_id = :id AND u.status = 1
    """, nativeQuery = true)
    AuthUsersResponse getUsersById(Long id);

}
