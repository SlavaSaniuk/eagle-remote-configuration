package by.bsac.services.impls;


import by.bsac.domain.models.Project;
import by.bsac.services.CrudService;

import java.util.List;

//@Service("ProjectsCrudService")
public interface ProjectsCrudService extends CrudService<Project, Integer> {

    List<Project> getAllProjects();
}
