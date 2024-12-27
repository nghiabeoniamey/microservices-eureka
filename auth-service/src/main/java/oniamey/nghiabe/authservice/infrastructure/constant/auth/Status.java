package oniamey.nghiabe.authservice.infrastructure.constant.auth;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Status {

    ACTIVE,

    INACTIVE;

    public static List<String> Statuses() {
        return Arrays.stream(Status.values())
                .map(Enum::name)
                .collect(Collectors.toList());
    }
}
