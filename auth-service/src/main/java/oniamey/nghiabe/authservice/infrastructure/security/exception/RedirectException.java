package oniamey.nghiabe.authservice.infrastructure.security.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RedirectException extends RuntimeException {

    private String message;

}
