package com.gr.framework;

import java.util.Map;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import com.gr.cinema.common.CurrentSession;
import com.gr.cinema.common.EnvPropertyLoader;
import com.gr.cinema.common.JDBCDatasource;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TestBase {
	
	@Autowired
	EnvPropertyLoader envPropLoader;
	
	@Autowired
	protected CurrentSession session;
	
	@Autowired
	protected JDBCDatasource jdbcDatasource;
	
	protected Map<String,String> envMap;
	
	
	public String executePOST(String url, String jsonString) {
		
		System.out.println("POST URL - "+url);
		System.out.println("POST Request Payload - \n"+jsonString+"\n\n");
		
		Response response = RestAssured.given()
				.contentType(ContentType.JSON)
				.body(jsonString).when().post(url);
		
		if (response != null) {
			System.out.println("POST operation completed , HTTP Status - "+response.getStatusCode());
			System.out.println("POST Response Payload -\n "+response.asString()+"\n\n");
			
		}else {
			Assert.fail("Problem while performing the POST operation");
		}
		
		return response.asString();
		
	}
	
	
	public String executeGET(String url , Map<String,String> parameters) {
		
		System.out.println("GET URL -"+url);
		
		Response response  = RestAssured.given().contentType(ContentType.JSON)
				.formParams(parameters).when().get(url);
		
		if (response != null) {
			System.out.println("GET operation completed , HTTP Status - "+response.getStatusCode());
			System.out.println("GET Response Payload -\n "+response.asString()+"\n\n");
			
		}else {
			Assert.fail("Problem while performing the GET operation");
		}
		
		return response.asString();
		
	}
	
	public void loadEnv() {
		if (envMap == null) {
			envMap = envPropLoader.getEnvMap();
		}
		
	}
	
}
