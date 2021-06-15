package com.companyservice.service;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.companyservice.beans.AllCompanies;
import com.companyservice.beans.Company;


@Service
public class CompanyService {
	
    private final AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
			.withRegion(Regions.AP_SOUTH_1)
			.build();
    private DynamoDBMapper mapper = new DynamoDBMapper(client);
	
    public void save(Company company) {
    	HashMap<String, AttributeValue> attribValue = new HashMap<String, AttributeValue>();
    	attribValue.put("id", new AttributeValue(company.getId()));
    	attribValue.put("companyCode", new AttributeValue(company.getCompanyCode()));
    	attribValue.put("companyName", new AttributeValue(company.getCompanyName()));
    	attribValue.put("companyCEO", new AttributeValue(company.getCompanyCEO()));
    	attribValue.put("companyTurnover", new AttributeValue(company.getCompanyTurnover()));
    	attribValue.put("companyWebsite", new AttributeValue(company.getCompanyWebsite()));
    	attribValue.put("stockExchange", new AttributeValue(company.getStockExchange()));
    	attribValue.put("latestStockPrice", new AttributeValue(company.getLatestStockPrice()));
  
    	client.putItem("CompanyTable" , attribValue);
    }
    
	public AllCompanies getAllCompanies() {

        List<Company> mysfits = mapper.scan(Company.class, new DynamoDBScanExpression());
        AllCompanies allCompanies = new AllCompanies(mysfits);

        return allCompanies;
    }
	
	public AllCompanies queryCompanyItems(String filter, String value) {

        HashMap<String, AttributeValue> attribValue = new HashMap<String, AttributeValue>();
        attribValue.put(":"+value,  new AttributeValue().withS(value));

        DynamoDBQueryExpression<Company> queryExpression = new DynamoDBQueryExpression<Company>()
                .withIndexName(filter+"Index")
                .withKeyConditionExpression(filter + "= :" + value)
                .withExpressionAttributeValues(attribValue)
                .withConsistentRead(false);

        List<Company> mysfits = mapper.query(Company.class, queryExpression);
        AllCompanies allCompanies = new AllCompanies(mysfits);

        return allCompanies;
    }
    
    public void deleteCompany(Company company) {
		mapper.delete(company);
	}
	
}
