package com.Finzly.fxtradingmicroservice.Service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.Finzly.fxtradingmicroservice.Model.Trade;
import com.Finzly.fxtradingmicroservice.Repositories.TradeRepository;


@Service
public class TradeService implements TradeDataService {

	public static int tradeNo = 1;
	public List<Trade> list = new ArrayList<>();
	TradeRepository tradeRepository;

	public TradeService(TradeRepository tradeRepository) {
		this.tradeRepository = tradeRepository;
	}

	public boolean bookTrades(Trade trade) {
		if (trade.getCustomerName().matches("^[a-zA-Z ][a-zA-Z ]*\\.?[a-zA-Z ]*$") && trade != null
				&& !trade.getCustomerName().trim().isEmpty() && trade.getAmount() > 1
				&& trade.getCurrencyPair().equalsIgnoreCase("USDINR")) {
			trade.setId(tradeNo++);
			return true;
		} else {
			return false;
		}
	}

	public boolean isValid(Trade trade) {

		if (trade.getCustomerName().matches("^[a-zA-Z ][a-zA-Z ]*\\.?[a-zA-Z ]*$") && trade != null
				&& !trade.getCustomerName().trim().isEmpty() && trade.getAmount() > 1
				&& trade.getCurrencyPair().equalsIgnoreCase("USDINR")) {
			return true;
		} else {
			return false;
		}
	}

	public Trade getByTradeNo(int id) {
		for (Trade trade : list) {
			if (trade.getId() == id) {
				return trade;
			}
		}
		return null;

	}

	public static String formatAmount(double amount) {
		DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
		return decimalFormat.format(amount);
	}

	public double totalAmount(Trade trade) {
		return trade.getAmount() * Trade.usdToInrRate;
	}

	@Override
	public String createTrade(Trade trade) {
		tradeRepository.save(trade);
		return "Success";
	}

	@Override
	public String updateTrade(Trade trade) {
		tradeRepository.save(trade);
		return "Success";
	}

	@Override
	public String DeleteTrade(int id) {
		tradeRepository.deleteById(id);
		return "Deleted Successfully";
	}

	@Override
	public Trade getTrade(int id) {
		return tradeRepository.findById(id).get();
	}

	@Override
	public List<Trade> getAllTrade() {
		return tradeRepository.findAll();
	}

}
