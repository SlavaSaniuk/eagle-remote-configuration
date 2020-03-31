package by.bsac.domain.http;

import by.bsac.domain.models.RCProperties;
import by.bsac.domain.models.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * {@link RCRequestBody} DTO object used for exchanging information between remote configuration server/client
 * instances. This DTO has {@link RCRequestBody#getRcProperties()} object for hold retrieved or changed configuration
 * properties, {@link RCRequestBody#getRcUser()} object to identify configuration user.
 */
@Getter @Setter
@NoArgsConstructor
@ToString
public class RCRequestBody implements Serializable {

    private RCProperties rcProperties;

    private User rcUser;

}
