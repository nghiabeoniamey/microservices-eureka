package oniamey.nghiabe.commonservice.infrastructure.database.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import oniamey.nghiabe.commonservice.entities.Users;
import oniamey.nghiabe.commonservice.infrastructure.database.repositories.DBGenUserRepository;
import oniamey.nghiabe.commonservice.infrastructure.database.services.DBGeneratorService;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class DBGeneratorServiceImpl implements DBGeneratorService {

    private final DBGenUserRepository userRepository;

    @Override
    public void generateUsers() {
        if (userRepository.existsById(1L)) {
            log.info("User exist in system");
            return;
        }
        Users users = new Users(1L, "Oniamey", "Hieu Nghia", "Trinh", "nghiabe.dev", "0849070512", 1L, 1L);
        users.setCreatedUser(1L);
        users.setUpdatedUser(1L);
        Users newUser = userRepository.save(users);
        log.info("new User: {}", newUser.toString());
    }

}
