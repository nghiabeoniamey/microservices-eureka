package oniamey.nghiabe.commonservice.repositories;

import oniamey.nghiabe.commonservice.entities.SendMail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SendMailRepository extends JpaRepository<SendMail, Long> {
}
