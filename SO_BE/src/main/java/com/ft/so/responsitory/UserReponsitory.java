package com.ft.so.responsitory;

import java.util.List;

import com.ft.so.entity.Users;

public interface UserReponsitory {

	List<Users> getAllUser();
	
	Users getUserById(int id);
	
	Users getUserByEmail(String email);
	
	Users getUserByUserName(String userName);
	
	Users getUserByPhoneNumber(String phoneNumber);
	
	boolean saveOrUpdate(Users user);
	
	boolean deleteUser(int id);
}
