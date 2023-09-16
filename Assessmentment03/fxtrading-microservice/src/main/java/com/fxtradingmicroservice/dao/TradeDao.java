package com.fxtradingmicroservice.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.fxtradingmicroservice.entity.Trade;

@Repository
public class TradeDao {

	@Autowired
	SessionFactory sessionFactory;

	//Get all the data's from database
	public List<Trade> getAllTrade() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Trade.class);
		return criteria.list();
	}

	public String getTradeDetail(Trade trade) {
		Session session = sessionFactory.openSession();
		session.save(trade);
		session.beginTransaction().commit();
		return "Trade have been Posted Successfully";
	}

	public String getTradingDetailByRequiredValue(Trade trade) {
		Session session = sessionFactory.openSession();
		session.save(trade);
		session.beginTransaction().commit();
		return "Trade Worked Successfully";
	}
}
