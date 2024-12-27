package oniamey.nghiabe.authservice.repositories;

import oniamey.nghiabe.authservice.entities.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefreshRepository extends JpaRepository<RefreshToken, Long> {
}
