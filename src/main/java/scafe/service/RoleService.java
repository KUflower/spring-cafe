package scafe.service;

import scafe.domain.Role;

public interface RoleService {
	public Role findByRoleName(String name);
}
