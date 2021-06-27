package cybersoft.javabackend.java11.gira.project.model;


import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table (name = "gira_ workflow_link")
@Getter
@Setter
public class WorkflowLink {
	
	private WorkflowNode linkBy; // source
	private WorkflowNode linkTo; // destination
	
	@NotBlank
	private String transition;
	
	@ManyToOne
	@JoinColumn (name = "workflow")
	private Workflow workflow;

}
