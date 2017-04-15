package com.servicesimplementation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.UserDao;
import com.entities.Users;
import com.services.UserServices;

/**
 * Implementation of User Service 
 */
@Service
public class UserServicesImplementation implements UserServices{

	/**
	 * Dependency Injection 
	 */
	@Autowired
	UserDao userDao;
	
	/**
     * Saves or updates the users.
     *
     * @param users, User object to be added or updated
     */
	public boolean saveOrUpdate(Users users) {
		// TODO Auto-generated method stub
		return userDao.saveOrUpdate(users);
	}

	/**
     * Gets the users list.
     */
	public List<Users> list() {
		// TODO Auto-generated method stub
		return  userDao.list();
	}

	/**
     * Deletes the use list.
     */
	public boolean delete(Users users) {
		// TODO Auto-generated method stub
		return userDao.delete(users);
	}
	
	/**
     * Searches the users.
     * @param userID, userID Integer to be used for searching
     */
	public Users SearchById (Integer userId){
		return userDao.SearchById(userId);
	}

}
