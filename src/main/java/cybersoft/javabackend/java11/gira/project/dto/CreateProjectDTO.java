package cybersoft.javabackend.java11.gira.project.dto;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import cybersoft.javabackend.java11.gira.project.validation.annotation.ExistUser;
import cybersoft.javabackend.java11.gira.project.validation.annotation.UniqueProjectCode;
import cybersoft.javabackend.java11.gira.util.DateUtils;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class CreateProjectDTO {
	@NotBlank(message = "{project.name.notblank}")
	@Size(min = 3, max = 50, message = "{project.name.size}")
	@Column(unique = true)
	private String name;
	
	@NotBlank(message = "{project.code.notblank}")
	@Size(min = 3, max = 50, message = "{project.code.size}")
	@UniqueProjectCode // đảm bảo người dùng nhập vào giá trị không bị trùng
	@Column (unique = true) // đảm bảo data base chỉ có duy nhất 1 giá trị 
	private String code;
	
	private String icon;
	
	@NotBlank (message = "{project.description.notblank}")
	private String description;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateUtils.DATE_FORMAT)// giup json hieu nen in format date nhu da quy dinh truoc
	@DateTimeFormat (pattern = DateUtils.DATE_FORMAT)
	private LocalDateTime startDate;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateUtils.DATE_FORMAT)// giup json hieu nen in format date nhu da quy dinh truoc
	@DateTimeFormat (pattern = DateUtils.DATE_FORMAT)
	private LocalDateTime endDate;
	
	@ExistUser (message = "owner name is not exist")
	private String ownerName;
	
	@ExistUser (message = "manager name is not exist")
	private String managerName;
	
	Long  projectTypeId;
}
