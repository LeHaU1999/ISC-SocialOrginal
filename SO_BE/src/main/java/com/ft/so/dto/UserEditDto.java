package com.ft.so.dto;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UserEditDto {

	@NotBlank(message = "Vui long nhap ten cua ban")
	@Column(name = "NAME")
	private String name;

	@NotBlank(message = "vui long nhap mat khau cua ban")
	@Column(name = "PASSWORD")
	private String password;

	@Email(message = "Email khong dung dinh dang vui long kiem tra lai")
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
	public UserEditDto() {}
	
	public UserEditDto(String name, String password, String email, String gioiTinh, String sdt, String diaChi,
			String noiLamViec, String tonGiao, String moiQuanHe, String hocVan) {
		super();
		this.name = name;
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
	
	// GETER - SETER

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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















