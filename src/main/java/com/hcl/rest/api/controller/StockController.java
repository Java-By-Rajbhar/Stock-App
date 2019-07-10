package com.hcl.rest.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.rest.api.entity.Stock;
import com.hcl.rest.api.service.ImplStockService;

@RestController
@RequestMapping("/stock")
public class StockController {

	@Autowired
	ImplStockService implStockService;
	
	@PostMapping("/addStock")
	public Stock addStock(@RequestHeader("userId") int userId,@RequestBody Stock stock)
	{
		return implStockService.addStock(userId, stock);
	}
	
	@GetMapping("/allStock")
	public List<Stock> getAllStock(@RequestHeader("userId") int userId)
	{
		return implStockService.getStocks(userId);
	}
	
	@GetMapping("/buyshare/{numberOfShare}/{pricePerShare}")
	public String buyShare(@RequestHeader("userId") int userId,@PathVariable int numberOfShare,@PathVariable double pricePerShare)
	{
		return implStockService.buyShare(userId, numberOfShare, numberOfShare);
	}
}
