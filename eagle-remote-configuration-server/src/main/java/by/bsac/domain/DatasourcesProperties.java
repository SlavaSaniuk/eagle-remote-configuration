package by.bsac.domain;

import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;

import static by.bsac.core.logging.SpringCommonLogging.*;

@ConfigurationProperties(prefix = "eagle.rc.domain.datasource")
@Getter
public class DatasourcesProperties {

    //Logger
    private static final Logger LOGGER = LoggerFactory.getLogger(DatasourcesProperties.class);
    //Inner classes
    private final Development development = new Development();
    private final Test tests = new Test();

    //Constructor
    public DatasourcesProperties() {
        LOGGER.debug(CREATION.startCreateBean(BeanDefinition.of(DatasourcesProperties.class)));
    }

    @Getter @Setter
    public static class Development {

        private String db_url;
        private String db_driver;
        private String db_user;
        private String db_password;

        @Override
        public String toString() {
            return "Development{" +
                    "db_url='" + db_url + '\'' +
                    ", db_port='" + db_driver + '\'' +
                    '}';
        }
    }

    @Getter @Setter
    public static class Test {

        private String db_url;
        private String db_driver;
        private String db_user;
        private String db_password;

        @Override
        public String toString() {
            return "Test{" +
                    "db_url='" + db_url + '\'' +
                    ", db_driver='" + db_driver + '\'' +
                    '}';
        }
    }
}
