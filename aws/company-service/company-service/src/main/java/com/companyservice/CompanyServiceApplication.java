package com.companyservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.companyservice.beans.AllCompanies;
import com.companyservice.service.CompanyService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

@SpringBootApplication
public class CompanyServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompanyServiceApplication.class, args);
	}
	
	@Bean
    // Bean to read in the json file and and save it to the Mysfits list
    CommandLineRunner runner(CompanyService companyService) {
        return args -> {
            String jsonFile = "/json/mysfits-response.json";
            ObjectMapper jsonMapper = new ObjectMapper();
            InputStream inputStream = TypeReference.class.getResourceAsStream(jsonFile);

            try {
                AllCompanies allCompanies = jsonMapper.readValue(inputStream, AllCompanies.class);
                companyService.save(allCompanies);
            }
            catch (IOException e) {
                System.out.println("Unable to get companies: " + e.getMessage());
            }
        };
    }

}
