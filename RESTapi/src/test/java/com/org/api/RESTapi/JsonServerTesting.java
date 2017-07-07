package com.org.api.RESTapi;

import org.junit.Test;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.org.api.POJOclass.PostRequest;

import static com.jayway.restassured.RestAssured.*;


public class JsonServerTesting {

	//@Test
	public void GetRequest(){
		Response resp= given().when().get("http://localhost:3000/posts");
		System.out.println(resp.asString());
	}
	//@Test
	public void PostRequestByString(){
		Response resp=given().body(" {\"id\":\"3\","
				+ " \"title\":\"King is\","
				+ "\"author\":\"Siddhesh\" } ").
		when().
		contentType(ContentType.JSON).
		post("http://localhost:3000/posts");
		System.out.println(resp.asString());
	}
	//@Test
	public void PostRequestByObject(){
		PostRequest pr=new PostRequest();
		pr.setId("4");
		pr.setTitle("Pirates of Carabian");
		pr.setAuthor("Captain Jack Sparrow");
		Response resp=given().
				body(pr).
				contentType(ContentType.JSON).
				when().
				post("http://localhost:3000/posts");
		System.out.println(resp.asString());
	}
	//PUT /posts/1
	//@Test
	public void PutRequest(){
		PostRequest pr=new PostRequest();
		pr.setId("3");
		pr.setTitle("Updated King");
		pr.setAuthor("Updated sid");
		Response resp=given().
				when().
				contentType(ContentType.JSON).
				body(pr).
				put("http://localhost:3000/posts/3");
		System.out.println(resp.asString());
	}
	//PATCH /posts/1
	//@Test 
	public void PatchRequest(){
		Response resp= given().when().contentType(ContentType.JSON).
				body(" {\"author\":\"Updated Siddhesh\"} ").
				patch("http://localhost:3000/posts/1");
		System.out.println(resp.asString());
	}
	//Delete/posts/3
	@Test
	public void DeleteRequest(){
		Response resp= given().
				when().
				delete("http://localhost:3000/posts/3");
		System.out.println(resp.asString());
	}
	
}
