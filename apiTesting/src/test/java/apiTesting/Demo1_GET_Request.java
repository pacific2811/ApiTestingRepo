package apiTesting;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Demo1_GET_Request {

	@Test
	void getWeatherDetails() {

//		Specify Base URI
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";

//		Request Object Created
		RequestSpecification httprequest = RestAssured.given();

//		Response Object
		Response response = httprequest.request(Method.GET, "/Pune");

//		Print Response in console window
		String responsebody = response.getBody().asString();
		System.out.println(" Response : " + responsebody);

//		Status Code Validation check
		int statuscode = response.getStatusCode();
		System.out.println("Status Code : " + statuscode);
		Assert.assertEquals(statuscode, 200);

//		Status Line Verification
		String statusline = response.getStatusLine();
		System.out.println("Status line : "+ statusline);
		Assert.assertEquals(statusline, "HTTP/1.1 200 OK");
	}

}
