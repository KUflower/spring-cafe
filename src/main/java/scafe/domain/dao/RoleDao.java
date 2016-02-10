package scafe.domain.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import scafe.domain.Role;

public interface RoleDao extends JpaRepository<Role, Integer>{
//	Role findByName(String name);
}
