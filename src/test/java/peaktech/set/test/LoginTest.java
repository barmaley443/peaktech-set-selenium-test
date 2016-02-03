package peaktech.set.test;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features",
        format = {"pretty", "html:target/cucumber-html-report", "json:target/report.json"},
        tags = {"@login"})
public class LoginTest {
}
