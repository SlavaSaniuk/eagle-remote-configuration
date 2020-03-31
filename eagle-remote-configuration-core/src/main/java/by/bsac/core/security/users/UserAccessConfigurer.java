package by.bsac.core.security.users;

import by.bsac.domain.models.User;

import java.util.List;

/**
 * This interface define methods to configure {@link UserAccessManager} service bean. Application automatically create
 * {@link UserAccessConfigurer} service bean, implemented by {@link UserAccessConfigurerImpl} class. You can configure
 * {@link UserAccessConfigurer} bean via
 * {@link by.bsac.core.RemoteConfigurationConfigurer#configureUserAccess(UserAccessConfigurer)} methods;
 */
public interface UserAccessConfigurer {

    /**
     * Add new {@link User} object which can use RemoteConfiguration features. This users are "ALLOWED" users;
     * @param a_user - {@link User} instance;
     */
    void addUser(User a_user);

    /**
     * Return list of allowed {@link User}.
     * @return - allowed {@link User}'s;
     */
    List<User> getAllowedUsers();

}
