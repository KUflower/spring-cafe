package scafe.service;

import java.util.List;

import scafe.domain.Role;
import scafe.domain.User;

public interface UserService{
		
	public List<User> findAll();
	
	public void save(User user);
	
	public User getOne(Integer id);
	
	public User getUserByEmail(String email);

	public void registerNewUserAccount(User user);

	public int getIdByUserEmail ( String email);

	public boolean emailExist(String email);

	public void changeRole ( User user, Role role);

}
