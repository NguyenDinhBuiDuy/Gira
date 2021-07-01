package cybersoft.javabackend.java11.gira.project.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import cybersoft.javabackend.java11.gira.commondata.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "gira_project_type")
@Getter
@Setter
public class ProjectType extends AbstractEntity{
	
	@NotBlank(message = "{project-type.name.notblank}")
	@Length ( min = 4 , max = 50, message = "{project-type.name.size}")
	@Column (unique = true)
	private String name;
	
	@NotBlank(message = "{project-type.code.notblank}")
	@Length ( min = 4 , max = 50, message = "{project-type.code.size}")
	@Column (unique = true)
	private String code;
	
	@NotBlank
	private String description;
	
	@OneToMany (mappedBy = "projectType", cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Project> projects = new HashSet<Project>();
	

}
