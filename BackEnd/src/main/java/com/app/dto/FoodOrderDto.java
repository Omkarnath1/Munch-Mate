package com.app.dto;

import java.util.List;

import com.app.entities.FoodOrder;
import com.app.entities.OrderDetails;
import com.app.entities.Payment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodOrderDto {

	private FoodOrder order;
	private List<OrderDetails> orderDetails;
	private Payment payment;

	public FoodOrderDto(FoodOrder order, Payment payment) {
		super();
		this.order = order;
		this.payment = payment;
	}

	public FoodOrderDto(FoodOrder order, List<OrderDetails> orderDetails, Payment payment) {
		super();
		this.order = order;
		this.orderDetails = orderDetails;
		this.payment = payment;
	}
	
	
}
