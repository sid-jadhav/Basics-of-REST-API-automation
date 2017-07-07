package com.org.api.RESTapi;

import org.junit.Test;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.org.api.POJOclass.ComplexPost;
import com.org.api.POJOclass.Info;
import static com.jayway.restassured.RestAssured.*;

public class ComplexPostRequest {
	
	@Test
	public void ComplexPost1(){
		Info info =new Info();
		info.setNoPages("200");
		info.setPublisher("King Jr");
		info.setType("Constitution");
		ComplexPost comPost=new ComplexPost();
		comPost.setAuthor("Sid");
		comPost.setId("3");
		comPost.setInfo(info);
		comPost.setTitle("How to rule the world");
		Response resp =given().
				contentType(ContentType.JSON).body(comPost).
				when().
				post("http://localhost:3000/posts");
		System.out.println(resp.asString());
	}
}
