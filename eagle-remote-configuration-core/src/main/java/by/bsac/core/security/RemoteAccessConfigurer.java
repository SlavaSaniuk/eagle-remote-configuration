package by.bsac.core.security;

public interface RemoteAccessConfigurer {

    default void allowIpAddress(String ip_address){};
}
