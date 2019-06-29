package edu.mum.service;

import java.util.List;

import edu.mum.domain.User;
 
public interface UserService  {

	public void save(User user);
	public List<User> findAll();
	public User findByEmail(String email);
	public void delete(Long id);
	public User update(User user);
	public void detach(User user);
}
