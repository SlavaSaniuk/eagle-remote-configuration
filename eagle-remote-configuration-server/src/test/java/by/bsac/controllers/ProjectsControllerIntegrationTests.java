package by.bsac.controllers;

import by.bsac.Main;
import by.bsac.domain.models.Project;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ActiveProfiles("DATASOURCE_TESTS")
@SpringBootTest(classes = Main.class)
@AutoConfigureMockMvc
public class ProjectsControllerIntegrationTests {

    //Logger
    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectsControllerIntegrationTests.class);
    //Spring beans
    @Autowired
    private MockMvc MVC;
    @Autowired
    private ObjectMapper MAPPER;

    @Test
    void createProject_newProjectEntity_shouldReturnCreatedProjectWithGeneratedId() throws Exception {

        Project project = new Project();
        project.setProjectTitle("TEST_PROJECT_TITLE");
        LOGGER.debug("SOURCE PROJECT: " +project);

        String SRC_JSON = this.MAPPER.writeValueAsString(project);
        LOGGER.debug("SOURCE JSON: " +SRC_JSON);

        String RESP_JSON = this.MVC.perform(
                MockMvcRequestBuilders.get("/project_create")
        .contentType(MediaType.APPLICATION_JSON)
        .content(SRC_JSON))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andDo(print(System.out))
        .andReturn().getResponse().getContentAsString();

        LOGGER.debug("RESPONSE JSON: " +RESP_JSON);

        Project CREATED = this.MAPPER.readValue(RESP_JSON, Project.class);

        Assertions.assertNotNull(CREATED);
        Assertions.assertNotNull(CREATED.getProjectId());

        LOGGER.debug("CREATED PROJECT: " +CREATED);

    }

    @Test
    void getProjects_fewProjectsExist_shouldReturnProjects() throws Exception {

        String RESP_JSON = this.MVC.perform(
                MockMvcRequestBuilders.get("/project_get_all")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andDo(print(System.out))
                .andReturn().getResponse().getContentAsString();

        Assertions.assertNotNull(RESP_JSON);
        LOGGER.debug("Response JSON" +RESP_JSON);

        List<Project> projects = this.MAPPER.readValue(RESP_JSON, new TypeReference<List<Project>>() {});
        Assertions.assertNotNull(projects);

        LOGGER.debug("Projects: ");
        projects.forEach(p -> LOGGER.debug(p.toString()));
    }
}
