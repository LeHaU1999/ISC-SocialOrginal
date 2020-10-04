package com.ft.so.admin.controller;

import javax.validation.Valid;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ft.so.dto.UserEditDto;
import com.ft.so.entity.Users;
import com.ft.so.responsitory.LoginResponsitory;

@RestController
@RequestMapping("api/admin/login")
public class AdminLoginController {

	@Autowired
	private LoginResponsitory loginResponsitory;

	// API - login bang userName
	@GetMapping("/{userName}/{password}")
	public Object LoginWithUsername(@PathVariable("userName") String userName,
			@PathVariable("password") String password) {
		Users user = loginResponsitory.loginWithUsername(userName, password);
		if (user != null) {
			System.out.println("dang nhap thanh cong");
			return new ResponseEntity<Users>(user, HttpStatus.OK);
		}
		return new ResponseEntity<String>("dang nhap that bai", HttpStatus.BAD_REQUEST);
	}

//	// API - login bang email
//	@GetMapping("/{email}/{password}")
//	public Object LoginWithEmail(@PathVariable("email") String email, @PathVariable("password") String password) {
//		Users user = loginResponsitory.loginWithEmail(email, password);
//		if (user != null) {
//			System.out.println("dang nhap thanh cong");
//			return new ResponseEntity<Users>(user, HttpStatus.OK);
//		}
//		return new ResponseEntity<String>("dang nhap that bai", HttpStatus.BAD_REQUEST);
//	}
//
//	// API - login bang so dien thoai
//	@GetMapping("/{phoneNumber}/{password}")
//	public Object LoginWithPhoneNumber(@PathVariable("phoneNumber") String phoneNumber,
//			@PathVariable("password") String password) {
//		Users user = loginResponsitory.loginWithPhoneNumber(phoneNumber, password);
//		if (user != null) {
//			System.out.println("dang nhap thanh cong");
//			return new ResponseEntity<Users>(user, HttpStatus.OK);
//		}
//		return new ResponseEntity<String>("dang nhap that bai", HttpStatus.BAD_REQUEST);
//	}
}
