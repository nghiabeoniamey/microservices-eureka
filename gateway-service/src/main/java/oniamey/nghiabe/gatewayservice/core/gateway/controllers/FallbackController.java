package oniamey.nghiabe.gatewayservice.core.gateway.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class FallbackController {

    @GetMapping("/common-service-fall-back")
    public String commonService() {
        return "Common service is not available";
    }

    @GetMapping("/auth-service-fall-back")
    public String authFallback() {
        return "Auth service is not available";
    }
}