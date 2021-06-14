package cybersoft.javabackend.java11.gira.role.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
@Table (name = "Account")
public class Account {
@Id 
@GeneratedValue (strategy = GenerationType.AUTO)
private Long id; // primary key
private String username;
private String password;
private String email;

@Column (name = "role_id", insertable = false, updatable = false)
private Long roleId; // creating a fk with role_id, the value can't be insert or update here

@ManyToOne// the n-1 relative, one account can have many role
@JoinColumn(name = "role_id") // creating a fk with role_id, 
private Role role;
}
