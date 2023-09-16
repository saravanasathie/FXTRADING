	package com.fxtradingmicroservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Trade{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String customerName;
	private double transfer;
	private double transferValue;
	@OneToOne
    private CurrencyPair currencyPair;
	public Trade(int id, String customerName, double transfer, double transferValue, CurrencyPair currencyPair) {
		super();
		this.id = id;
		this.customerName = customerName;
		this.transfer = transfer;
		this.transferValue = transferValue;
		this.currencyPair = currencyPair;
	}
	public Trade() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public double getTransfer() {
		return transfer;
	}
	public void setTransfer(double transfer) {
		this.transfer = transfer;
	}
	public double getTransferValue() {
		return transferValue;
	}
	public void setTransferValue(double transferValue) {
		this.transferValue = transferValue;
	}
	public CurrencyPair getCurrencyPair() {
		return currencyPair;
	}
	public void setCurrencyPair(CurrencyPair currencyPair) {
		this.currencyPair = currencyPair;
	}
	
			
	
}
