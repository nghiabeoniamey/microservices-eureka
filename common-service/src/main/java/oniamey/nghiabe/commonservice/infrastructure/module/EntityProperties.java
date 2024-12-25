package oniamey.nghiabe.commonservice.infrastructure.module;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntityProperties {

    public static class EMPLOYEES {
        public static final byte EMPLOYEE_ID = 6;
        public static final byte FIRST_NAME = 20;
        public static final byte LAST_NAME = 25;
        public static final byte EMAIL = 25;
        public static final byte PHONE_NUMBER = 20;

    }

    public static class COUNTRIES{
        public static final byte COUNTRY_ID = 2;
        public static final byte COUNTRY_NAME = 40;
    }

    public static class DEPARTMENTS{
        public static final byte DEPARTMENT_ID = 4;
        public static final byte COUNTRY_NAME = 40;

    }

    public static class LOCATIONS{
        public static final byte LOCATION_ID = 4;
        public static final byte STREET_ADDRESS = 40;
        public static final byte POSTAL_CODE = 12;
        public static final byte CITY = 30;
        public static final byte STATE_PROVINCE = 25;
    }

    public static  class JOBS{
        public static final byte JOB_ID = 10;
        public static final byte JOB_TITLE = 36;
        public static final byte MIN_SALARY = 6;
        public static final byte MAX_SALARY = 6;
    }

    public static  class REGIONS{
        public static final byte REGION_NAME = 25;
    }

    public static class DEFAULT {
        public static final byte UUID = 36;

    }



}
