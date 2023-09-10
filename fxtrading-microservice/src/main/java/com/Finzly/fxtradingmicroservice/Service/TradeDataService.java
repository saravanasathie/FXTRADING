package com.Finzly.fxtradingmicroservice.Service;

import java.util.List;

import com.Finzly.fxtradingmicroservice.Model.Trade;


public interface TradeDataService {
	public String createTrade(Trade trade);
	public String updateTrade(Trade trade);
	public String DeleteTrade(int id);
	public Trade getTrade(int id);
	public List<Trade> getAllTrade();
}
