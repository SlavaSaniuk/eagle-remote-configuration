package by.bsac.core;

import java.util.Properties;

/**
 * Main remote configuration service bean. Create service bean that's implement this interface to use
 * this in remote configuration process. You must to implements 2 methods to configure application
 * configuration properties.
 */
public interface RemoteConfigurer {

    /**
     * Method return available configuration properties to server instance via defined controllers methods.
     * @return - Configured {@link Properties} object of configuration properties.
     */
    Properties loadProperties();

    /**
     * Method save changed configuration properties, received from remote-configuration server,
     * in configuration file.
     * @param a_props - Changed configuration {@link Properties}.
     * @param a_comment - {@link String} comment in properties file.
     */
    void saveProperties(Properties a_props, String a_comment);

}
