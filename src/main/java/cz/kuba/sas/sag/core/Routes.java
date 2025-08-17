package cz.kuba.sas.sag.core;

public class Routes {
    public static final String PUBLIC = "/public";

    public static class Auth {
        public static final String AUTH = "/auth";
        public static final String LOGIN = "/login";
    }

    public static class Accounts {
        public static final String ACCOUNTS = "/accounts";
        public static final String PUBLIC = Routes.PUBLIC + ACCOUNTS;

        public static final String ACCOUNT_ID = "accountId";
        public static final String ACCOUNT_ID_PARAM = "/{" + ACCOUNT_ID + "}";
    }

    public static class Services {
        public static final String SERVICES = "/services";
        public static final String PUBLIC = Routes.PUBLIC + SERVICES;
        public static final String SYSTEM = "/system" + SERVICES;

        public static final String SERVICE_ID = "serviceId";
        public static final String SERVICE_ID_PARAM = "/{" + SERVICE_ID + "}";
    }
}
