package oniamey.nghiabe.authservice.infrastructure.listener;

import jakarta.persistence.PrePersist;
import oniamey.nghiabe.authservice.entities.base.PrimaryEntity;

import java.util.UUID;

public class CreatePrimaryEntityListener {

    @PrePersist
    private void onCreate(PrimaryEntity entity) {
        entity.setId(UUID.randomUUID().toString());
    }

}
