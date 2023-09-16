package com.fxtradingmicroservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.fxtradingmicroservice.dao.CurrencyPairDao;
import com.fxtradingmicroservice.dao.TradeDao;
import com.fxtradingmicroservice.entity.Trade;
import com.fxtradingmicroservice.exception.CurrencyNotValidException;
import com.fxtradingmicroservice.exception.ExchangeDataNotExistsException;
import com.fxtradingmicroservice.utility.Utility;

@Service
public class TradeService {

	@Autowired
	TradeDao fxTradingDao;
	@Autowired
	CurrencyPairDao currenyPairDao;
	@Autowired
	Utility utilityDao;

//  Get all trade services
	public List<Trade> getAllTrade() {
		return fxTradingDao.getAllTrade();
	}

//	Post send value services with valid currency pair
	public String getTradeDetail(Trade trade) throws CurrencyNotValidException{
		return utilityDao.getTradeDetail(trade);
	}


	//Post needed value services with valid currency pair
	public String getTradingDetailByRequiredValue(Trade trade) throws ExchangeDataNotExistsException {
		return utilityDao.getTradingDetailByRequiredValue(trade);
	}
	


}
