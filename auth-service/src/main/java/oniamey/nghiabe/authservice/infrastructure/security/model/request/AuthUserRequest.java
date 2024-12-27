package oniamey.nghiabe.authservice.infrastructure.security.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import oniamey.nghiabe.authservice.infrastructure.constant.auth.Role;
import oniamey.nghiabe.authservice.infrastructure.constant.auth.Status;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AuthUserRequest {

    private Long id;

    private String userName;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String email;

    private String password;

    private String passwordSecret;

    private String subscriptionType;

    private String profilePicture;

    private Long departmentId;

    private Long processUserId;

    private Role role;

    private Status status;

}
