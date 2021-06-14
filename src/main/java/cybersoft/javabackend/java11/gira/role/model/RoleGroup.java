package cybersoft.javabackend.java11.gira.role.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.ManyToAny;
import org.hibernate.validator.constraints.Length;

import cybersoft.javabackend.java11.gira.commondata.model.AbstractEntity;

@Entity
@Table (name = "gira_role_group")
public class RoleGroup extends AbstractEntity {
	
	@NotBlank(message = "role name can't be blank")
	@Length ( min = 4 , max = 50, message = "role name length is between {0} and {1}.")
	private String groupName;
	
	@NotBlank(message = "role description can't be blank")
	@Length ( min = 4 , max = 255, message = "role description length is between {0} and {1}.")
	private String description;
	
	@ManyToMany (cascade = {CascadeType.MERGE, CascadeType.PERSIST}) // không sử dụng cascade Remove và all và tạo Jion table ở đối tượng chính
	@JoinTable (name = "group_links",
	joinColumns = @JoinColumn (name = "group_id"),
	inverseJoinColumns = @JoinColumn (name = "role_id"))
	private Set<Role> roles = new HashSet<>(); // trong một mối quan hệ many to many thì luôn dùng set list sẽ ảnh hưởng đến performance
	
	/*
	 * helper methods: để đảm bảo dữ liệu luôn được thống nhất giữa các đối tượng 
	 * vd muốn thêm một role mới,
	 */
	public RoleGroup addRole (Role role) {
		this.roles.add(role);
		role.getGroups().add(this);
		return this;
	}
	public RoleGroup name (String name) {
		this.groupName = name;
		return this;
	}
//	public Role description (String decription) {
//		this.description = description;
//		return this;
//	}
}
