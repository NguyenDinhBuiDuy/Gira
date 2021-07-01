package cybersoft.javabackend.java11.gira.project.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import cybersoft.javabackend.java11.gira.commondata.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table (name = "gira_project_workflow_node")
@Getter
@Setter
public class WorkflowNode extends AbstractEntity{
	
	@NotBlank(message = "{workflowNode.name.notblank}")
	@Size(min = 3, max = 50, message = "{workflowNode.name.size}")
	private String name;
	
	private int nodeOrder;
	
	@ManyToOne
	private Workflow workflow;
	
	@OneToMany (mappedBy = "destination", cascade =  CascadeType.ALL)
	private Set<WorkflowLink> linkBy = new HashSet<>();
	
	@OneToMany (mappedBy = "source", cascade =  CascadeType.ALL)
	private Set<WorkflowLink> linkTo = new HashSet<>();
}
