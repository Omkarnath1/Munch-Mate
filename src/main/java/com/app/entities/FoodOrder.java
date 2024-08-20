package com.app.entities;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

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
@Table(name = "food_order")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "total_price")
	private double totalPrice;

	@Enumerated(EnumType.STRING)
	@Column(length = 25, name = "status")	
	private OrderStatus status;

	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	@Column(name = "order_time")
	private LocalDateTime orderTime;

	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	@Column(name = "delivered_time")
	private LocalDateTime deliveredTime;

	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	@Column(name = "status_update_date")
	private LocalDateTime statusUpdateDate;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_id", nullable = false)
	private User customer;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "deliveryboy_id", nullable = true)
	private User deliverboy;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "address_id", nullable = false)
	private Address address;

	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public double getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}


	public OrderStatus getStatus() {
		return status;
	}


	public void setStatus(OrderStatus status) {
		this.status = status;
	}


	public LocalDateTime getOrderTime() {
		return orderTime;
	}


	public void setOrderTime(LocalDateTime orderTime) {
		this.orderTime = orderTime;
	}


	public LocalDateTime getDeliveredTime() {
		return deliveredTime;
	}


	public void setDeliveredTime(LocalDateTime deliveredTime) {
		this.deliveredTime = deliveredTime;
	}


	public LocalDateTime getStatusUpdateDate() {
		return statusUpdateDate;
	}


	public void setStatusUpdateDate(LocalDateTime statusUpdateDate) {
		this.statusUpdateDate = statusUpdateDate;
	}


	public User getCustomer() {
		return customer;
	}


	public void setCustomer(User customer) {
		this.customer = customer;
	}


	public User getDeliverboy() {
		return deliverboy;
	}


	public void setDeliverboy(User deliverboy) {
		this.deliverboy = deliverboy;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	public FoodOrder(double totalPrice, OrderStatus status, LocalDateTime orderTime, LocalDateTime deliveredTime,
			User customer, User deliverboy, Address address) {
		super();
		this.totalPrice = totalPrice;
		this.status = status;
		this.orderTime = orderTime;
		this.deliveredTime = deliveredTime;
		this.customer = customer;
		this.deliverboy = deliverboy;
		this.address = address;
	}
}
