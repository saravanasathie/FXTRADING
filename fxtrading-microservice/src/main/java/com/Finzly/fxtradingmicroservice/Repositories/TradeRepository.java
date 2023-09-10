package com.Finzly.fxtradingmicroservice.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Finzly.fxtradingmicroservice.Model.Trade;

@Repository
public interface TradeRepository extends JpaRepository<Trade , Integer>{

}