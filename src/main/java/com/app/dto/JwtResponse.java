package com.app.dto;

import com.app.entities.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtResponse {

	private User user;
	private String token;
	public JwtResponse(User user, String token) {
		super();
		this.user = user;
		this.token = token;
	}
	@Override
	public String toString() {
		return "JwtResponse [user=" + user + ", token=" + token + "]";
	}
	
	
}
