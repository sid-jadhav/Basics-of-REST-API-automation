package com.org.api.RESTapi;

import org.junit.Test;
import org.testng.Assert;

import com.jayway.restassured.response.Response;

import static com.jayway.restassured.RestAssured.*;
public class GetRequest {
//Get Weather Report by city name
	//@Test
	public void Test_1(){
		Response resp;
		resp=when().get("http://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b1b15e88fa7972252429c1c50c122a1");
		System.out.println(resp.statusCode());
		Assert.assertEquals(200, resp.getStatusCode());
	}
	
//How to use parameters 
	//@Test
	public void Test_2(){
		Response resp= given().param("q", "London").
							   param("appid","b1b15e88fa7972252429c1c50c122a1").
							   when().
							   get("http://samples.openweathermap.org/data/2.5/weather");
		Assert.assertEquals(200, resp.getStatusCode());
		System.out.println(resp.asString());
	}
	//For Smoke testing we can use this type of tests to verify whether the
	//API is working or not
	@Test
	public void Test_3(){
//					given().
//					param("q", "London").
//					param("appid","b1b15e88fa7972252429c1c50c122a1").
//				   	when().
//				   	get("http://samples.openweathermap.org/data/2.5/weather").
//				   	then().assertThat().statusCode(200);
					String s="Hi";
					int i=Integer.parseInt(s);
					System.out.println(i);
	}
}
