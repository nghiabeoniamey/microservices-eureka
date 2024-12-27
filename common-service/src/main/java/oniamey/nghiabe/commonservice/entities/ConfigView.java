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

@Table(name = "config_view")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ConfigView extends CommonPropertiesEntity {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "view_name")
    private String name;

    @Column(name = "view_path")
    private String path;

    @Column(name  = "api_path")
    private String apiPath;

    @Column(name = "role_id")
    private String roleId;

    @Column(name = "status")
    private Long status;

}
