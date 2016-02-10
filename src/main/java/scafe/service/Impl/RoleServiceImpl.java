package scafe.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import scafe.domain.Role;
import scafe.domain.dao.RoleDao;
import scafe.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	public RoleDao roleDao;
	
	@Override
	public Role findByRoleName(String name){
		List <Role> roles = roleDao.findAll();
		for(Role role : roles){
			if(role.getName().equals(name) )
				return role;
		}
		return null;
	}
	
}
