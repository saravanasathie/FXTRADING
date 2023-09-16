package com.fxtradingmicroservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CurrencyPair {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int currencyPairID;
	private String currencyPair;
	private double rate;
	public int getCurrencyPairID() {
		return currencyPairID;
	}
	public void setCurrencyPairID(int currencyPairID) {
		this.currencyPairID = currencyPairID;
	}
	public String getCurrencyPair() {
		return currencyPair;
	}
	public void setCurrencyPair(String currencyPair) {
		this.currencyPair = currencyPair;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public CurrencyPair( int currencyPairID) {
		this.currencyPairID=currencyPairID;
	}
	public CurrencyPair() {
		super();
	}
	
}
