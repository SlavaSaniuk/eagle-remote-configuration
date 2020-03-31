package by.bsac.services;

import by.bsac.Main;
import by.bsac.domain.models.Project;
import by.bsac.services.impls.ProjectsCrudService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@ActiveProfiles("DATASOURCE_TESTS")
@SpringBootTest(classes = Main.class)
public class ProjectsCrudServiceIntegrationTests {

    //Logger
    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectsCrudServiceIntegrationTests.class);
    //Spring beans
    @Autowired
    private ProjectsCrudService SERVICE;

    @Test
    void create_newProjectEntity_shouldReturnCreatedProjectEntityWithGeneratedId() {

        String EXPECTED_PROJECT_TITLE = "TEST_PROJECT_TITLE";

        Project project = new Project();
        project.setProjectTitle(EXPECTED_PROJECT_TITLE);

        Project CREATED = this.SERVICE.create(project);

        Assertions.assertNotNull(CREATED);
        Assertions.assertNotNull(CREATED.getProjectId());
        Assertions.assertNotNull(CREATED.getProjectTitle());
        Assertions.assertEquals(EXPECTED_PROJECT_TITLE, CREATED.getProjectTitle());

        LOGGER.debug("Created project: " +CREATED);
    }

    @Test
    void getAllProjects_fewProjects_shouldReturnThem() {

        List<Project> all_projects = this.SERVICE.getAllProjects();

        Assertions.assertNotNull(all_projects);
        Assertions.assertNotEquals(0, all_projects);

        LOGGER.debug("Projects: ");
        all_projects.forEach(p -> LOGGER.debug(p.toString()));
    }
}
