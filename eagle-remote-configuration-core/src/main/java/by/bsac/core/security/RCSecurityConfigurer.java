package by.bsac.core.security;

import by.bsac.core.security.users.UserAccessConfigurer;

public interface RCSecurityConfigurer {

    default void configureUserAccess(UserAccessConfigurer a_configurer) {}

}
