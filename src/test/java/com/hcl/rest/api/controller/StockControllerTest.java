package com.hcl.rest.api.controller;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.rest.api.entity.Stock;
import com.hcl.rest.api.service.ImplStockService;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = { TestContext.class, StockController.class })
@WebAppConfiguration

public class StockControllerTest {
	
	@InjectMocks
	StockController stockController;
	
	private MockMvc mockMvc;
	
	@Mock
	ImplStockService implStockService;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(stockController).build();
	}
	
	@Test
	public void addStockTest() throws Exception
	{
		int stockId =1;
		String name = "hcl";
		Stock stock= new Stock();
		stock.setStockId(stockId);
		stock.setCompanyName(name);
		
		Mockito.when(implStockService.addStock(Mockito.anyInt(), Mockito.any())).thenReturn(stock);
		
		this.mockMvc.perform(
				post("/stock/addStock/",stockId,stock).contentType(MediaType.APPLICATION_JSON).content(asJsonString(stock)))
				.andReturn();
		Stock stock1 = stockController.addStock(stockId, stock);
		assertEquals(name, stock1.getCompanyName());
	}
	
	@Test
	public void getAllStockTest() throws Exception
	{
		int userId =1;
		int stockId =1;
		String name = "hcl";
		Stock stock= new Stock();
		
		stock.setStockId(stockId);
		stock.setCompanyName(name);
		List<Stock> stockList = new ArrayList<>();
		stockList.add(stock);
		Mockito.when(implStockService.getStocks(Mockito.anyInt())).thenReturn(stockList);
		
		this.mockMvc.perform(
				get("/stock/allStock/",userId).contentType(MediaType.APPLICATION_JSON).content(asJsonString(userId)))
				.andReturn();
		List<Stock> liststock1 = stockController.getAllStock(userId);
		assertEquals(1, liststock1.size());
	}
	
	@Test
	public void buyShareTest() throws Exception
	{
		int userId =1;
		int numberOfShare =5;
		double pricePerShare =10;
		String response="You have purchased "+numberOfShare+" of price "+(pricePerShare*numberOfShare)+" successfully";
		Mockito.when(implStockService.buyShare(userId, numberOfShare, pricePerShare)).thenReturn(response);
		
		this.mockMvc.perform(
				get("/buyshare/{numberOfShare}/{pricePerShare}",userId,numberOfShare,pricePerShare).contentType(MediaType.APPLICATION_JSON).content(asJsonString(userId)))
				.andReturn();
		String response1 = stockController.buyShare(userId, numberOfShare, pricePerShare);
		assertEquals(response, response1);
	}
	
	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
