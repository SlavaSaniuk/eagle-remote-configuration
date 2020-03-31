package by.bsac.exceptions;

/**
 * Super class for all authentication process exception (Such as {@link UserNotAllowedException}).
 * Note: This class extends {@link RuntimeException}, but for best practice catch this exceptions
 * to inform "remote configuration server" about fail of authentication process.
 */
public class AuthenticationException extends RuntimeException {

    /**
     * Construct new {@link AuthenticationException} object. Used by {@link AuthenticationException} child instances.
     * @param msg - {@link String} authentication failure message.
     */
    protected AuthenticationException(String msg) {
        super(msg);
    }
}
