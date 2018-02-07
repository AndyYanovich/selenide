package com.equerest;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions (features = "src/test/java/com/equerest/features", format = {"pretty", "html:taget/site/cucumber-pretty"})

public class RunFeatures extends AbstractTestNGCucumberTests{

}
