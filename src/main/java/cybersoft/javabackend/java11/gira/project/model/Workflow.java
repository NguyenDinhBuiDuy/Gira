package cybersoft.javabackend.java11.gira.project.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table (name = "gira_workflow")
@Getter
@Setter
public class Workflow {
	
	@OneToMany (mappedBy = "nodes", fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<WorkflowNode> nodes;
	
	@OneToMany (mappedBy = "links", fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<WorkflowLink> links;
	
	@OneToMany 
	@JoinColumn (name = "project_id")
	private Project project;
	
	@NotBlank(message = "{workflow.name.notblank}")
	@Size(min = 3, max = 50, message = "{workflow.name.size}")
	@Column(unique = true)
	private String name;
	
	@NotBlank
	private String description;
}
