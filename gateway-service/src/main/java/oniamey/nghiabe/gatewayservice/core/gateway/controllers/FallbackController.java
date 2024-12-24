package oniamey.nghiabe.gatewayservice.core.gateway.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gateway-service/fallback")
public class FallbackController {

    @GetMapping("/user")
    public String userFallback() {
        return "User service is not available";
    }

    @GetMapping("/auth")
    public String authFallback() {
        return "Auth service is not available";
    }
}