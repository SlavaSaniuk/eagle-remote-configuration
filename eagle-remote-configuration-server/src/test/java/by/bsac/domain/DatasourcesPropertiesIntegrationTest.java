package by.bsac.domain;

import by.bsac.Main;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = Main.class)
@ActiveProfiles("DATASOURCE_TESTS")
public class DatasourcesPropertiesIntegrationTest {

    //Logger
    private static final Logger LOGGER = LoggerFactory.getLogger(DatasourcesPropertiesIntegrationTest.class);
    //Spring beans
    @Autowired
    private DatasourcesProperties PROPS;

    @Test
    @Disabled
    void getDevelopment_applicationPropertiesFileExist_shouldReturnConfigurationProperties() {

        DatasourcesProperties.Development dev = this.PROPS.getDevelopment();

        Assertions.assertNotNull(dev);
        Assertions.assertNotNull(dev.getDbUrl());
        Assertions.assertNotNull(dev.getDbDriver());

        LOGGER.debug("Development configuration properties: " +dev);

    }

    @Test
    void getTests_applicationPropertiesFileExist_shouldReturnConfigurationProperties() {

        DatasourcesProperties.Test test = this.PROPS.getTests();

        Assertions.assertNotNull(test);
        Assertions.assertNotNull(test.getDbUrl());
        Assertions.assertNotNull(test.getDbDriver());

        LOGGER.debug("Tests configuration properties: " +test);

    }
}
