package com.ft.so.responsitory;

import com.ft.so.entity.Users;

public interface LoginResponsitory {

	Users loginWithUsername(String userName, String password);
	
	Users loginWithEmail(String email, String password);
	
	Users loginWithPhoneNumber(String phoneNumber, String password);
}
