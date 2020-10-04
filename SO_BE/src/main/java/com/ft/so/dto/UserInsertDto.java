package com.ft.so.dto;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UserInsertDto {

//	@Id
//	@Column(name = "USER_ID")
//	private int user_Id;

	@NotBlank(message = "Vui long nhap ten cua ban")
	@Column(name = "NAME")
	private String name;

	@Column(name = "GIOITINH")
	private String gioiTinh;

	@NotBlank(message = "vui long nhap mat khau cua ban")
	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "USER_NAME")
	private String userName;

	private String rePassword;

	// CONTRUCTOR

	public UserInsertDto() {
	}

	public UserInsertDto(String name, String gioiTinh, String password, String userName,
			String rePassword) {
		super();
		this.name = name;
		this.gioiTinh = gioiTinh;
		this.password = password;
		this.userName = userName;
		this.rePassword = rePassword;
	}

	// GETER - SETER

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRePassword() {
		return rePassword;
	}

	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}

}
