package com.companyservice.service;

import org.springframework.stereotype.Service;

import com.companyservice.beans.AllCompanies;

@Service
public class CompanyService {
	
	private AllCompanies allCompanies;

	public void save(AllCompanies companies) {
		// TODO Auto-generated method stub
		allCompanies = companies;
	}
	
	public AllCompanies getAllCompanies() {
		return allCompanies;
	}
	
}
