package oniamey.nghiabe.authservice.infrastructure.security.common.service;

import oniamey.nghiabe.authservice.core.common.base.ResponseObject;
import oniamey.nghiabe.authservice.infrastructure.security.model.request.AuthFindUsersRequest;
import oniamey.nghiabe.authservice.infrastructure.security.model.request.AuthUserRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "common-service", url = "${common-service.url}")
public interface CommonClientService {

    @GetMapping("/user/email")
    ResponseObject<AuthUserRequest> getUserByEmail(@RequestBody AuthFindUsersRequest request);

    @GetMapping("/user/{id}")
    ResponseObject<AuthUserRequest> getUserById(@PathVariable Long id);

    @PostMapping("/user")
    ResponseObject<AuthUserRequest> createUser(@RequestBody AuthUserRequest request);

}
