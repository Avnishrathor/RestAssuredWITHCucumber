package cucumber.Options;

import org.junit.runner.RunWith;


@RunWith(cucumber.api.junit.Cucumber.class)
@cucumber.api.CucumberOptions(
		
		features="src/test/java/features/DataDriven.feature",
		glue= {"stepDefinations"}
		)
	
	public class TestRunner {
		
}
