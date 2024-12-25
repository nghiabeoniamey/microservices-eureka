package oniamey.nghiabe.commonservice.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import oniamey.nghiabe.commonservice.entities.base.CommonPropertiesEntity;

@Table(name = "category")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Category extends CommonPropertiesEntity {

    @Id
    @Column(name = "category_id")
    private Long id;

    @Column(name = "category_name")
    private String name;

    @Column(name = "category_code")
    private String code;

    @Column(name = "status")
    private Long status;

}
