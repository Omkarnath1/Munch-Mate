package com.app.entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "menu")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Menu
{	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public byte getStatus() {
		return status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	public User getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(User restaurant) {
		this.restaurant = restaurant;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "product_name" ,length =20)
	private String productName;
	
	@Column(length =100,name = "description")
	private String description;
	
	@Column(name = "price")
	private double price;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 20, name = "type")
	private Type type;
	
	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	@Column(length =100,name = "image")
	private String image;
	
	@Column(name="status")
	private byte status;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "User_id",nullable= true)
	private User restaurant;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cat_id",nullable=true)
	private Category category;

	
	@Override
	public boolean equals(Object o) {
	    if (this == o) return true;
	    if (o == null || getClass() != o.getClass()) return false;
	    Menu menu = (Menu) o;
	    return Double.compare(menu.price, price) == 0 &&
	           status == menu.status &&
	           Objects.equals(id, menu.id) &&
	           Objects.equals(productName, menu.productName) &&
	           Objects.equals(description, menu.description) &&
	           type == menu.type &&
	           Objects.equals(image, menu.image) &&
	           Objects.equals(restaurant, menu.restaurant) &&
	           Objects.equals(category, menu.category);
	}

	@Override
	public int hashCode() {
	    return Objects.hash(id, productName, description, price, type, image, status, restaurant, category);
	}
}