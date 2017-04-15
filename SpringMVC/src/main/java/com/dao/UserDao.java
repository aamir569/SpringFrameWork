package com.dao;

import java.util.List;

import com.entities.Users;

public interface UserDao {
	public boolean saveOrUpdate(Users users);
	public List<Users> list();
	public Users SearchById (Integer userId);
	public boolean delete(Users users);
}
