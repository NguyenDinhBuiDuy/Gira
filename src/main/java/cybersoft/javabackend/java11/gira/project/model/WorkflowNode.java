package cybersoft.javabackend.java11.gira.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table (name = "gira_workflow_node")
@Getter
@Setter
public class WorkflowNode {
	
	@NotBlank(message = "{workflowNode.name.notblank}")
	@Size(min = 3, max = 50, message = "{workflowNode.name.size}")
	@Column(unique = true)
	private String name;
	
	@Id
	@NotBlank
	private String code;
	
	private int nodeOrder;
	
	@ManyToOne
	@JoinColumn (name = "workflow")
	private Workflow workflow;
}
