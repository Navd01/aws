package com.companyservice.beans;

import java.util.List;

public class AllCompanies {
	
	private List<Company> AllCompanies;
	
	public AllCompanies() {
		
	}

	public AllCompanies(List<Company> allCompanies) {
		
		AllCompanies = allCompanies;
	}

	public List<Company> getAllCompanies() {
		return AllCompanies;
	}

	public void setAllCompanies(List<Company> allCompanies) {
		AllCompanies = allCompanies;
	}
	
	

}
