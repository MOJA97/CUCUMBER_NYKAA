package StepDefinitions;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
@RunWith(Cucumber.class)
@CucumberOptions(features="src\\test\\resources\\Features",
				 glue = {"StepDefinitions"},
				 monochrome = true,
				 plugin = {"pretty","html:target/Html_Reports/htmlreports.html", 
						   "json:target/JSONReports/Jsonreports.json",
						   "junit:target/JunitReports/report1.xml"},
					tags ="@sanitytest" 
		)
public class Test_Runner {

}
