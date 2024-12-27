package oniamey.nghiabe.authservice.infrastructure.security.service;

import jakarta.validation.Valid;
import oniamey.nghiabe.authservice.core.common.base.ResponseObject;
import oniamey.nghiabe.authservice.infrastructure.security.model.request.AuthLoginRequest;
import oniamey.nghiabe.authservice.infrastructure.security.model.request.AuthRefreshRequest;
import oniamey.nghiabe.authservice.infrastructure.security.model.request.AuthRegisterRequest;

public interface SecurityRefreshTokenService {

    ResponseObject<?> getRefreshToken(@Valid AuthRefreshRequest request);

    ResponseObject<?> logout(@Valid AuthRefreshRequest request);

    ResponseObject<?> login(@Valid AuthLoginRequest request);

    ResponseObject<?> register(@Valid AuthRegisterRequest request);

}
