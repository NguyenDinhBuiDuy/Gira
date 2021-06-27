package cybersoft.javabackend.java11.gira.project.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import cybersoft.javabackend.java11.gira.commondata.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "gira_project_type")
@Getter
@Setter
@ToString
public class ProjectType extends AbstractEntity{
	
	@NotBlank(message = "Project type name can't be blank")
	@Length ( min = 4 , max = 50, message = "Project type name length is between {0} and {1}.")
	private String name;
	
	@NotBlank
	private String description;
	
	@OneToMany (mappedBy = "project", fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<Project> projects;
	

}
