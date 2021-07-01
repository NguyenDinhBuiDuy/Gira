package cybersoft.javabackend.java11.gira.project.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import cybersoft.javabackend.java11.gira.commondata.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table (name = "gira_project_workflow")
@Getter
@Setter
public class Workflow extends AbstractEntity {
	
	@NotBlank(message = "{workflow.name.notblank}")
	@Size(min = 3, max = 50, message = "{workflow.name.size}")
	private String name;
	
	@NotBlank
	private String description;
	
	@OneToMany (mappedBy = "workflow", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private Set<WorkflowNode> nodes = new HashSet<WorkflowNode>();
	
	@OneToMany (mappedBy = "workflow", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private Set<WorkflowLink> links = new HashSet<WorkflowLink>();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn (name = "project_id")
	private Project project;
	
	public Workflow deleteWorkFlowNode (WorkflowNode node) {
		nodes.remove(node);
		node.setWorkflow(null);
		return this;
	}
}
