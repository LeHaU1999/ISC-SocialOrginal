package com.ft.so.service;

import com.ft.so.dto.UserEditDto;
import com.ft.so.dto.UserInsertDto;

public interface UserService {
	
	boolean updateUser(int id, UserEditDto userEditDto);

	boolean saveUser(UserInsertDto userInsertDto);
}
