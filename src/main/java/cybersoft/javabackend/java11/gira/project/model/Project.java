package cybersoft.javabackend.java11.gira.project.model;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import cybersoft.javabackend.java11.gira.commondata.model.AbstractEntity;
import cybersoft.javabackend.java11.gira.project.validation.annotation.UniqueCode;
import cybersoft.javabackend.java11.gira.user.model.User;
import cybersoft.javabackend.java11.gira.util.DateUtils;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table (name = "gira_project")
@Getter
@Setter
public class Project extends AbstractEntity{
	@NotBlank(message = "{project.name.notblank}")
	@Size(min = 3, max = 50, message = "{project.name.size}")
	@Column(unique = true)
	private String name;
	
	@NotBlank(message = "{project.code.notblank}")
	@Size(min = 3, max = 50, message = "{project.code.size}")
	//@UniqueCode // đảm bảo người dùng nhập vào giá trị không bị trùng
	@Column (unique = true) // đảm bảo data base chỉ có duy nhất 1 giá trị 
	private String code;
	
	private String icon;
	
	@NotBlank (message = "{project.description.notblank}")
	private String description;
	
	@NotBlank
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateUtils.DATE_FORMAT)// giup json hieu nen in format date nhu da quy dinh truoc
	@DateTimeFormat (pattern = DateUtils.DATE_FORMAT)
	@Column(name = "start_date", updatable = false, nullable = false)
	private LocalDateTime startDate;
	
	@NotBlank
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateUtils.DATE_FORMAT)// giup json hieu nen in format date nhu da quy dinh truoc
	@DateTimeFormat (pattern = DateUtils.DATE_FORMAT)
	@Column(name = "end_date", updatable = false, nullable = false)
	private LocalDateTime endDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_name")
	private User owner;
	
	//bidirectional = quan hệ 2 chiều (nên sử dụng để tăng performance) ; unidirectional = quan hệ một chiều
	//ManyToOne, OneToMany, OneToOne default type là eager : sẽ tự động load user
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_name") // đảm bảo username phải unique
	private User manager;
	
	
	
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn (name = "project_type_id")
	ProjectType projectType;
	
	@OneToMany (mappedBy = "workflows", fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<Workflow> workflows;
	

}
