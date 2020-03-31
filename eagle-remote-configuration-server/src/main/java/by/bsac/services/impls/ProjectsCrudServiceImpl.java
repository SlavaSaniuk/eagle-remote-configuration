package by.bsac.services.impls;

import by.bsac.domain.models.Project;
import by.bsac.repositories.ProjectsCrudRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import static by.bsac.core.logging.SpringCommonLogging.*;

public class ProjectsCrudServiceImpl implements ProjectsCrudService {

    //Logger
    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectsCrudServiceImpl.class);
    //Spring beans
    private ProjectsCrudRepository projects_repository;

    //Constructor
    public ProjectsCrudServiceImpl(ProjectsCrudRepository a_repository) {
        LOGGER.debug(CREATION.startCreateBean(BeanDefinition.of(ProjectsCrudServiceImpl.class)));

        LOGGER.debug(DependencyManagement.autowireViaConstructor(BeanDefinition.of(ProjectsCrudRepository.class), ProjectsCrudServiceImpl.class));
        this.projects_repository = a_repository;
    }

    @Override
    @Transactional
    public Project create(Project entity) {

        if (entity == null)
            throw new NullPointerException("Project entity is null;");
        if (entity.getProjectTitle() == null || entity.getProjectTitle().isEmpty())
            throw new IllegalArgumentException("Project title is null or empty;");

        return this.projects_repository.save(entity);
    }

    @Override
    public Project getById(Integer id) {
        return null;
    }

    @Override
    public List<Project> getAllProjects() {
        return (List<Project>) this.projects_repository.findAll();
    }
}
