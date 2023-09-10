package com.Finzly.fxtradingmicroservice.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Trade{
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
    private String currencyPair;
	@Column
	private String customerName;
	@Column
	private double amount;
	@Column
	private double inrValue = 0;
	public static final double usdToInrRate = 90;    //Default rate
        
    public double getInrValue() {
		return inrValue;
	}

	public void setInrValue(double inrValue) {
		this.inrValue = inrValue;
	}

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static double getUsdtoinrrate() {
		return usdToInrRate;
	}

	public String getCurrencyPair() {
        return currencyPair;
    }

    public void setCurrencyPair(String currencyPair) {
        this.currencyPair = currencyPair;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    Trade(String currencyPair, String customerName, double amount){
    	this.currencyPair = currencyPair;
        this.customerName = customerName;
        this.amount = amount;
    }
    Trade(){
    	
    }
	

}
