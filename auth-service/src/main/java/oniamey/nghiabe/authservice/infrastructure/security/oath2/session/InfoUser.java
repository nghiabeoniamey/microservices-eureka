package oniamey.nghiabe.authservice.infrastructure.security.oath2.session;

import oniamey.nghiabe.authservice.infrastructure.security.model.response.InfoUserResponse;

public interface InfoUser {

    Long getId();

    String getUserName();

    String getEmail();

    String getSubscriptionType();

    String getProfilePicture();

    String getRoleCode();

    String getRoleName();

    String getHost();

    InfoUserResponse getInfoUser();

}
