package oniamey.nghiabe.commonservice.infrastructure.event;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import oniamey.nghiabe.commonservice.entities.base.AuditEntity;

import java.util.Calendar;

public class AuditEntityListener {

    @PrePersist
    private void onCreate(AuditEntity entity) {
        entity.setCreatedTime(getCurrentTime());
        entity.setUpdateTime(getCurrentTime());
    }

    @PreUpdate
    private void onUpdate(AuditEntity entity) {
        entity.setUpdateTime(getCurrentTime());
    }

    private long getCurrentTime() {
        return Calendar.getInstance().getTimeInMillis();
    }

}