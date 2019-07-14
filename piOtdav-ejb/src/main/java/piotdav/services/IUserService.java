package piotdav.services;

import java.util.List;

import javax.ejb.Local;

import piotdav.entities.User;
@Local
public interface IUserService {
	
	public boolean addUser(User user);	
	public User getUserById(int id);
	public boolean  deleteUser(int  user);
	public boolean  updateUser(int iduser);
	
	public User login(String login, String password);
	public List<User> getAllUser();
		 
}
