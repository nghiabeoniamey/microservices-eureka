package oniamey.nghiabe.commonservice.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "item")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Item {

    @Id
    @Column(name = "item_id")
    private Long id;

    @Column(name = "item_name")
    private String name;

    @Column(name = "item_code")
    private String code;

    @Column(name = "status")
    private Long status;

    @Column(name = "parent_item_id")
    private Long parentItemId;

    @Column(name = "category_id")
    private Long categoryId;

}
