package com.daoimplementation;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import com.dao.UserDao;
import com.entities.Users;

/**
 * Implementation of User Dao 
 */
@Repository
@Transactional
public class UsersDaoImplementation implements UserDao{

	@Autowired
	SessionFactory session;
	
	/**
     * Saves or updates the users.
     *
     * @param users User object to be added or updated
     */
	public boolean saveOrUpdate(Users users) {
		session.getCurrentSession().saveOrUpdate(users);
		return true;
	}
	
	
	/**
     * Gets the current session.
     */
	public List<Users> list() {
		List<Users> list = session.getCurrentSession().createQuery("from Users").list();
		return list;
	}
	
	/**
     * Searches the users.
     * @param userId, UserID to be used for searching  
     */
	public Users SearchById (Integer userId ) {
		List<Users> returnedUsers = session.getCurrentSession().createQuery("from Users where user_id = " + userId).list();
		if(!returnedUsers.isEmpty())
		{
			return returnedUsers.get(0);
		}
		
		return null;
	}
	
	/**
     * Deletes the users.
     * @param userId, UserID to be used for deleting  
     */
	public boolean delete(Users users) {
		try{
			session.getCurrentSession().delete(users);
		}catch(Exception ex){
			return false;
		}
		
		return true;
	}
}
