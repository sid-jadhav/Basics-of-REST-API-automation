package com.org.api.RESTapi;

import org.junit.Test;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.org.api.POJOclass.ComplexPostArray;
import com.org.api.POJOclass.Info;
import static com.jayway.restassured.RestAssured.*;

public class ComplexPostRequestArray {
	@Test
	public void PostRequestWithArray(){
		Response resp;
		ComplexPostArray cpa=new ComplexPostArray();
		cpa.setAuthor("jayu");
		cpa.setId("8");
		cpa.setTitle("I did complex post request");
		Info info0=new Info();
		Info info1=new Info();
		info0.setNoPages("11");
		info0.setPublisher("King Publications");
		info0.setType("Learn to earn");
		info1.setNoPages("12");
		info1.setPublisher("Kingch ki Publications");
		info1.setType("earn and then fun");
		Info[] info={info0,info1};
		cpa.setInfo(info);
		resp=given().
				contentType(ContentType.JSON).
				body(cpa).
				when().
				post("http://localhost:3000/posts");
		System.out.println(resp.asString());
	}
}
