package com.shopstyle.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cart")
public class CartEntity extends BaseEntity{
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "total")
	private Float total;
	
	@OneToMany(mappedBy = "cart")
	private List<CartItemEntity> cartItem = new ArrayList<>();
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

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

	public Float getTotal() {
		return total;
	}

	public void setTotal(Float total) {
		this.total = total;
	}

	public List<CartItemEntity> getCartItem() {
		return cartItem;
	}

	public void setCartItem(List<CartItemEntity> cartItem) {
		this.cartItem = cartItem;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}
	
	
}
