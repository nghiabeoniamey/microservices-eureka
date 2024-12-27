package oniamey.nghiabe.authservice.infrastructure.constant.auth;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum AuthProvider {

    google,
    github,
    facebook,
    admin;

    public static List<String> getAuthProviders() {
        return Arrays.stream(AuthProvider.values())
                .map(Enum::name)
                .collect(Collectors.toList());
    }
}
