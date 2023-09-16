package com.fxtradingmicroservice.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fxtradingmicroservice.dao.TradeDao;
import com.fxtradingmicroservice.entity.Trade;
import com.fxtradingmicroservice.exception.CurrencyNotValidException;
import com.fxtradingmicroservice.exception.ExchangeDataNotExistsException;
import com.fxtradingmicroservice.service.TradeService;

@RestController
@RequestMapping("trade")
public class TradeController {

	@Autowired
	TradeService tradeService;

	//Get all trade
	@GetMapping("getalltrade")
	public List<Trade> getAllTrade() {
		return tradeService.getAllTrade();
	}

	//Book the trade
	@PostMapping("booktrade")
	public String getTradeDetail(@RequestBody Trade trade) throws CurrencyNotValidException {
		return tradeService.getTradeDetail(trade);
	}

	//Book trade by Required Value
	@PostMapping("requiredvalue")
	public String getTradingDetailByRequiredValue(@RequestBody Trade trade) throws ExchangeDataNotExistsException {
		return tradeService.getTradingDetailByRequiredValue(trade);
	}

}
