package cybersoft.javabackend.java11.gira.role.dto;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class CreateRoleDTO {
	@NotBlank(message = "{role.name.notblank}")
	@Length(min = 4, max = 50, message = "{role.name.size}")
	private String roleName;

	@NotBlank(message = "{role.description.notblank}")
	@Length(min = 4, max = 255, message = "{role.description.length}")
	private String description;
	/*
	 * @NotNull-> chỉ check null, không check rỗng
	 * 
	 * 
	 */

}
