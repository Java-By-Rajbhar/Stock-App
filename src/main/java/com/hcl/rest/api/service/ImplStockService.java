package com.hcl.rest.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.rest.api.entity.Stock;
import com.hcl.rest.api.entity.UserRegistration;
import com.hcl.rest.api.exception.NumberOfShareOrSharePriceMoreException;
import com.hcl.rest.api.exception.UserDoesNotExistException;
import com.hcl.rest.api.repository.StockRepository;
import com.hcl.rest.api.repository.UserRepository;

@Service
public class ImplStockService implements StockService {

	@Autowired
	UserRepository userRepository;
	@Autowired
	StockRepository stockRepository;

	@Override
	public Stock addStock(int userId, Stock stock) {
		UserRegistration user = userRepository.findById(userId);
		if(user!=null)
		{
			return stockRepository.save(stock);
		}
		else
		{
			throw new UserDoesNotExistException("Sorry you are not registered ,Please register");
		}
	}

	@Override
	public List<Stock> getStocks(int userId) {
		UserRegistration user = userRepository.findById(userId);
		if(user!=null)
		{
			return stockRepository.findAll();
		}
		else
		{
			throw new UserDoesNotExistException("Sorry you are not registered ,Please register");
		}
	}

	@Override
	public String buyShare(int userId, int numberOfShare, double pricePerShare) {
		UserRegistration user = userRepository.findById(userId);
		if(user!=null)
		{
			if(numberOfShare<=5 &&  (pricePerShare*numberOfShare)<=250)
			{
				return "You have purchased "+numberOfShare+" of price "+(pricePerShare*numberOfShare)+" successfully";
			}
			else
			{
				throw new NumberOfShareOrSharePriceMoreException("You can purchase maximum 5 share or 250 rupees share");
			}
		}
		else
		{
			throw new UserDoesNotExistException("Sorry you are not registered ,Please register");
		}
	}

}
