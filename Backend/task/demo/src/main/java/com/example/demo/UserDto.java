package com.example.demo;

public class UserDto {

	private String accountType;
	private String address;
	private String creditScore;
	private String email;
	private String userName;
	private String gender;
	private String number;
	private String pincode;
	private String stateAndCountry;

	public UserDto() {
		super();
	}

	public UserDto(String userName, String address, String creditScore, String email, String accountType, String gender,
			String number, String pincode, String stateAndCountry) {
		super();
		this.accountType = accountType;
		this.address = address;
		this.creditScore = creditScore;
		this.email = email;
		this.userName = userName;
		this.gender = gender;
		this.number = number;
		this.pincode = pincode;
		this.stateAndCountry = stateAndCountry;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCreditScore() {
		return creditScore;
	}

	public void setCreditScore(String creditScore) {
		this.creditScore = creditScore;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getuserName() {
		return userName;
	}

	public void setuserName(String userName) {
		this.userName = userName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getStateAndCountry() {
		return stateAndCountry;
	}

	public void setStateAndCountry(String stateAndCountry) {
		this.stateAndCountry = stateAndCountry;
	}

}