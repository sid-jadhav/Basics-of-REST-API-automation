package com.org.api.RESTapi;

import org.junit.Test;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import static com.jayway.restassured.RestAssured.*;

public class GetResquest1 {
	//@Test
	public void ReportByID() {
		Response resp = given().parameter("q", "London").parameter("appid", "b1b15e88fa797225412429c1c50c122a1").when()
				.get("http://samples.openweathermap.org/data/2.5/weather");
		String s = resp.asString();
		System.out.println(s);
		s = resp.then().contentType(ContentType.JSON).extract().path("weather[0].description");
		System.out.println(s);
	}
	@Test
	public void ReportBy_long_lat() {
		Response resp = given().parameter("q", "London").parameter("appid", "b1b15e88fa797225412429c1c50c122a1").when()
				.get("http://samples.openweathermap.org/data/2.5/weather");
		String s = resp.asString();
		s = resp.then().contentType(ContentType.JSON).extract().path("weather[0].description");
		String lon= String.valueOf(resp.
					then().
					contentType(ContentType.JSON).
					extract().path("coord.lon"));
		String lat= String.valueOf(resp.
				then().
				contentType(ContentType.JSON).
				extract().path("coord.lat"));
		Response resp1=given().parameters("lon", "35").parameter("lat", "139").
				parameter("appid", "b1b15e88fa797225412429c1c50c122a1").when().
				get("http://samples.openweathermap.org/data/2.5/weather");
		System.out.println(resp1.asString());
	}
}
