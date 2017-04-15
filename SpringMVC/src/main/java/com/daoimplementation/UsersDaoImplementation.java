package com.daoimplementation;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import com.dao.UserDao;
import com.entities.Users;

@Repository
@Transactional
public class UsersDaoImplementation implements UserDao{

	@Autowired
	SessionFactory session;
	
	public boolean saveOrUpdate(Users users) {
		// TODO Auto-generated method stub
		session.getCurrentSession().saveOrUpdate(users);
		return true;
	}

	public List<Users> list() {
		return session.getCurrentSession().createQuery("from Users").list();
	}

	public Users SearchById (Integer userId ) {
		List<Users> returnedUsers = session.getCurrentSession().createQuery("from Users where user_id = " + userId).list();
		if(!returnedUsers.isEmpty())
		{
			return (Users) returnedUsers.get(0);
		}
		
		return null;
	}
	public boolean delete(Users users) {
		try{
			session.getCurrentSession().delete(users);
		}catch(Exception ex){
			return false;
		}
		
		return true;
	}
}
