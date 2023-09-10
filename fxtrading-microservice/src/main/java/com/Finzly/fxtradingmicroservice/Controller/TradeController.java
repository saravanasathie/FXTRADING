package com.Finzly.fxtradingmicroservice.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Finzly.fxtradingmicroservice.Model.Trade;
import com.Finzly.fxtradingmicroservice.Repositories.TradeRepository;
import com.Finzly.fxtradingmicroservice.Service.TradeService;


@RestController
@RequestMapping("trade")
public class TradeController {

	@Autowired
	TradeRepository tradeRepository;
	@Autowired
	TradeService service;
	
	Trade trade;
		
	public TradeController() {
		
	}
	
	//To get details by ID
	@GetMapping("get/{id}")
	public Trade getTradeDetails(@PathVariable("id") int id){
		return service.getTrade(id);
	}

	//To get all the details 
	@GetMapping("/print")
	public List<Trade> getAllTradeDetails(){
		return service.getAllTrade();
	}
	
	@PostMapping("book")
	public String createTradeDetails(@RequestBody Trade trade) {
	    double inrValue = service.totalAmount(trade);
	    trade.setInrValue(inrValue);

	    if (service.bookTrades(trade)) {
	        String result = service.createTrade(trade);
	        if ("Success".equals(result)) {
	            return "Trade is Added Successfully";
	        } else {
	            return "Failed to Add Trade to Database";
	        }
	    } else {
	        return "Invalid Trade Data. Trade Not Added";
	    }
	}

	@GetMapping("/rate/{id}")
	public String rate(@PathVariable("id") int id) {
	    Trade trade = service.getTrade(id);

	    if (trade == null) {
	        return "Trade with ID " + id + " not found.";
	    } else {
	        return "You are transferring " + trade.getCurrencyPair().substring(3, 6).toUpperCase() + " "
	                + trade.getInrValue() + " to " + trade.getCustomerName().toUpperCase() + " (Assuming that rate was "
	                + Trade.usdToInrRate + ")";
	    }
	}
	@PutMapping("/{id}")
    public String updateTradeDetails(@PathVariable int id, @RequestBody Trade trade) {
        trade.setId(id);
        service.updateTrade(trade);
        return "Trade Updated Successfully";
    }

	@DeleteMapping("del/{id}")
	public String deleteTradeDetails(@PathVariable("id") int id){
		service.DeleteTrade(id);
		return "Trade Deleted Successfully";
	}
	
	
	@GetMapping("exit")
	public void exitTrade() {
		System.exit(0);
	}

	
}
