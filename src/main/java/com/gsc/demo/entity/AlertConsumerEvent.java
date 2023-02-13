package com.gsc.demo.entity;

public class AlertConsumerEvent {
	
	private String customerName;
	private String email;
	private long mobileNumber;
	public AlertConsumerEvent(String customerName, String email, long mobileNumber) {
		super();
		this.customerName = customerName;
		this.email = email;
		this.mobileNumber = mobileNumber;
	}
	public String getCustomerName() {
		return customerName;
	}
	public String getEmail() {
		return email;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}

	
	
	

}
