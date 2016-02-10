package scafe.domain.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import scafe.domain.User;

public interface UserDao extends JpaRepository <User, Integer> {
	public User findByEmail(String email);
	public User findByIdAndEmail(Integer Id, String email);
	public User findByName(String name);
}
