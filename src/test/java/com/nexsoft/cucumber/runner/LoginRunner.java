package com.nexsoft.cucumber.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "", features = "src/test/resources/Login.feature", 
glue = "com.nexsoft.cucumber.definition")
public class LoginRunner extends AbstractTestNGCucumberTests {

}
