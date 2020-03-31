package by.bsac.core.decorator;

import by.bsac.core.security.users.UserAccessConfigurer;
import by.bsac.core.security.users.UserAccessManager;
import by.bsac.domain.http.RCRequestBody;
import by.bsac.domain.models.User;
import by.bsac.exceptions.UserNotAllowedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * {@link UserAccessRemoteConfigurerDecorator} service bean implements {@link HttpRemoteConfigurerDecorator} decorator
 * interface. This decorator add user's authentication feature. Before load or save configuration properties method try
 * to authenticate configuration user. Configure user access via
 * {@link by.bsac.core.RemoteConfigurationConfigurer#configureUserAccess(UserAccessConfigurer)}to allow
 * configuration users.
 */
public class UserAccessRemoteConfigurerDecorator implements HttpRemoteConfigurerDecorator {

    //Logger
    private static final Logger LOGGER = LoggerFactory.getLogger(UserAccessRemoteConfigurerDecorator.class);
    //Spring beans
    private RemoteConfigurerDecorator RC_DECORATOR;
    private UserAccessManager UA_MANAGER;

    /**
     * Construct new {@link UserAccessRemoteConfigurerDecorator} service bean.
     * @param a_decorator - {@link RemoteConfigurerDecorator} bean impl.
     * @param a_manager - {@link UserAccessManager} service bean.
     */
    public UserAccessRemoteConfigurerDecorator(RemoteConfigurerDecorator a_decorator, UserAccessManager a_manager) {

        LOGGER.debug(String.format("Start to create [%s] service bean.",
                UserAccessRemoteConfigurerDecorator.class.getCanonicalName()));

        LOGGER.debug(String.format("Set [%s] service bean to [%s] service bean via constructor parameter;",
                RemoteConfigurerDecorator.class.getCanonicalName(), UserAccessRemoteConfigurerDecorator.class.getCanonicalName()));
        this.RC_DECORATOR = a_decorator;

        LOGGER.debug(String.format("Set [%s] service bean to [%s] service bean via constructor parameter;",
                RemoteConfigurerDecorator.class.getCanonicalName(), UserAccessRemoteConfigurerDecorator.class.getCanonicalName()));
        this.UA_MANAGER = a_manager;
    }

    @Override
    public RCRequestBody loadRCProperties(RCRequestBody req_body) {

        //Check if user have access to load configuration properties
        LOGGER.debug(String.format("Try to authenticate given user[%s]", req_body.getRcUser()));
        if (!this.authenticateUser(req_body.getRcUser()))
            throw new UserNotAllowedException(req_body.getRcUser());

        //Load properties
        LOGGER.debug(String.format("Load configuration properties via [%s] service bean", this.RC_DECORATOR.getClass().getCanonicalName()));
        return this.RC_DECORATOR.loadRCProperties(req_body);
    }

    @Override
    public void saveRCProperties(RCRequestBody req_body, String a_comment) {

        //Add to comment user info
        String COMMENT = String.format("%s by user[%s]", a_comment, req_body.getRcUser());

        //Check if user have access to save configuration properties
        LOGGER.debug(String.format("Try to authenticate given user[%s]", req_body.getRcUser()));
        if (!this.authenticateUser(req_body.getRcUser()))
            throw new UserNotAllowedException(req_body.getRcUser());

        //Save properties
        LOGGER.debug(String.format("Save configuration properties via [%s] service bean", this.RC_DECORATOR.getClass().getCanonicalName()));
        this.RC_DECORATOR.saveRCProperties(req_body, COMMENT);
    }

    /**
     *  Method determine if user allowed for configuration.
     * @param a_user - {@link User} configuration user.
     * @return - 'true' if user allowed for configuration.
     */
    @SuppressWarnings("BooleanMethodIsAlwaysInverted")
    public boolean authenticateUser(User a_user) {

        //Check if user allowed by user name
        LOGGER.trace("Compare user names;");
        if (!this.UA_MANAGER.isUserAllowed(a_user))
            return false;

        //Compare user's passwords
        LOGGER.trace("Compare user password;");
        return this.UA_MANAGER.compareUserPassword(a_user);
    }


}
