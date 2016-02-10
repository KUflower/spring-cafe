package scafe.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import scafe.domain.Role;
import scafe.domain.User;
import scafe.domain.dao.UserDao;
import scafe.service.RoleService;
import scafe.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	public UserDao userDao;
	
	@Autowired
	public RoleService roleService;
	
	@Autowired
	public PasswordEncoder passwordEncoder;
	

	public List<User> findAll() {
		return userDao.findAll();
	}

	@Override
	public void save(User user) {
//		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//		user.setPassword(encoder.encode(user.getPassword()));	
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userDao.save(user);
	}

	@Override
	public User getOne(Integer id) {
		return userDao.getOne(id);
	}

	@Override
	public User getUserByEmail(String email) {
		return userDao.findByEmail(email);
	}

	@Override
	public void registerNewUserAccount(User user){
		if(emailExist(user.getEmail())){
			System.out.println("already exist");
			return;
		}
		List<Role> roles = new ArrayList<Role>();		
		roles.add(roleService.findByRoleName("USER"));		
		user.setRoles(roles);
		this.save(user);
	}

	@Override
	public boolean emailExist(String email) {
		User user = userDao.findByEmail(email);
		if (user != null) {
			return true;
		}
		return false;
	}
	
	@Override
	public int getIdByUserEmail ( String email){
		List <User> users = this.findAll();
		for(User user: users){
			if(email.matches(user.getEmail())){
				return user.getId();
			}
		}
		
		return -1;
	}
	
	@Override
	public void changeRole ( User user, Role role){
		List <Role> roles = new ArrayList<Role>();
		roles.add(role);
		user.setRoles(roles);
		this.save(user);
	}
}
