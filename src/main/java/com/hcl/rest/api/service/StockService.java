package com.hcl.rest.api.service;

import java.util.List;

import com.hcl.rest.api.entity.Stock;

public interface StockService {
	
	public Stock addStock(int userId,Stock stock);
	
	public List<Stock> getStocks(int userId);
	
	public String buyShare(int userId,int NumberOfShare,double pricePerShare);

}
