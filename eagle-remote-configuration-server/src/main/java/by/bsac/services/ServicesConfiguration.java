package by.bsac.services;

import by.bsac.repositories.ProjectsCrudRepository;
import by.bsac.services.impls.ProjectsCrudService;
import by.bsac.services.impls.ProjectsCrudServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static by.bsac.core.logging.SpringCommonLogging.*;

@Configuration("ServicesConfiguration")
public class ServicesConfiguration {

    //Logger
    private static final Logger LOGGER = LoggerFactory.getLogger(ServicesConfiguration.class);
    //Spring beans
    private ProjectsCrudRepository projects_repository;

    //Constructor
    public ServicesConfiguration() {
        LOGGER.info(INITIALIZATION.startInitializeConfiguration(ServicesConfiguration.class));
    }

    //Beans
    @Bean("ProjectsCrudService")
    public ProjectsCrudService getProjectsCrudService() {
        LOGGER.info(CREATION.startCreateBean(BeanDefinition.of(ProjectsCrudService.class)));
        ProjectsCrudServiceImpl service = new ProjectsCrudServiceImpl(this.projects_repository);

        LOGGER.info(CREATION.endCreateBean(BeanDefinition.of(ProjectsCrudService.class)));
        return service;
    }

    @Autowired
    public void setProjectsCrudRepository(ProjectsCrudRepository a_projects_repository) {
        LOGGER.info(DependencyManagement.autowireViaSetter(BeanDefinition.of(ProjectsCrudRepository.class), ServicesConfiguration.class));
        this.projects_repository = a_projects_repository;
    }
}
