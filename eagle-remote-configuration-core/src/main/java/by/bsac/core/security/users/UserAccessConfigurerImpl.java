package by.bsac.core.security.users;

import by.bsac.domain.models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Default implementation of {@link UserAccessConfigurer} service bean.
 */
public class UserAccessConfigurerImpl implements UserAccessConfigurer {

    //Logger
    private static final Logger LOGGER = LoggerFactory.getLogger(UserAccessConfigurerImpl.class);
    //Class variables
    private final List<User> ALLOWED_USERS = new ArrayList<>();

    //Constructors
    /**
     * Construct new {@link UserAccessConfigurerImpl} service bean.
     */
    public UserAccessConfigurerImpl() {
        LOGGER.debug(String.format("Start to create [%s] service bean.",
                UserAccessConfigurerImpl.class.getCanonicalName()));
    }

    @Override
    public void addUser(User a_user) {
        this.ALLOWED_USERS.add(a_user);
    }

    @Override
    public List<User> getAllowedUsers() {
        return this.ALLOWED_USERS;
    }


}
