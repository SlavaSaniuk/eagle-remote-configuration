package by.bsac.core.decorator;

import by.bsac.core.RemoteConfigurer;
import by.bsac.domain.http.RCRequestBody;
import by.bsac.domain.models.RCProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.Properties;

/**
 * Default implementation of {@link HttpRemoteConfigurerDecorator} contract. This service bean support relationship
 * between {@link RemoteConfigurer} and {@link HttpRemoteConfigurerDecorator} properties configuration.
 */
public class RemoteConfigurerDecorator implements HttpRemoteConfigurerDecorator {

    //Logger
    private static final Logger LOGGER = LoggerFactory.getLogger(RemoteConfigurerDecorator.class);
    //Spring beans
    private RemoteConfigurer REMOTE_CONFIGURER;

    /**
     * Construct new {@link RemoteConfigurerDecorator} service bean, which translate
     * http request to {@link RemoteConfigurer} bean.
     * @param a_configurer - {@link RemoteConfigurer} service bean.
     */
    public RemoteConfigurerDecorator(RemoteConfigurer a_configurer) {

        LOGGER.debug(String.format("Start to create [%s] service bean;",
                RemoteConfigurerDecorator.class.getCanonicalName()));

        //Autowire remote configurer
        LOGGER.debug(String.format("Set [%s] service bean to [%s] service bean via constructor.",
                RemoteConfigurer.class.getCanonicalName(), RemoteConfigurerDecorator.class.getCanonicalName()));
        this.REMOTE_CONFIGURER = a_configurer;
    }

    /**
     * Method use {@link RemoteConfigurer#loadProperties()}.
     * @return - {@link Properties} configuration properties.
     */
    public Properties loadProperties() {
        return this.REMOTE_CONFIGURER.loadProperties();
    }

    /**
     * Method use {@link RemoteConfigurer#saveProperties(Properties, String)}.
     * @param a_props - {@link Properties} object;
     * @param a_comment - Properties comment;
     */
    public void saveProperties(Properties a_props, String a_comment) {
        this.REMOTE_CONFIGURER.saveProperties(a_props, a_comment);
    }

    @Override
    public RCRequestBody loadRCProperties(RCRequestBody req_body) {
        RCRequestBody response = new RCRequestBody();
        response.setRcProperties(new RCProperties(this.loadProperties()));
        return response;
    }

    @Override
    public void saveRCProperties(RCRequestBody req_body, String a_comment) {

        //Add timestamp comment
        final String COMMENT = String.format("%s at [%s].", a_comment, LocalDateTime.now().toString());

        this.saveProperties(req_body.getRcProperties().of(), COMMENT);
    }
}
