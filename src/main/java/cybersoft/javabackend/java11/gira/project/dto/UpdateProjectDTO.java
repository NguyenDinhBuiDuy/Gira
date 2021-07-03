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

public class UpdateProjectDTO {

	@NotBlank(message = "{project.name.notblank}")
	@Size(min = 3, max = 50, message = "{project.name.size}")
	private String name;
	
	@NotBlank(message = "{project.code.notblank}")
	@Size(min = 3, max = 50, message = "{project.code.size}")
	private String code;
	
	private String icon;
	
	private String description;
	
	
	private LocalDateTime startDate;
	
	private LocalDateTime endDate;
	
	@ExistUser (message = "the owner is not exits")
	private String ownerName;
	
	@ExistUser (message = "the manager is not exits")
	private String managerName;
	
	Long  projectTypeId;
}
