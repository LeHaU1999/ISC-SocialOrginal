package com.ft.so.service.impl;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ft.so.dto.UserEditDto;
import com.ft.so.dto.UserInsertDto;
import com.ft.so.entity.Users;
import com.ft.so.responsitory.UserReponsitory;
import com.ft.so.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserReponsitory userResponsitory;

	//xu ly update thong tin user
	public boolean updateUser(int id, UserEditDto userEditDto) {
		Users user = userResponsitory.getUserById(id);
		if (user == null) {
			return false;
		} else {
			user.setName(userEditDto.getName());
			user.setEmail(userEditDto.getEmail());
			user.setPassword(userEditDto.getPassword());
			user.setSdt(userEditDto.getSdt());
			user.setGioiTinh(userEditDto.getGioiTinh());
			user.setDiaChi(userEditDto.getDiaChi());
			user.setNoiLamViec(userEditDto.getNoiLamViec());
			user.setTonGiao(userEditDto.getTonGiao());
			user.setMoiQuanHe(userEditDto.getMoiQuanHe());
			user.setHocVan(userEditDto.getHocVan());
			return userResponsitory.saveOrUpdate(user);
		}
	}

	//xu ly save user(add new user - dang ky)
	public boolean saveUser(UserInsertDto userInsertDto) {
		Users user = new Users();
		//ma hoa mat khau theo BCrypt
		//String encodingPassword = BCrypt.hashpw(userInsertDto.getPassword(), BCrypt.gensalt());
		if (userInsertDto.getPassword().equals(userInsertDto.getRePassword())) {
			//user.setUser_Id(userInsertDto.getUser_Id());
			user.setName(userInsertDto.getName());
			user.setGioiTinh(userInsertDto.getGioiTinh());
			user.setUserName(userInsertDto.getUserName());
			user.setPassword(userInsertDto.getPassword());
		}
		return userResponsitory.saveOrUpdate(user);
	}
}
