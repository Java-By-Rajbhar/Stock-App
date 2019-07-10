package com.hcl.rest.api.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stock_detail")
public class Stock implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int stockId;
	private String companyName;
	private int numberOfShare;
	private double pricePerShare;
	private Date sharePurchasedate;
	private int userId;

	public int getStockId() {
		return stockId;
	}

	public void setStockId(int stockId) {
		this.stockId = stockId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public int getNumberOfShare() {
		return numberOfShare;
	}

	public void setNumberOfShare(int numberOfShare) {
		this.numberOfShare = numberOfShare;
	}

	public double getPricePerShare() {
		return pricePerShare;
	}

	public void setPricePerShare(double pricePerShare) {
		this.pricePerShare = pricePerShare;
	}

	public Date getSharePurchasedate() {
		return sharePurchasedate;
	}

	public void setSharePurchasedate(Date sharePurchasedate) {
		this.sharePurchasedate = sharePurchasedate;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Stock() {
		super();
	}

}
