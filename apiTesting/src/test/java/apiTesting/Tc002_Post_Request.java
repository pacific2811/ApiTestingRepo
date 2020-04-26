package apiTesting;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Tc002_Post_Request {

	@Test
	void Reistration() {
//	Specify Base URI
		RestAssured.baseURI = "http://restapi.demoqa.com/customer";

//	Request object
		RequestSpecification httprequest = RestAssured.given();

//	Request payloadalong with post request

		JSONObject requestparam = new JSONObject();
		requestparam.put("FirstName","Pacific");
		requestparam.put("LastName","Ocean");
		requestparam.put("UserName","Pacific.Ocean");
		requestparam.put("Password","Pacific");
		requestparam.put("Email", "PacificOcean@yahoo.com");

		httprequest.header("Content-Type", "application/json");

		httprequest.body(requestparam.toJSONString()); //Attach above data to the response

//	Response Object
		Response response = httprequest.request(Method.POST, "/register");

//		Print Response in console window

		String responsebody = response.getBody().asString();
		System.out.println("Reponse Body : " + responsebody);

//		Status code validation
		int statuscode = response.getStatusCode();
		System.out.println("Status code : " + statuscode);
		Assert.assertEquals(statuscode, 201);

//		Success Code Validation
		String success_code = response.jsonPath().get("SuccessCode");
		Assert.assertEquals(success_code, "OPERATION_SUCCESS");
	}
}