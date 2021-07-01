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
import cybersoft.javabackend.java11.gira.project.model.ProjectType;
import cybersoft.javabackend.java11.gira.project.service.ProjectTypeService;

@RestController
@RequestMapping("/api/project/type")
public class ProjectTypeController {
	@Autowired
	private ProjectTypeService _service;
	
	@GetMapping
	public ResponseEntity<Object> findallProjectType(){
		List<ProjectType> projectTypes = _service.findAll();
		if (projectTypes.isEmpty())
			return ResponseHandler.getResponse("there is no data, ", HttpStatus.BAD_REQUEST);
		return ResponseHandler.getResponse(projectTypes, HttpStatus.OK);
			
	}
	
	@PostMapping
	public ResponseEntity<Object> addProjectType( @Valid @RequestBody ProjectType projectType, BindingResult bindingResult){
		if (bindingResult.hasErrors())
			return ResponseHandler.getResponse(HttpStatus.BAD_REQUEST);
		ProjectType projectType2 = _service.save(projectType);
	return ResponseHandler.getResponse(projectType2, HttpStatus.OK);
	}

}
