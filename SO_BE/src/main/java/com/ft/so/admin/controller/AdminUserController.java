package com.ft.so.admin.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ft.so.dto.UserEditDto;
import com.ft.so.dto.UserInsertDto;
import com.ft.so.entity.Users;
import com.ft.so.responsitory.UserReponsitory;
import com.ft.so.service.UserService;

@RestController
@RequestMapping("api/admin/user")
public class AdminUserController {

	@Autowired
	private UserReponsitory userReponsitory;

	@Autowired
	private UserService userService;

	// API - lấy danh sách user
	@GetMapping("")
	public Object GetAllUser() {
		List<Users> users = userReponsitory.getAllUser();
		if (users == null) {
			return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<List<Users>>(users, HttpStatus.OK);
	}

	// API - tìm user theo id
	@GetMapping("{/{id}}")
	public Object FindUserByID(@PathVariable("id") int id) {
		Users user = userReponsitory.getUserById(id);
		return new ResponseEntity<Users>(user, HttpStatus.OK);
	}

	// API - tìm user theo email
	@GetMapping("/{email}")
	public Object FindUserByEmail(String email) {
		Users user = userReponsitory.getUserByEmail(email);
		return new ResponseEntity<Users>(user, HttpStatus.OK);
	}

	// API - tìm user theo userName
	@GetMapping("/{userName}")
	public Object FindUserByUsername(String userName) {
		Users user = userReponsitory.getUserByUserName(userName);
		return new ResponseEntity<Users>(user, HttpStatus.OK);
	}

	// API - tìm user theo so dien thoai
	@GetMapping("/{phoneNumber}")
	public Object FindUserByPhoneNumber(String phoneNumber) {
		Users user = userReponsitory.getUserByPhoneNumber(phoneNumber);
		return new ResponseEntity<Users>(user, HttpStatus.OK);
	}

	// API - Cập nhật user
	@PutMapping("/{id}")
	public Object UpdteUser(@PathVariable("id") int id, @Valid @RequestBody UserEditDto userEditDto,
			BindingResult errors) {
		if (errors.hasErrors()) {
			return new ResponseEntity<Object>(errors.getAllErrors(), HttpStatus.BAD_REQUEST);
		}
//		if (userReponsitory.getUserByEmail(userEditDto.getEmail()) != null) {
//			return new ResponseEntity<String>("Email đã tồn tại!", HttpStatus.BAD_REQUEST);
//		}
		if (userService.updateUser(id, userEditDto)) {
			return new ResponseEntity<UserEditDto>(userEditDto, HttpStatus.OK);
		}
		return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
	}

	// API - Add new user
	@PostMapping("")
	public Object AddNewUser(@Valid @RequestBody UserInsertDto userInsertDto, BindingResult errors) {
		if (errors.hasErrors()) {
			return new ResponseEntity<Object>(errors.getAllErrors(), HttpStatus.BAD_REQUEST);
		}
		if (userReponsitory.getUserByUserName(userInsertDto.getUserName()) != null) {
			return new ResponseEntity<String>("User name da ton tai", HttpStatus.BAD_REQUEST);
		}
		System.out.println("pass: " + userInsertDto.getPassword());
		System.out.println("repass: " + userInsertDto.getRePassword());
		if (userInsertDto.getPassword().equals(userInsertDto.getRePassword())) {
			if (userService.saveUser(userInsertDto)) {
				return new ResponseEntity<UserInsertDto>(userInsertDto, HttpStatus.CREATED);
			}
		} else {
			return new ResponseEntity<String>("Confirm mat khau khong chinh xac. Kiem tra lai", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
	}

	// API - Xóa user
	@DeleteMapping("{/{id}}")
	public Object DeleteUser(@PathVariable("id") int id) {
		if (userReponsitory.getUserById(id) == null) {
			return new ResponseEntity<String>("Khong tim thay user co id = " + id, HttpStatus.BAD_REQUEST);
		}
		if (userReponsitory.deleteUser(id)) {
			return new ResponseEntity<String>("Xoa Thanh Cong", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Xoa That Bai", HttpStatus.BAD_REQUEST);
	}
}
