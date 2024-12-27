package oniamey.nghiabe.commonservice.core.connection.services.auth.model.response;

public interface AuthUsersResponse {

    Long getId();

    String getUserName();

    String getFirstName();

    String getLastName();

    String getEmail();

    String getPhoneNumber();

    Long getDepartmentId();

    String getDepartmentName();

    Long getCreatedUser();

    Long getUpdatedUser();

}
