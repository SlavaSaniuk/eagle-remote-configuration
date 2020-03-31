package by.bsac.core.security.users;

import by.bsac.domain.models.User;

/**
 * UserAccessManager interface define a contract to resolve user access for remote configuration.
 * Interface define a methods to check if user is allowed for configuration.
 */
public interface UserAccessManager {

    /**
     * Check if user is allowed for remote configuration by user name {@link User#getUserName()}.
     * @param a_user - {@link User} with defined user name.
     * @return - 'true' - if user allowed for remote configuration.
     */
    boolean isUserAllowed(User a_user);

    /**
     * Check if given user object has a same password as a allowed user in {@link UserAccessConfigurer#getAllowedUsers()} users store.
     * @param a_user - {@link User} with defined user name and password;
     * @return - 'true' - if user has a same password.
     */
    boolean compareUserPassword(User a_user);

}
