package oniamey.nghiabe.authservice.infrastructure.listener;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import oniamey.nghiabe.authservice.entities.base.AuditEntity;

import java.util.Calendar;

public class AuditEntityListener {

    @PrePersist
    private void onCreate(AuditEntity entity) {
        entity.setCreatedDate(getCurrentTime());
        entity.setLastModifiedDate(getCurrentTime());
    }

    @PreUpdate
    private void onUpdate(AuditEntity entity) {
        entity.setLastModifiedDate(getCurrentTime());
    }

    private long getCurrentTime() {
        return Calendar.getInstance().getTimeInMillis();
    }

}