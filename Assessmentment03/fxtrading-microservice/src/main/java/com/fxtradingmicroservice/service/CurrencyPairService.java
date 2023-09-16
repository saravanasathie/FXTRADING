package com.fxtradingmicroservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fxtradingmicroservice.dao.CurrencyPairDao;
import com.fxtradingmicroservice.entity.CurrencyPair;

@Service
public class CurrencyPairService {
	@Autowired
	CurrencyPairDao currenyPairDao;

//Get all currency pair
	public List<CurrencyPair> getAllCurrencyPair() {
		return currenyPairDao.getAllCurrencyPair();
	}
}
