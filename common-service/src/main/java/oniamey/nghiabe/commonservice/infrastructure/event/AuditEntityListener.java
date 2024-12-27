package oniamey.nghiabe.commonservice.infrastructure.event;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import oniamey.nghiabe.commonservice.entities.base.AuditEntity;

import java.util.Calendar;
import java.util.Date;

public class AuditEntityListener {

    @PrePersist
    private void onCreate(AuditEntity entity) {
        entity.setCreatedTime(getCurrentTime());
        entity.setUpdatedTime(getCurrentTime());
    }

    @PreUpdate
    private void onUpdate(AuditEntity entity) {
        entity.setUpdatedTime(getCurrentTime());
    }

    private Date getCurrentTime() {
        return new Date();
    }

}