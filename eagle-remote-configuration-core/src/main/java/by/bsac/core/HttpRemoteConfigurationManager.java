package by.bsac.core;

import by.bsac.domain.http.RCRequestBody;

public interface HttpRemoteConfigurationManager {

    RCRequestBody loadRCProperties(RCRequestBody a_body);

    void saveRCProperties(RCRequestBody a_body);

}
