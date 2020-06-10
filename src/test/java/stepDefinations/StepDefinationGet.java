package stepDefinations;

import java.io.IOException;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyExtractionOptions;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.Data;
import pojo.PostApi;
import pojo.PostBody;
import pojo.todos;
import resources.TestDataBuild;
import resources.Utils;

public class StepDefinationGet extends Utils{
	PostBody p;
	PostApi ps;
	TestDataBuild data=new TestDataBuild();
	RequestSpecification res;
	ResponseSpecification resps;
	PostApi response;
	
	@Given("Add get API")
	public void add_get_API() {
		
		RestAssured.baseURI= "https://jsonplaceholder.typicode.com";
		
	   
	}

	@When("User calls Get API")
	public void user_calls_Get_API() {
		
		
	Data gt= RestAssured.given().expect().defaultParser(Parser.JSON).when().get("todos").as(Data.class);
	System.out.println("OUTPUT------");
	System.out.println(gt.getTitle());
	//System.out.println(gt.getData().size());
	
	
	
	 
	}

	@Then("The API call got success with status code {int}")
	public void the_API_call_got_success_with_status_code(Integer int1) {
		
		
	   
	}
	
	
	@Given("Add POST API")
	public void add_POST_API() throws IOException {
//		RestAssured.baseURI="http://dummy.restapiexample.com";
//	  RequestSpecification req=new RequestSpecBuilder().setBaseUri("http://dummy.restapiexample.com")
//			  .setContentType(ContentType.JSON).build();
//	  resps= new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
//	  
//	  res=RestAssured.given().spec(req).body(data.addDataPayload());
	  
	  // getting request specification  and body from resource package
	  res=RestAssured.given().spec(requestSpesification()).body(data.addDataPayload());
	  
	}

	@When("User calls POST API")
	public void user_calls_POST_API() {
		
		resps= new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		response =res.when().post("api/v1/create").as(PostApi.class);
	    
	}

	@Then("The API call got success with status code")
	public void the_API_call_got_success_with_status_code() {
		
		System.out.println(response.getStatus());
		System.out.println("My Age is "+response.getData().getAge());
		int id= response.getData().getId();
		System.out.println("ID is =="+id);
	  
	}

	
	@Given("Add POST API with unique name {string} {string} {string}")
	public void add_POST_API_with_unique_name(String name, String salary, String age) throws IOException {
	  
		 res=RestAssured.given().spec(requestSpesification()).body(data.addDataDriven(name, salary, age));
	}


}
