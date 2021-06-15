package com.companyservice.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.companyservice.beans.AllCompanies;
import com.companyservice.beans.Company;
import com.companyservice.service.CompanyService;

@RestController
public class CompanyController {

	@Autowired
	CompanyService companyService;

	@GetMapping("/getAllCompanies")
    public AllCompanies getAllCompanies(HttpServletResponse response,
            @RequestParam(value = "filter", required = false) String filter,
            @RequestParam(value = "value", required = false) String value ) {

        response.addHeader("Access-Control-Allow-Origin", "*");

        AllCompanies allCompanies;

        if (filter != null)
        	allCompanies = companyService.queryCompanyItems(filter, value);
        else
        	allCompanies = companyService.getAllCompanies();

        return allCompanies;
    }
	
	@PostMapping("/saveCompany")
	public void saveCompany(@RequestBody Company  company) {
		
		companyService.save(company);
		System.out.println(company);
		
	}
	
	@DeleteMapping("/deleteCompany")
	public void deleteCompany(@RequestBody Company company) {
		
		companyService.deleteCompany(company);
	}
	
	@GetMapping("/companyHealth")
    public String healthCheckResponse() {
        return "Nothing here, used for health check. Try /getall instead.";
    }
    
    
}
