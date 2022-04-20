package com.shopstyle.dto;

public class CartDTO extends AbstractDTO<CartDTO>{
	private String address;
	private String phone;
	private String status;
	private Float total;
	private String user_id;
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Float getTotal() {
		return total;
	}
	public void setTotal(Float float1) {
		this.total = float1;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

}
