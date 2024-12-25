package oniamey.nghiabe.commonservice.core.connection.services.auth.controllers;

import jakarta.validation.Valid;
import oniamey.nghiabe.commonservice.core.common.base.ResponseObject;
import oniamey.nghiabe.commonservice.core.connection.services.auth.model.request.EmailRequest;
import oniamey.nghiabe.commonservice.core.connection.services.auth.services.AuthUsersService;
import oniamey.nghiabe.commonservice.utils.Helper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
    public ResponseEntity<?> getUserByEmail(@Valid final EmailRequest request) {
        return Helper.createResponseEntity(
                ResponseObject.successForward(usersService.getUserByMail(request.getEmail()), "HUHU")
        );
    }

}
