package cybersoft.javabackend.java11.gira.role.controller;

import java.util.List;

import javax.validation.Valid;

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

import cybersoft.javabackend.java11.gira.role.dto.CreateRoleGroupDTO;
import cybersoft.javabackend.java11.gira.role.model.Role;
import cybersoft.javabackend.java11.gira.role.model.RoleGroup;
import cybersoft.javabackend.java11.gira.role.service.RoleGroupService;

@RestController
@RequestMapping ("api/role_group")
public class RoleGruopController {
	@Autowired
	private RoleGroupService _service;
	
	@GetMapping("")
	public ResponseEntity<Object> findAllGruops(){
		List<RoleGroup> roleGroups = _service.findAll();
		return new ResponseEntity<> ( roleGroups, HttpStatus.OK);
	}
	
	@PostMapping("")
	public ResponseEntity<Object> saveRoleGroup (@Valid @ RequestBody CreateRoleGroupDTO dto, BindingResult errors){
		if (errors.hasErrors())
			return new ResponseEntity<>(errors.getAllErrors(), HttpStatus.BAD_REQUEST);
		RoleGroup roleGroup = new RoleGroup().name(dto.getGroupName());
		_service.save(roleGroup);
		return new ResponseEntity<> (HttpStatus.CREATED);
	}
	
	@PutMapping("/{group-id}/role")
	public ResponseEntity<Object>addRoleToGroup (@Valid @RequestBody Role role, @PathVariable ("group-id") Long groupId, BindingResult errors){
		if (errors.hasErrors())
			return new ResponseEntity<>(errors.getAllErrors(), HttpStatus.BAD_REQUEST);
		RoleGroup updateGroup = _service.addRole(role, groupId);
		return new ResponseEntity<>(updateGroup, HttpStatus.OK);
		
	}

}
