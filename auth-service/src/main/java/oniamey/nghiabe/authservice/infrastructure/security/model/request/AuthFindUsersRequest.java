package oniamey.nghiabe.authservice.infrastructure.security.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AuthFindUsersRequest {

    @NotBlank(message = "Email is required and not have blank")
    private String email;

}
