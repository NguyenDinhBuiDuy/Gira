package cybersoft.javabackend.java11.gira.role.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import cybersoft.javabackend.java11.gira.role.dto.RoleWithAccountsDTO;
import cybersoft.javabackend.java11.gira.role.model.Role;
import cybersoft.javabackend.java11.gira.role.model.RoleGroup;
import cybersoft.javabackend.java11.gira.role.repository.RoleGroupRepository;
@Service
public class RoleGroupServiceImpl implements RoleGroupService{
	@Autowired
	private RoleGroupRepository _repository;

	@Override
	public List<RoleGroup> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<RoleGroup> findById(Long id) {
		// TODO Auto-generated method stub
		return _repository.findById(id);
	}

	@Override
	public RoleGroup save(RoleGroup entity) {
		// TODO Auto-generated method stub
		return _repository.save(entity);
	}

	@Override
	public RoleGroup update(RoleGroup entity) {
		// TODO Auto-generated method stub
		return _repository.save(entity);
	}

	@Override
	public void deleteById(Long id) {
		_repository.deleteById(id);
	
	}
	
	@Override
	public RoleGroup addRole(@Valid Role role, Long groupId) {
		RoleGroup roleGroup = _repository.getOne(groupId);
		roleGroup.addRole(role);
		
		return _repository.save(roleGroup);
		
	}


	



}
