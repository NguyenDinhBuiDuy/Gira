package cybersoft.javabackend.java11.gira.project.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cybersoft.javabackend.java11.gira.commondata.model.ResponseHandler;
import cybersoft.javabackend.java11.gira.project.dto.CreateProjectDTO;
import cybersoft.javabackend.java11.gira.project.model.Project;
import cybersoft.javabackend.java11.gira.project.service.ProjectService;

@RestController
@RequestMapping ("/api/project")
public class ProjectController {
	
	@Autowired
	private ProjectService _service;
	
	@GetMapping ("")
	public ResponseEntity<Object> findAllProject(){
		List<Project> projects = _service.findAll();
		if (projects.isEmpty())
			return ResponseHandler.getResponse("there is no data", HttpStatus.OK);
		return ResponseHandler.getResponse(projects,HttpStatus.OK);
	}
	
	@PostMapping ("")
	public ResponseEntity<Object> CreateNewProject (@Valid @RequestBody CreateProjectDTO dto, BindingResult bidingResult){
		
	}

}
