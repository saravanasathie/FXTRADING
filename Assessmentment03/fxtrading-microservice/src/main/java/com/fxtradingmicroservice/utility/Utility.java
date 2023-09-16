
package com.fxtradingmicroservice.utility;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fxtradingmicroservice.dao.CurrencyPairDao;
import com.fxtradingmicroservice.dao.TradeDao;
import com.fxtradingmicroservice.entity.CurrencyPair;
import com.fxtradingmicroservice.entity.Trade;
import com.fxtradingmicroservice.exception.CurrencyNotValidException;
import com.fxtradingmicroservice.exception.ExchangeDataNotExistsException;
import com.fxtradingmicroservice.utility.Utility.CurrencyPairStatus;

@Component
public class Utility {
	@Autowired
	TradeDao tradeDao;
	@Autowired
	CurrencyPairDao currencyPairDao;

	// checking valid amount
	public static boolean valid(Trade trade) {
		if (trade.getTransfer() < 1) {
			return false;
		} else {
			return true;
		}
	}

	//checking valid pair
	public static class CurrencyPairStatus {
		public static boolean currencyStatus = false;
	}

	//checking valid Name
	public static boolean validName(Trade trade) {
		String name = trade.getCustomerName();
		if (!name.trim().equalsIgnoreCase("") && name.matches("^(?!\\.+$)[A-Za-z. ]+$")) {

			return true;
		} else {
			return false;
		}
	}

	// Get Trade By Required Value 
	public String getTradingDetailByRequiredValue(Trade trade) throws ExchangeDataNotExistsException {
		if (valid(trade) && validName(trade)) {
			//exchange values transfer to transfered value to know the actual amount to get transfer
			trade.setTransferValue(trade.getTransfer());
			List<CurrencyPair> trader = currencyPairDao.getCurrencyPairInfo();
			for (CurrencyPair trading : trader) {
				if (trading.getCurrencyPairID() == trade.getCurrencyPair().getCurrencyPairID()) {
					trade.setTransfer(trade.getTransferValue() / trading.getRate());
					CurrencyPairStatus.currencyStatus = true;
					break;
				}
			}
			if (!CurrencyPairStatus.currencyStatus) {
				throw new CurrencyNotValidException("No Matching Currency Pair found.Kindly do try again ");
			}
		} else {
			return "Input is not valid kindly try again";
		}
		return tradeDao.getTradingDetailByRequiredValue(trade);
	}

	// Get the Trade Details 
	public String getTradeDetail(Trade trade) throws CurrencyNotValidException{
		if (valid(trade) && validName(trade)) {
			List<CurrencyPair> trader = currencyPairDao.getCurrencyPairInfo();
			for (CurrencyPair trading : trader) {
				if (trading.getCurrencyPairID() == trade.getCurrencyPair().getCurrencyPairID()) {
					trade.setTransferValue(trading.getRate() * trade.getTransfer());
					CurrencyPairStatus.currencyStatus = true;
					break;
				}
			}
			if (!CurrencyPairStatus.currencyStatus) {
			  throw new CurrencyNotValidException("No Matching Currency Pair found.Kindly do try again ");
			}
		} 
		else {
			return "Input is not valid kindly try again";
		}
		return tradeDao.getTradeDetail(trade);
	}
}
