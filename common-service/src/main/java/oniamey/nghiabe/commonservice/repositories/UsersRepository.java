package oniamey.nghiabe.commonservice.repositories;

import oniamey.nghiabe.commonservice.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
}
