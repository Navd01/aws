package com.companyservice.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import com.companyservice.beans.AllCompanies;

import com.companyservice.service.CompanyService;

@RestController
public class CompanyController {

	@Autowired
	CompanyService companyService;

	@GetMapping("/getall")
	public AllCompanies getAllCompanies(HttpServletResponse response) {

		response.addHeader("Access-Control-Allow-Origin", "*");
		return companyService.getAllCompanies();
	}
}
