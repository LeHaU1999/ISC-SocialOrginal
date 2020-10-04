package com.ft.so.responsitory.impl;

import javax.transaction.Transactional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ft.so.entity.Users;
import com.ft.so.responsitory.LoginResponsitory;
import com.ft.so.responsitory.UserReponsitory;

@Repository
@Transactional(rollbackOn = Exception.class)
public class LoginResponsitoryImpl implements LoginResponsitory {

	@Autowired
	private UserReponsitory userResponsitory;

	public Users loginWithUsername(String userName, String password) {
		Users user = userResponsitory.getUserByUserName(userName);
		//String encodingPassword = BCrypt.hashpw(password, BCrypt.gensalt());
		if (user != null && user.getPassword().equals(password)) {
			System.out.println("dang nhap bang username");
			return user;
		}
		return null;
	}

	public Users loginWithEmail(String email, String password) {
		Users user = userResponsitory.getUserByEmail(email);
		//String encodingPassword = BCrypt.hashpw(password, BCrypt.gensalt());
		if (user != null && user.getPassword().equals(password)) {
			System.out.println("dang nhap bang emal");
			return user;
		}
		return null;
	}

	public Users loginWithPhoneNumber(String phoneNumber, String password) {
//		Users user = userResponsitory.getUserByPhoneNumber(phoneNumber);
//		//String encodingPassword = BCrypt.hashpw(password, BCrypt.gensalt());
//		if (user != null && user.getPassword().equals(password)) {
//			System.out.println("dang nhap bang so dien thoai");
//			return user;
//		}
		return null;
	}
}
