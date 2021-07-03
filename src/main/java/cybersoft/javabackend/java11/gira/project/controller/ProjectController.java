package cybersoft.javabackend.java11.gira.project.controller;

import java.util.List;

import javax.validation.Valid;

import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cybersoft.javabackend.java11.gira.commondata.model.ResponseHandler;
import cybersoft.javabackend.java11.gira.project.dto.CreateProjectDTO;
import cybersoft.javabackend.java11.gira.project.dto.UpdateProjectDTO;
import cybersoft.javabackend.java11.gira.project.model.Project;
import cybersoft.javabackend.java11.gira.project.service.ProjectService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping ("/api/project")
public class ProjectController {
	
	private ProjectService _service;
	
	@GetMapping ("")
	public ResponseEntity<Object> findAllProject(){
		List<Project> projects = _service.findAll();
		if (projects.isEmpty())
			return ResponseHandler.getResponse("there is no data", HttpStatus.OK);
		return ResponseHandler.getResponse(projects,HttpStatus.OK);
	}
	
	@PostMapping ("")
	public ResponseEntity<Object> createNewProject (@Valid @RequestBody CreateProjectDTO dto, BindingResult bindingResult){
		if (bindingResult.hasErrors())
			return ResponseHandler.getResponse(bindingResult, HttpStatus.BAD_REQUEST);
		Project project = _service.save(dto);
		return ResponseHandler.getResponse(project, HttpStatus.OK);		
	}
	
	@PutMapping("/{project_id}")
	public ResponseEntity<Object> updateProject (@Valid @RequestBody UpdateProjectDTO dto, @PathVariable ("project_id") Long id, BindingResult bindingResult){
		if (bindingResult.hasErrors())
			return ResponseHandler.getResponse(HttpStatus.BAD_REQUEST);
		Project updateProject = _service.updateProjectInfo(dto, id);
		return ResponseHandler.getResponse(updateProject, HttpStatus.OK);
	}

}
