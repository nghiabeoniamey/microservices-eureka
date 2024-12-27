package oniamey.nghiabe.authservice.infrastructure.security.controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import oniamey.nghiabe.authservice.infrastructure.constant.model.ApiConstants;
import oniamey.nghiabe.authservice.infrastructure.security.model.request.AuthLoginRequest;
import oniamey.nghiabe.authservice.infrastructure.security.model.request.AuthRefreshRequest;
import oniamey.nghiabe.authservice.infrastructure.security.model.request.AuthRegisterRequest;
import oniamey.nghiabe.authservice.infrastructure.security.service.SecurityRefreshTokenService;
import oniamey.nghiabe.authservice.utils.Helper;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiConstants.API_AUTH_PREFIX)
@RequiredArgsConstructor
public class SecurityController {

    private final SecurityRefreshTokenService authenticationService;

    @PostMapping("/refresh")
    public ResponseEntity<?> refreshToken(@RequestBody AuthRefreshRequest request) throws BadRequestException, JsonProcessingException {
        return Helper.createResponseEntity(authenticationService.getRefreshToken(request));
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(@RequestBody AuthRefreshRequest request) {
        return Helper.createResponseEntity(authenticationService.logout(request));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthLoginRequest request) {
        return Helper.createResponseEntity(authenticationService.login(request));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody AuthRegisterRequest request) {
        return Helper.createResponseEntity(authenticationService.register(request));
    }
}
