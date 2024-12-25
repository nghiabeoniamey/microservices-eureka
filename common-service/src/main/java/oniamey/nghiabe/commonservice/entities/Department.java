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

@Table(name = "department")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Department extends CommonPropertiesEntity {

    @Id
    @Column(name = "department_id")
    private Long id;

    @Column(name = "department_name")
    private String name;

    @Column(name = "status")
    private Long status;

    @Column(name = "parent_department_id")
    private Long parentDepartmentId;


}
