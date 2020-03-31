package by.bsac.core.security.users;

import by.bsac.domain.models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;

/**
 * Default implementation of {@link UserAccessManager} interface. This bean implements UserAccessManager interface
 * with values specified in {@link UserAccessConfigurer} service bean. Before create a bean instance of this class
 * you need to create {@link UserAccessConfigurer} service bean and initialize them
 * via {@link by.bsac.core.RemoteConfigurationConfigurer#configureUserAccess(UserAccessConfigurer)} method.
 */
public class UserAccessManagerImpl implements UserAccessManager {

    //Logger
    private static final Logger LOGGER = LoggerFactory.getLogger(UserAccessManagerImpl.class);
    //Spring beans
    private UserAccessConfigurer USER_ACCESS_CONFIGURER;

    /**
     * Construct new {@link UserAccessManagerImpl} service bean with configured values in {@link UserAccessConfigurer} service bean.
     * @param a_configurer - {@link UserAccessConfigurer} service bean.
     */
    public UserAccessManagerImpl(UserAccessConfigurer a_configurer) {

        LOGGER.debug(String.format("Start to create [%s] service bean.",
                UserAccessManagerImpl.class.getCanonicalName()));

        LOGGER.debug(String.format("Set [%s] service bean to [%s] service bean via constructor parameter;",
                UserAccessConfigurer.class.getCanonicalName(), UserAccessManagerImpl.class.getCanonicalName()));
        this.USER_ACCESS_CONFIGURER = a_configurer;


    }

    @Override
    public boolean isUserAllowed(User a_user) {
        return this.USER_ACCESS_CONFIGURER.getAllowedUsers().stream().anyMatch(u -> u.getUserName().equals(a_user.getUserName()));
    }

    @Override
    public boolean compareUserPassword(User a_user) {
        //noinspection ConstantConditions
        return this.getUserByName(a_user.getUserName()).getUserPassword().equals(a_user.getUserPassword());
    }

    /**
     * Method search {@link User} instance if {@link UserAccessConfigurer#getAllowedUsers()} store with given name.
     * @param user_name - user name;
     * @return - return {@link User} if user founded? or null in otherwise.
     */
    public @Nullable User getUserByName(String user_name) {
        return this.USER_ACCESS_CONFIGURER.getAllowedUsers().stream().filter(u -> u.getUserName().equals(user_name)).findFirst().orElse(null);
    }
}
