package oniamey.nghiabe.commonservice.entities.base;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class CommonPropertiesEntity extends AuditEntity {

    @Column(name = "created_user")
    private Long createdUser;

    @Column(name = "updated_user")
    private Long updatedUser;

}