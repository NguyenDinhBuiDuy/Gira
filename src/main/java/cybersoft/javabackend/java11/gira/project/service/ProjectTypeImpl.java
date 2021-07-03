package cybersoft.javabackend.java11.gira.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cybersoft.javabackend.java11.gira.commondata.GenericServiceImpl;
import cybersoft.javabackend.java11.gira.project.model.ProjectType;
import cybersoft.javabackend.java11.gira.project.repository.ProjectTypeRepository;

@Service
public class ProjectTypeImpl extends GenericServiceImpl<ProjectType, Long> implements ProjectTypeService{

	@Autowired
	private ProjectTypeRepository _projectTypeRepository;
	
	@Override
	public boolean isTakenProjectType(Long id) {
		
		return _projectTypeRepository.countById(id) >= 1;
	}

}
