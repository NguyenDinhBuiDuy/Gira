package cybersoft.javabackend.java11.gira.project.model;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import cybersoft.javabackend.java11.gira.commondata.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table (name = "gira_ workflow_link")
@Getter
@Setter
public class WorkflowLink extends AbstractEntity{
	
	@NotBlank
	private String transition; // mô tả liên kết
	
	@ManyToOne
	private Workflow workflow;
	
	@ManyToOne (fetch = FetchType.LAZY)
	private WorkflowNode destination; // linkTo
	
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn (name = "source")
	private WorkflowNode source; // linkBy
	
}
