package oniamey.nghiabe.commonservice.repositories;

import oniamey.nghiabe.commonservice.entities.ConfigView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigViewRepository extends JpaRepository<ConfigView, Long> {
}
