package by.bsac.domain;

import by.bsac.domain.models.Project;
import by.bsac.repositories.ProjectsCrudRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

import static by.bsac.core.logging.SpringCommonLogging.*;

@Configuration("DatasourcesConfiguration")
@EnableConfigurationProperties(DatasourcesProperties.class)
@EntityScan(basePackageClasses = Project.class)
@EnableJpaRepositories(basePackageClasses = ProjectsCrudRepository.class)
@EnableTransactionManagement
public class DatasourcesConfiguration {

    //Logger
    private static final Logger LOGGER = LoggerFactory.getLogger(DatasourcesConfiguration.class);
    //Spring beans
    private DatasourcesProperties datasources_properties;  //Autowired via setter

    //Constructor
    public DatasourcesConfiguration() {
        LOGGER.info(INITIALIZATION.startInitializeConfiguration(DataSourceAutoConfiguration.class));
    }

    @Bean("DataSource")
    @Profile("DATASOURCE_DEVELOPMENT")
    public DataSource developmentDataSource() {
        LOGGER.info(CREATION.startCreateBean(BeanDefinition.forProfile("DATASOURCE_DEVELOPMENT")));
        DriverManagerDataSource ds = new DriverManagerDataSource();

        ds.setUrl(this.datasources_properties.getDevelopment().getDbUrl());
        ds.setDriverClassName(this.datasources_properties.getDevelopment().getDbDriver());
        ds.setUsername(this.datasources_properties.getDevelopment().getDbUser());
        ds.setPassword(this.datasources_properties.getDevelopment().getDbPassword());

        LOGGER.info(CREATION.endCreateBean(BeanDefinition.of(DataSource.class)));
        return ds;
    }

    @Bean("DataSource")
    @Profile("DATASOURCE_TESTS")
    public DataSource testDataSource() {

        DriverManagerDataSource ds = new DriverManagerDataSource();

        ds.setUrl(this.datasources_properties.getTests().getDbUrl());
        ds.setDriverClassName(this.datasources_properties.getTests().getDbDriver());
        ds.setUsername(this.datasources_properties.getTests().getDbUser());
        ds.setPassword(this.datasources_properties.getTests().getDbPassword());

        return ds;
    }

    @Autowired
    public void setDatasourcesProperties(DatasourcesProperties a_properties) {
        this.datasources_properties = a_properties;
    }
}
