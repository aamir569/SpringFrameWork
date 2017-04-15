package com.controllers;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.entities.Users;
import com.services.UserServices;
import com.services.*;

/**
 * Controller for managing the RestAPI 
 */
@Controller
@RequestMapping("users")
public class UsersController {

	/**
	 * Dependency Injection 
	 */
	@Autowired
	UserServices userServices;
	
	/**
     * Does Gets the UsersView page
     */
	@RequestMapping(value="/page", method = RequestMethod.GET)
	public ModelAndView getPage(){
		ModelAndView view =new ModelAndView("UsersView");
		return view;
	}
	
	/**
     * Gets all users from the Database
     */
	@RequestMapping(value="/users", method=RequestMethod.GET)
	public @ResponseBody Map<String,Object> getAll(Users users){
		Map<String,Object> map = new HashMap<String,Object>();
			List<Users> list = userServices.list();
			if (list != null){
				map.put("status","200");
				map.put("List of all Users","Data found");
				map.put("data", list);
			}else{
				map.put("status","404");
				map.put("message","Data not found");	
			}
		return map;
	}
	
	/**
     * For adding or updating users data into database.
     * @param Users, for adding or updating in the database  
     */
	@RequestMapping(value="/users", method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> UserDataAdded(Users users){
		Map<String,Object> map = new HashMap<String,Object>();
		if (users.getUser_name()=="")
		{
			map.put("status","default");
			map.put("message","Please enter the User Name");
		}
		else if (users.getEmail()=="")
		{
			map.put("status","default");
			map.put("message","Please enter the Email address");
		}
		else if (!(users.getEmail().contains("@") & (users.getEmail().contains(".com"))))
		{
			map.put("status","default");
			map.put("message","Invalid Email address, please enter a valid Email address");
		}
		else if(userServices.saveOrUpdate(users) ){
			map.put("status","200");
			map.put("message","User created succefully");
		}
		else
		{
			map.put("status","default");
			map.put("message","Unexpected Error");
		}
		return map;
	}

	/**
     * For searching users from the database.
     * @param Users, for adding or updating in the database  
     */
	@RequestMapping(value="/userss", method=RequestMethod.GET)
	public @ResponseBody Map<String,Object> search(Integer user_id){
		Map<String,Object> map = new HashMap<String,Object>();
		Users returnedUser = userServices.SearchById(user_id);
		if( returnedUser != null ){
			map.put("status","200");
			map.put("message","Requested User's details");
			map.put("User", returnedUser);
		}
		else
		{
			map.put("message" , "Unexpected Error");
		}
		return map;
	}
	

	/**
     * For deleting user from the database.
     * @param User, deletes this particular user   
     */
	@RequestMapping(value="/deleteusers", method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> delete(Users users){
		Map<String,Object> map = new HashMap<String,Object>();
		if(userServices.delete(users)){
			map.put("status","200");
			map.put("message","User deleted succefully");
		}
		return map;
	}

}
