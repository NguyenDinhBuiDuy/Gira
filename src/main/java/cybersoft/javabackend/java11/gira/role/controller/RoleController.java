package cybersoft.javabackend.java11.gira.role.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import cybersoft.javabackend.java11.gira.commondata.model.ResponeObject;
import cybersoft.javabackend.java11.gira.commondata.model.ResponseHandler;
import cybersoft.javabackend.java11.gira.role.dto.CreateRoleDTO;
import cybersoft.javabackend.java11.gira.role.dto.RoleWithAccountsDTO;
import cybersoft.javabackend.java11.gira.role.model.Role;
import cybersoft.javabackend.java11.gira.role.service.RoleService;
import cybersoft.javabackend.java11.gira.util.ErrorUtils;

@RestController
@RequestMapping ("/api/role")
public class RoleController {
	@Autowired
	private RoleService _service;
	
	@PostMapping("")
	public ResponseEntity<Object> save(@Valid @RequestBody CreateRoleDTO dto, BindingResult errors){
		if (errors.hasErrors())
			return ResponseHandler.getResponse(errors, HttpStatus.BAD_REQUEST);
		
		Role role = new Role() ;
		role = _service.save(dto);
		return ResponseHandler.getResponse(role, HttpStatus.CREATED);
	}
	@GetMapping("/{role_name}")
	public ResponseEntity<Object> findByRoleName (@PathVariable("role_name") String roleName){
		List<Role> roles = _service.findByRoleName(roleName);
		if (roles.isEmpty())
		return ResponseHandler.getResponse("there is no data", HttpStatus.OK);
		return ResponseHandler.getResponse(roles, HttpStatus.OK);
	}
	@GetMapping("/description/{role-name}")
	public ResponseEntity<Object> findRoleWithoutBlankDescription(@PathVariable("role-name") String roleName){
		List<Role> roles = _service.findRoleWithoutBlankDescription(roleName);
		
		if(roles.isEmpty())
			return ResponseHandler.getResponse( HttpStatus.NO_CONTENT);
		
		return ResponseHandler.getResponse( roles, HttpStatus.OK);
	}
	
	@GetMapping("/with-account")
	public ResponseEntity<List<RoleWithAccountsDTO>> findRoleWithAccountInfo(){
		List<RoleWithAccountsDTO> roles = _service.findRoleWithAccountInfo();
		
		if(roles.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<>(roles, HttpStatus.OK);
	}
	
	@GetMapping("/description")
	public ResponseEntity<Object> findByDescription(@RequestParam("description") String description){
		List<Role> roles = _service.findByDescription(description);
		
		if(roles.isEmpty())
			return ResponseHandler.getResponse(HttpStatus.NO_CONTENT);
		
		return ResponseHandler.getResponse(roles, HttpStatus.OK);
	}
	@PutMapping("/{role-id}")
	public ResponseEntity<Object> updateRoleInfo(@Valid @RequestBody CreateRoleDTO dto,
			@PathVariable ("role-id") Long roleId,
			BindingResult errors){
		if (errors.hasErrors())
			return ResponseHandler.getResponse(errors, HttpStatus.BAD_REQUEST);
		Role updateRole = _service.updateRoleInfo(dto, roleId);

		return ResponseHandler.getResponse( updateRole, HttpStatus.OK);
		
	}
	@DeleteMapping("/{role-id}")
	public ResponseEntity<Object> deleteRole (
			@PathVariable ("role-id") Long roleId) {
	
		boolean deleteRole = _service.deleteRoleById( roleId);
		if (deleteRole)
			return ResponseHandler.getResponse( HttpStatus.OK);
		return ResponseHandler.getResponse( HttpStatus.BAD_REQUEST);
	}
}
