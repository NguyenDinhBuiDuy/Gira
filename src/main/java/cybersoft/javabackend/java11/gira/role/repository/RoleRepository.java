package cybersoft.javabackend.java11.gira.role.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cybersoft.javabackend.java11.gira.role.model.Role;

public interface RoleRepository extends JpaRepository< Role, Long>{
	List<Role> findByRolename(String roleName);
List<Role> findByDescriptionContainingOrderByIdAsc(String description);
	
	/*
	 * dùng @Query để viết câu query theo cú pháp của HQL hoặc SQL thuần
	 */
	@Query("SELECT r FROM Role r WHERE r.rolename=:rolename AND r.description IS NOT NULL")
	List<Role> findRoleWithNotNullDescription(@Param("rolename")String rolename);
	int countByRolename(String rolename);
}
