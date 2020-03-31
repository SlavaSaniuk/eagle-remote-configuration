package by.bsac.domain.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

@Getter @Setter
@ToString
@NoArgsConstructor
public class RCProperties implements Serializable {

    //Class variables
    private Map<String, String> configurationProperties = new HashMap<>();

    //Constructors
    public RCProperties(Properties a_conf_properties) {

        this.configurationProperties.putAll(
                a_conf_properties.entrySet().stream().
                        collect(Collectors.toMap(e -> e.getKey().toString(), e -> e.getValue().toString())));

    }

    public Properties of() {
        Properties props =  new Properties();
        props.putAll(this.configurationProperties);
        return props;
    }


}
