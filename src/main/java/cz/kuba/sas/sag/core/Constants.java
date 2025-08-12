package cz.kuba.sas.sag.core;

public class Constants {

    public static class Paths {
        public static final String PUBLIC = "/public";

        public static class Auth {
            public static final String AUTH = "/auth";
            public static final String LOGIN = "/login";
        }

        public static class Accounts {
            public static final String ACCOUNTS = "/accounts";
            public static final String PUBLIC = Paths.PUBLIC + ACCOUNTS;
            public static final String ACCOUNT_ID = "/{accountId}";
        }

        public static class Services {
            public static final String SERVICES = "/services";
            public static final String PUBLIC = Paths.PUBLIC + SERVICES;
            public static final String SYSTEM = "/system" + SERVICES;
            public static final String SERVICE_ID = "/{serviceId}";
        }
    }
}
