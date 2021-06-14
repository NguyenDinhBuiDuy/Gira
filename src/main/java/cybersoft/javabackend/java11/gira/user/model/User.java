package cybersoft.javabackend.java11.gira.user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import cybersoft.javabackend.java11.gira.commondata.model.AbstractEntity;
import cybersoft.javabackend.java11.gira.user.util.UserStatus;
import cybersoft.javabackend.java11.gira.user.validation.annotation.UniqueUsername;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "gira_user")
public class User extends AbstractEntity {
	@NotBlank(message = "{user.username.notblank}")
	@Size(min = 3, max = 50, message = "{user.username.size}")
	@Column(unique = true)
	@UniqueUsername
	private String username;

	@NotBlank
	private String password;

	@NotBlank
	@Email
	private String email;

	@NotBlank
	private String fullname;

	@NotBlank
	private String displayname;

	private String avatar;

	@NotBlank
	@Enumerated(EnumType.STRING)
	private UserStatus status;

	private String facebookUrl;
	private String job;
	private String department;
	private String hobbies;

	public User username(String username) {
		this.username = username;
		return this;
	}
	public User password(String password) {
		this.password = password;
		return this;
	}
	public User email(String email) {
		this.email = email;
		return this;
	}
	public User fullname (String fullname) {
		this.fullname = fullname;
		return this;
	}
	public User displayname (String displayname) {
		this.displayname = displayname;
		return this;
	}
	public User status (UserStatus status) {
		this.status = status;
		return this;
	}
}
