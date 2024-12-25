package oniamey.nghiabe.commonservice.repositories;

import oniamey.nghiabe.commonservice.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}
