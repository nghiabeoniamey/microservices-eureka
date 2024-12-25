package oniamey.nghiabe.commonservice.core.connection.services.auth.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmailRequest {

    @NotBlank(message = "Email is required and not have blank")
    private String email;

}
