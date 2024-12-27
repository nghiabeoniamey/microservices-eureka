package oniamey.nghiabe.commonservice.core.connection.services.auth.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthUsersRequest {

    @NotBlank(message = "User name is required and not have blank")
    private Long id;

    @NotBlank(message = "User name is required and not have blank")
    private String userName;

    @NotBlank(message = "First name is required and not have blank")
    private String firstName;

    @NotBlank(message = "Last name is required and not have blank")
    private String lastName;

    @NotBlank(message = "Email is required and not have blank")
    private String email;

    @NotBlank(message = "Phone number is required and not have blank")
    private String phoneNumber;

    @NotBlank(message = "Status is required and not have blank")
    private Long departmentId;

    private Long processUserId;

}
