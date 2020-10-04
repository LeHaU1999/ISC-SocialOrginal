package com.ft.so.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class Users {

	@Id
	@Column(name = "USER_ID")
	private int user_Id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "USER_NAME")
	private String userName;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "GIOITINH")
	private String gioiTinh;

	@Column(name = "SDT")
	private String sdt;

	@Column(name = "DIACHI")
	private String diaChi;

	@Column(name = "NOILAMVIEC")
	private String noiLamViec;

	@Column(name = "TONGIAO")
	private String tonGiao;

	@Column(name = "MOIQUANHE")
	private String moiQuanHe;

	@Column(name = "HOCVAN")
	private String hocVan;

	// CONTRUCTOR

	public Users() {
	}

	public Users(int user_Id, String name, String userName, String password, String email, String gioiTinh, String sdt,
			String diaChi, String noiLamViec, String tonGiao, String moiQuanHe, String hocVan) {
		super();
		this.user_Id = user_Id;
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.gioiTinh = gioiTinh;
		this.sdt = sdt;
		this.diaChi = diaChi;
		this.noiLamViec = noiLamViec;
		this.tonGiao = tonGiao;
		this.moiQuanHe = moiQuanHe;
		this.hocVan = hocVan;
	}

	// GETER _ SETER

	public int getUser_Id() {
		return user_Id;
	}

	public void setUser_Id(int user_Id) {
		this.user_Id = user_Id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getNoiLamViec() {
		return noiLamViec;
	}

	public void setNoiLamViec(String noiLamViec) {
		this.noiLamViec = noiLamViec;
	}

	public String getTonGiao() {
		return tonGiao;
	}

	public void setTonGiao(String tonGiao) {
		this.tonGiao = tonGiao;
	}

	public String getMoiQuanHe() {
		return moiQuanHe;
	}

	public void setMoiQuanHe(String moiQuanHe) {
		this.moiQuanHe = moiQuanHe;
	}

	public String getHocVan() {
		return hocVan;
	}

	public void setHocVan(String hocVan) {
		this.hocVan = hocVan;
	}

}
