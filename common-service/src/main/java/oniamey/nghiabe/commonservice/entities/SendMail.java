package oniamey.nghiabe.commonservice.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import oniamey.nghiabe.commonservice.entities.base.CommonPropertiesEntity;

@Table(name = "send_mail")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SendMail extends CommonPropertiesEntity {

    @Id
    @Column(name = "id")
    private Long id;

    @Lob
    @Column(name = "content")
    private String content;

    @Column(name = "mail_to")
    private String mailTo;

    @Column(name = "status")
    private Long status;

}
