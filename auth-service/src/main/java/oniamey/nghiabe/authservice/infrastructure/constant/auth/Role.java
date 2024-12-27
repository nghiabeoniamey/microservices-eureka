package oniamey.nghiabe.authservice.infrastructure.constant.auth;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Role {

    ADMIN,

    USER,

    ANOTHER;

    public static List<String> Roles() {
        return Arrays.stream(Role.values())
                .map(Enum::name)
                .collect(Collectors.toList());
    }
}
