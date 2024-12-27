package oniamey.nghiabe.authservice.infrastructure.constant.model;

public final class ApiConstants {

    public static final String USER = "/user";
    public static final String ADMIN = "/admin";

    public static final String EMBED = "/embed";

    public static final String API_VERSION_PREFIX = "/api/v1";
    public static final String API_COMMON = API_VERSION_PREFIX + "/common";

    public static final String API_GUEST_GUARD_ACCOUNT = "/api/guest-guard/account";

    public static final String API_USER_PREFIX = API_VERSION_PREFIX + USER;
    public static final String API_ADMIN_PREFIX = API_VERSION_PREFIX + ADMIN;

    public static final String API_EMBED_PREFIX = API_VERSION_PREFIX + EMBED;

    public static final String API_USER_ANOTHER = API_USER_PREFIX + "/another";
    public static final String API_USER_ANOTHER2 = API_USER_PREFIX + "/another-2";

    public static final String API_ADMIN_ANOTHER = API_ADMIN_PREFIX + "/another";
    public static final String API_ADMIN_ANOTHER2 = API_ADMIN_PREFIX + "/another-2";

    public static final String API_COMMON_UPLOAD = API_COMMON + "/upload";

    /* AUTHENTICATION */
    public static final String API_AUTH_PREFIX = API_VERSION_PREFIX + "/auth";

    public static final String PATH_OAUTH2 = "/oauth2";

}
