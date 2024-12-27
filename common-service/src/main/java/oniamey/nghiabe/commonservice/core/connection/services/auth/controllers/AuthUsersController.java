package oniamey.nghiabe.commonservice.core.connection.services.auth.controllers;

import jakarta.validation.Valid;
import oniamey.nghiabe.commonservice.core.connection.services.auth.model.request.AuthFindUsersRequest;
import oniamey.nghiabe.commonservice.core.connection.services.auth.model.request.AuthUsersRequest;
import oniamey.nghiabe.commonservice.core.connection.services.auth.services.AuthUsersService;
import oniamey.nghiabe.commonservice.utils.Helper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class AuthUsersController {

    private final AuthUsersService usersService;

    public AuthUsersController(AuthUsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/email")
    public ResponseEntity<?> getUserByEmail(@Valid final AuthFindUsersRequest request) {
        return Helper.createResponseEntity(usersService.getUserByMail(request.getEmail()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        return Helper.createResponseEntity(usersService.getUserById(id));
    }

    @PostMapping()
    public ResponseEntity<?> createUser(@Valid @RequestBody AuthUsersRequest request) {
        return Helper.createResponseEntity(usersService.createUser(request));
    }

}
