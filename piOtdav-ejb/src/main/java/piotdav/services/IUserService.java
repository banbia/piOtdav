package piotdav.services;

import java.util.List;

import javax.ejb.Local;

import piotdav.entities.User;
@Local
public interface IUserService {
	
	public boolean addUser(User a);	
	public User getUserById(int id);
	public User login(String login, String password);
	public List<User> getAllUser();
		 
}
