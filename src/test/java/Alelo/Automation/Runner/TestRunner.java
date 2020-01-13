package Alelo.Automation.Runner;

import org.junit.runner.RunWith;

import Alelo.Automation.Utils.Driver;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)

@CucumberOptions(
features = "src/Test/Features/",
strict = false, // Se tiver steps não mapeados a execução não deve falhar
	monochrome = true, // Visualização do resultado no console
	//plugin = { "pretty", "html:target/report" },
	plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"}, 

glue= {"Alelo.Automation.Steps"})
public class TestRunner {


}
