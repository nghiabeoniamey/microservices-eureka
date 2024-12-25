package oniamey.nghiabe.commonservice.infrastructure.database;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import oniamey.nghiabe.commonservice.infrastructure.database.services.DBGeneratorService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DBGenerator {

    @Value("${db.generator.is-generated}")
    private String isGenerated;

    private final DBGeneratorService dbGeneratorService;

    @PostConstruct
    public void init() {
        if ("true".equals(isGenerated)) generateData();
    }

    private void generateData() {

        dbGeneratorService.generateUsers();

    }

}
