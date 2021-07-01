package cybersoft.javabackend.java11.gira.commondata;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import cybersoft.javabackend.java11.gira.commondata.model.AbstractEntity;
import cybersoft.javabackend.java11.gira.project.dto.CreateProjectDTO;
import cybersoft.javabackend.java11.gira.project.model.Project;

public interface GenericService<T extends AbstractEntity, ID> {
	List<T> findAll();
	Optional <T> findById (ID id); // cover T tránh bị null
	T save (T entity);
	T update (T entity);
	void deleteById(ID id);
	

}
