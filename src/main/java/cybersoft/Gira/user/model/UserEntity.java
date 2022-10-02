package cybersoft.Gira.user.model;

import lombok.experimental.UtilityClass;

@UtilityClass
public class UserEntity {
    @UtilityClass
    public static class User {
        public static final String TABLE_NAME = "G_USER";
        public static final String ACCOUNT_NAME = "G_ACCOUNT_NAME";
        public static final String PASSWORD = "G_PASSWORD";
        public static final String FULLNAME = "G_FULLNAME";
        public static final String USERNAME = "G_USERNAME";
        public static final String AVATAR  = "G_AVATAR";
        public static final String EMAIL = "G_EMAIL";
        public static final String STATUS = "G_STATUS";
        public static final String FACEBOOK_LINK = "G_FACEBOOK_LINK";
        public static final String JOB = "G_JOB";
        public static final String DEPARTMENT = "G_DEPARTMENT";
        public static final String HOBBY = "G_HOBBY";
    }
}
