package by.bsac.exceptions;

import by.bsac.core.security.users.UserAccessConfigurer;
import by.bsac.domain.models.User;

/**
 * {@link UserNotAllowedException} thrown in case when {@link User} try to load/save configuration properties, but it's
 * not allowed via {@link by.bsac.core.RemoteConfigurationConfigurer#configureUserAccess(UserAccessConfigurer)}.
 */
public class UserNotAllowedException extends AuthenticationException {

    /**
     * Construct new {@link UserNotAllowedException} with authentication failure message
     * "Given user[user_name="NameOfUser"] not allowed."
     * @param a_user - {@link User} model.
     */
    public UserNotAllowedException(User a_user) {
        super(String.format("Given user[%s] not allowed.", a_user));
    }
}
