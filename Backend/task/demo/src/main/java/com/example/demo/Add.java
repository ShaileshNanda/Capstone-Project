package com.example.demo;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;  

@RestController
@RequestMapping(path = "/api", produces = "application/json")
@CrossOrigin(origins = "http://localhost:4200/")
public class Add {

	UserDto user1 = new UserDto("shailesh", "No.35,IndraNagar,Chennai", "555", "aaa@gmail.com", "savings", "male",
			"9876543212", "603203", "TN,India");
	UserDto user2 = new UserDto("ramesh", "No.45,IndraNagar,Bangalore", "666", "bbb@gmail.com", "savings", "female",
			"6789065432", "607983", "KA,India");
	UserDto user3 = new UserDto("patel", "No.55,IndraNagar,Mumbai", "777", "ccc@gmail.com", "savings", "male",
			"8907654567", "100061", "MH,India");

	@GetMapping("addresses")
	@ResponseBody
	public Map<String, Object> validateAddress(@RequestParam String address, @RequestParam String stateandcountry,
			@RequestParam String pincode){
		Map<String, Object> rtn = new LinkedHashMap<>();
		int flag = 0;
		if (address.equals(user1.getAddress()) || address.equals(user2.getAddress())
				|| address.equals(user3.getAddress())) {
			if (stateandcountry.equals(user1.getStateAndCountry()) || stateandcountry.equals(user2.getStateAndCountry())
					|| stateandcountry.equals(user3.getStateAndCountry())) {
				if (pincode.equals(user1.getPincode()) || pincode.equals(user2.getPincode())
						|| pincode.equals(user3.getPincode()))
					flag = 1;
			}
		}
		if (flag == 1)
			rtn.put("Address", "Validated");
		else
			throw new UserNotFoundException("ADDRESS VALIDATION FAILED"); 
		return rtn;

	}

	@GetMapping("creditcheck")
	@ResponseBody
	public Map<String, Object> checkCredit(@RequestParam String username) {
		Map<String, Object> rtn = new LinkedHashMap<>();
		if (username.toLowerCase().equals(user1.getuserName())) {
			rtn.put("Credit Score", user1.getCreditScore());
		} else if (username.toLowerCase().equals(user2.getuserName())) {
			rtn.put("Credit Score", user2.getCreditScore());
		} else if (username.toLowerCase().equals(user3.getuserName())) {
			rtn.put("Credit Score", user3.getCreditScore());
		} else {
			throw new UserNotFoundException("User Not Found"); 
		}

		return rtn;
	}

	Map<String, Object> rtn1 = new LinkedHashMap<>();

	@PostMapping("accounts")
	public Map<String, Object> process(@RequestBody UserDto user) {

		rtn1.put("Account", user);
		Map<String, Object> rtn = new LinkedHashMap<>();
		String uniqueID = UUID.randomUUID().toString();
		rtn.put("Account id", uniqueID);
		System.out.println(user.getAddress());
		return rtn;
	}

	@GetMapping("getaccount")
	@ResponseBody
	public Map<String, Object> getAccount() {
		return rtn1;
	}
	
	
}

@ResponseStatus(HttpStatus.NOT_FOUND)  
class UserNotFoundException extends RuntimeException   
{  
public UserNotFoundException(String message)   
{  
super(message);  
}  
}

  

