package com.companyservice.beans;

public class Company {
	

	
	private long id;
	
	
	private String companyCode;
	
	
	private String companyName;
	
	
	private String companyCEO;
	
	
	private long companyTurnover;
	
	
	private String companyWebsite;
	
	
	private String stockExchange;
	
	private Double latestStockPrice;

	public Company() {
		
	}

	public Company(long id, String companyCode, String companyName, String companyCEO, long companyTurnover,
			String companyWebsite, String stockExchange, Double latestStockPrice) {
		
		this.id = id;
		this.companyCode = companyCode;
		this.companyName = companyName;
		this.companyCEO = companyCEO;
		this.companyTurnover = companyTurnover;
		this.companyWebsite = companyWebsite;
		this.stockExchange = stockExchange;
		this.latestStockPrice = latestStockPrice;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyCEO() {
		return companyCEO;
	}

	public void setCompanyCEO(String companyCEO) {
		this.companyCEO = companyCEO;
	}

	public long getCompanyTurnover() {
		return companyTurnover;
	}

	public void setCompanyTurnover(long companyTurnover) {
		this.companyTurnover = companyTurnover;
	}

	public String getCompanyWebsite() {
		return companyWebsite;
	}

	public void setCompanyWebsite(String companyWebsite) {
		this.companyWebsite = companyWebsite;
	}

	public String getStockExchange() {
		return stockExchange;
	}

	public void setStockExchange(String stockExchange) {
		this.stockExchange = stockExchange;
	}

	public Double getLatestStockPrice() {
		return latestStockPrice;
	}

	public void setLatestStockPrice(Double latestStockPrice) {
		this.latestStockPrice = latestStockPrice;
	}
	
	
	


}
