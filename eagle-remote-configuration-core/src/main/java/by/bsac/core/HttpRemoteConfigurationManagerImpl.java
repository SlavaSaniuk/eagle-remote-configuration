package by.bsac.core;

import by.bsac.core.decorator.UserAccessRemoteConfigurerDecorator;
import by.bsac.domain.http.RCRequestBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Default implementation of {@link HttpRemoteConfigurationManager} service bean.
 */
public class HttpRemoteConfigurationManagerImpl implements HttpRemoteConfigurationManager {

    //Logger
    private static final Logger LOGGER = LoggerFactory.getLogger(HttpRemoteConfigurationManagerImpl.class);
    //Spring beans
    private UserAccessRemoteConfigurerDecorator UA_DECORATOR;

    //Constructor
    public HttpRemoteConfigurationManagerImpl(UserAccessRemoteConfigurerDecorator a_decorator) {

        LOGGER.debug(String.format("Start to create [%s] service bean.",
                HttpRemoteConfigurationManagerImpl.class.getCanonicalName()));

        LOGGER.debug(String.format("Set [%s] service bean to [%s] service bean via constructor parameter;",
                UserAccessRemoteConfigurerDecorator.class.getCanonicalName(), HttpRemoteConfigurationManagerImpl.class.getCanonicalName()));
        this.UA_DECORATOR = a_decorator;
    }

    @Override
    public RCRequestBody loadRCProperties(RCRequestBody req_body) {
        return this.UA_DECORATOR.loadRCProperties(req_body);
    }

    @Override
    public void saveRCProperties(RCRequestBody req_body) {
        final String COMMENT = " Updated configuration properties ";
        this.UA_DECORATOR.saveRCProperties(req_body, COMMENT);
    }
}
