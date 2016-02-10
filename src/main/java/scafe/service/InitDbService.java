package scafe.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import scafe.domain.Role;
import scafe.domain.User;

@Transactional
@Service
public class InitDbService {
	
	@Autowired
	private RoleService roleService;
		
	@Autowired
	private UserService userService;
	
	@PostConstruct
	public void init(){

//		if(roleDao.findByName("ROLE_ADMIN") == null){
//			List <Role> roles = new ArrayList <Role>();
//			Role userRole = new Role();
//			userRole.setName("ROLE_USER");
//			roleDao.save(userRole);
//			
//			Role adminRole = new Role();
//			adminRole.setName("ROLE_ADMIN");
//			roleDao.save(adminRole);
//			
//			roles.add(userRole);
//			roles.add(adminRole);			
//		}

		if(userService.getUserByEmail("admin") == null){
			// create Admin
			User adminUser = new User();
			adminUser.setEmail("admin");
			adminUser.setCreatedAt(new Date());
			adminUser.setUpdatedAt(new Date());
			adminUser.setName("admin");
			adminUser.setPassword("admin");
			List<Role> roles = new ArrayList<Role>();	
			roles.add(roleService.findByRoleName("ADMIN"));		
			adminUser.setRoles(roles);
			userService.save(adminUser);		
		}
		
	}

}
