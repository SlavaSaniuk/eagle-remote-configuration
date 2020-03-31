package by.bsac.core.decorator;

import by.bsac.domain.http.RCRequestBody;
import by.bsac.domain.models.RCProperties;

/**
 * Interface define contract to customize default {@link by.bsac.core.RemoteConfigurer} service bean and add support
 * to exchange configuration information between remote configuration server and client application.
 */
public interface HttpRemoteConfigurerDecorator {

    /**
     *  By default, method load configuration properties via {@link by.bsac.core.RemoteConfigurer} service bean and
     * convert it to {@link by.bsac.domain.models.RCProperties} DTO object.
     * @param req_body - {@link RCRequestBody} DTO object with any other defined fields which used by other decorators.
     * @return - {@link RCRequestBody} with configuration properties.
     */
    RCRequestBody loadRCProperties(RCRequestBody req_body);

    /**
     * Method save configuration properties, received from server, via {@link by.bsac.core.RemoteConfigurer} service
     * bean. Method get {@link java.util.Properties} from {@link RCRequestBody} via {@link RCProperties#of()} and try
     * to save it via {@link by.bsac.core.RemoteConfigurer} service bean.
     * @param req_body - {@link RCRequestBody} DTO object with changed configuration properties and any other defined
     *                fields which used by other decorators.
     * @param a_comment - {@link String} comment, created by any other decorators.
     */
    void saveRCProperties(RCRequestBody req_body, String a_comment);

}
