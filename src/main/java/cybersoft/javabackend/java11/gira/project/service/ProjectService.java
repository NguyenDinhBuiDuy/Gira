package cybersoft.javabackend.java11.gira.project.service;

import javax.validation.Valid;

import cybersoft.javabackend.java11.gira.commondata.GenericService;
import cybersoft.javabackend.java11.gira.project.dto.CreateProjectDTO;
import cybersoft.javabackend.java11.gira.project.dto.UpdateProjectDTO;
import cybersoft.javabackend.java11.gira.project.model.Project;

public interface ProjectService extends GenericService<Project, Long>{

	Project save(@Valid CreateProjectDTO dto);

	Project updateProjectInfo(@Valid UpdateProjectDTO dto, Long id);

	boolean isTakenProjectCode(String projectCode);
	
	boolean isTakenProjectName(String projectName);

}
