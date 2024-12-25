package oniamey.nghiabe.commonservice.repositories;

import oniamey.nghiabe.commonservice.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
