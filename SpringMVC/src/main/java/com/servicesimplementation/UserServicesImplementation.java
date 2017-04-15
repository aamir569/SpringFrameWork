package com.servicesimplementation;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserDao;
import com.entities.Users;
import com.services.UserServices;


@Service
public class UserServicesImplementation implements UserServices{

	// Dependency Injection
	@Autowired
	UserDao userDao;
	
	// For saving and updating the user
	public boolean saveOrUpdate(Users users) {
		// TODO Auto-generated method stub
		return userDao.saveOrUpdate(users);
	}

	// For getting all list of user
	public List<Users> list() {
		// TODO Auto-generated method stub
		return  userDao.list();
	}

	// For deleting the user
	public boolean delete(Users users) {
		// TODO Auto-generated method stub
		return userDao.delete(users);
	}
	
	// For searching the user
	public Users SearchById (Integer userId){
		return userDao.SearchById(userId);
	}

}
