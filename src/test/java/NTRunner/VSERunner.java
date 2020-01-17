package NTRunner;

import org.junit.runner.RunWith;
//import org.junit.runner.RunWith;
import org.testng.annotations.Test;

import base.NTBase;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
//mport cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;


//@RunWith(Cucumber.class)
@CucumberOptions(features ="Resources/Feature info",
glue="NTDefinition")

@Test
@Severity(SeverityLevel.BLOCKER)
@Story("Story Name : To check placement of trade")
public class VSERunner extends AbstractTestNGCucumberTests {
	//NTBase ntbase=new NTBase();
}
