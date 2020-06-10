package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Utils {
  //single instance with static keyword
	public static RequestSpecification req;

	public RequestSpecification requestSpesification() throws IOException {
		if(req==null)
		{
		PrintStream log= new PrintStream(new FileOutputStream("Logging.txt"));
		req=(RequestSpecification) new RequestSpecBuilder().setBaseUri(getGlobalVal("baseUrl")).
				addFilter(RequestLoggingFilter.logRequestTo(log)).
				addFilter(ResponseLoggingFilter.logResponseTo(log)).setContentType(ContentType.JSON).build();
		return req;
	}
		return req;
	}
	
	public static String getGlobalVal(String key) throws IOException
	{
		Properties pr=new Properties();
		FileInputStream fi=new FileInputStream("F:\\Avnish\\eclipse-workspace\\APIFramwork\\src\\test\\java\\resources\\global.properties");
		pr.load(fi);
		return pr.getProperty(key);
		//return pr;
	}

}
