package cybersoft.javabackend.java11.gira.project.service;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.google.common.base.Optional;

import cybersoft.javabackend.java11.gira.commondata.GenericServiceImpl;
import cybersoft.javabackend.java11.gira.util.MapDTOToModel;
import cybersoft.javabackend.java11.gira.project.dto.CreateProjectDTO;
import cybersoft.javabackend.java11.gira.project.dto.UpdateProjectDTO;
import cybersoft.javabackend.java11.gira.project.model.Project;
import cybersoft.javabackend.java11.gira.project.model.ProjectType;
import cybersoft.javabackend.java11.gira.project.repository.ProjectRepository;
import cybersoft.javabackend.java11.gira.project.repository.ProjectTypeRepository;
import cybersoft.javabackend.java11.gira.user.model.User;
import cybersoft.javabackend.java11.gira.user.repository.UserRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ProjectServiceImpl extends GenericServiceImpl<Project, Long> implements ProjectService{

	private ProjectRepository _projectRepository;

	private ProjectTypeRepository _projectTypeRepository;
	
	private MapDTOToModel mapper;
	
	private UserRepository _userRepository;
	

	@Override
	public Project save(@Valid CreateProjectDTO dto) {
		Project model = new Project();
		
		model = (Project)mapper.map(dto, model);
		
		ProjectType type = _projectTypeRepository.getOne(dto.getProjectTypeId());
		
		Optional<User> owner =  _userRepository.findByUsername(dto.getOwnerName());
		
		if (owner.isPresent())
			model.setOwner(owner.get());;
		
		model.setProjectType(type);
		
		return _projectRepository.save(model);
	}

	@Override
	public Project updateProjectInfo(@Valid UpdateProjectDTO dto, Long id) {
		Project project = _projectRepository.getOne(id);
		
			return _projectRepository.save(project);

	}
	@Override
	public boolean isTakenProjectCode(String projectCode) {
		
		return _projectRepository.countByCode(projectCode) >= 1 ;
	}

	@Override
	public boolean isTakenProjectName(String projectName) {
		
		return _projectRepository.countByName(projectName) >=1;
	}



}
