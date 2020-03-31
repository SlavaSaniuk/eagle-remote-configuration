package by.bsac.webmvc.controllers;

import by.bsac.domain.models.Project;
import by.bsac.services.impls.ProjectsCrudService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static by.bsac.core.logging.SpringCommonLogging.*;

@RestController("ProjectsController")
public class ProjectsController {

    //Logger
    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectsController.class);
    //Spring beans
    private ProjectsCrudService PROJECTS_SERVICE;

    //Constructor
    @Autowired
    public ProjectsController(ProjectsCrudService a_projects_service) {
        LOGGER.info(CREATION.startCreateBean(BeanDefinition.of(ProjectsController.class)));

        LOGGER.debug(DependencyManagement.autowireViaConstructor(
                BeanDefinition.of(ProjectsCrudService.class), ProjectsController.class));
        this.PROJECTS_SERVICE = a_projects_service;
    }

    @PostMapping(value = "/project_create", headers = {"content-type=application/json"}, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Project createProjects(@RequestBody Project project) {
        return this.PROJECTS_SERVICE.create(project);
    }

    @GetMapping(value = "/project_get_all", headers = {"content-type=application/json"}, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Project> getProjects() {
        return this.PROJECTS_SERVICE.getAllProjects();
    }
}
