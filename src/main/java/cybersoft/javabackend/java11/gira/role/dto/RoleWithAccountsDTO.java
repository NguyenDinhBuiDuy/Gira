package cybersoft.javabackend.java11.gira.role.dto;

import java.util.Set;

import cybersoft.javabackend.java11.gira.role.model.Account;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class RoleWithAccountsDTO {
	private long id;
	private String roleName; 
	private String description;
	private Set<Account> accounts;

	


}
