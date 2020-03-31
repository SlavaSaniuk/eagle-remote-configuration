package by.bsac.repositories;

import by.bsac.Main;
import by.bsac.domain.models.Project;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

@ActiveProfiles("DATASOURCE_TESTS")
@SpringBootTest(classes = Main.class)
public class ProjectsCrudRepositoryIntegrationTests {

    //Logger
    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectsCrudRepositoryIntegrationTests.class);
    //Spring beans
    @Autowired
    private ProjectsCrudRepository REPOSITORY;


    @Test
    @Transactional
    void save_ProjectEntity_shouldReturnProjectEntityWithGeneratedId() {

        String EXPECTED_PROJECT_TITLE = "test-project";

        Project project = new Project();
        project.setProjectTitle(EXPECTED_PROJECT_TITLE);

        Project CREATED_PROJECT = this.REPOSITORY.save(project);

        Assertions.assertNotNull(CREATED_PROJECT);

        Assertions.assertNotNull(CREATED_PROJECT.getProjectId());
        Assertions.assertNotNull(CREATED_PROJECT.getProjectTitle());
        Assertions.assertEquals(EXPECTED_PROJECT_TITLE, CREATED_PROJECT.getProjectTitle());

        LOGGER.debug("Created project: " +CREATED_PROJECT);

    }
}
