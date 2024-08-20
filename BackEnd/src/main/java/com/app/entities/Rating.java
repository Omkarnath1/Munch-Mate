package com.app.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "rating")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rating {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "rating")
	private int rating;
	@Column(name = "comment")
	private String comment;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "User_id", nullable = false)
	private User selectedRestaurant;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_id", nullable = false)
	private User selectedCustomer;

	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public int getRating() {
		return rating;
	}


	public void setRating(int rating) {
		this.rating = rating;
	}


	public String getComment() {
		return comment;
	}


	public void setComment(String comment) {
		this.comment = comment;
	}


	public User getSelectedRestaurant() {
		return selectedRestaurant;
	}


	public void setSelectedRestaurant(User selectedRestaurant) {
		this.selectedRestaurant = selectedRestaurant;
	}


	public User getSelectedCustomer() {
		return selectedCustomer;
	}


	public void setSelectedCustomer(User selectedCustomer) {
		this.selectedCustomer = selectedCustomer;
	}


	public Rating(int rating, String comment, User selectedRestaurant, User selectedCustomer) {
		super();
		this.rating = rating;
		this.comment = comment;
		this.selectedRestaurant = selectedRestaurant;
		this.selectedCustomer = selectedCustomer;
	}
}
