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

@Table(name = "user_roles")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserRoles extends CommonPropertiesEntity {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "role_id")
    private Long roleId;

}
