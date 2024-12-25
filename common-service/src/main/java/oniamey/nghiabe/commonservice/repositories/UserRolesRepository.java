package oniamey.nghiabe.commonservice.repositories;

import oniamey.nghiabe.commonservice.entities.UserRoles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRolesRepository extends JpaRepository<UserRoles, Long> {
}
