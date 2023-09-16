package com.fxtradingmicroservice.dao;

import java.util.List;

import org.hibernate.Session;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fxtradingmicroservice.entity.CurrencyPair;

@Repository
public class CurrencyPairDao {

	@Autowired
	SessionFactory sessionFactory;

	//getting all data from Trading currency pair
	public List<CurrencyPair> getCurrencyPairInfo() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(CurrencyPair.class);
		return criteria.list();
	}

	// get all currency pair
	public List<CurrencyPair> getAllCurrencyPair() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(CurrencyPair.class);
		return criteria.list();

	}
}
