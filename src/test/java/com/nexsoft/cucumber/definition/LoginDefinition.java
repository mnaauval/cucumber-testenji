package com.nexsoft.cucumber.definition;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.nexsoft.cucumber.pom.HomePage;
import com.nexsoft.cucumber.pom.SignInPage;
import com.nexsoft.cucumber.utilities.Utilities;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginDefinition {

	private WebDriver driver;
	private HomePage home;
	private SignInPage signIn;
	private Utilities util;
	private List<String> lstError;

	@Before
	public void init() {
		System.setProperty("url", "http://localhost/cicool/");
		System.setProperty("webdriver.chrome.driver", "/chromedriver.exe");
		driver = new ChromeDriver();
		home = PageFactory.initElements(driver, HomePage.class);
		signIn = PageFactory.initElements(driver, SignInPage.class);
		util = new Utilities();
		lstError = new ArrayList<String>();
		driver.manage().window().maximize();
		driver.get(System.getProperty("url"));
	}

	@Given("User at Login page")
	public void goToLogin() throws Throwable {
		home.clickSignIn();
	}

	@When("User input usernamevalid as {string}")
	public void inputValidUname(String uname) throws Throwable {
		signIn.setUname(uname);
	}

	@When("^User input username (.*)$")
	public void inputNotValidUname(String uname) throws Throwable {
		signIn.setUname(uname);
	}

	@And("User input passwordvalid as {string}")
	public void inputValidPasswd(String passwd) throws Throwable {
		signIn.setPassword(passwd);
	}

	@When("^User input password (.*)$")
	public void inputNotValidPasswd(String passwd) throws Throwable {
		signIn.setPassword(passwd);
	}

	@And("User click login button")
	public void clickBtn() throws Throwable {
		signIn.clickBtnSignIn();
	}

	@Then("User login to Dashboard page")
	public void goToDashboard() throws Throwable {
		signIn.dashboardPage();
	}

//  show error message
	@Then("Login page show error message")
	public void errorMessage() throws Throwable {
		signIn.forgetPasswordPage();
	}

	@After
	public void closeConn() {
//		util.sleep(3000);
		String file = "<img src='file://" + util.screenShoot(driver) + "'height=\"350\" width=\"792\"/>";
		Reporter.log(file);
		driver.close();
	}

}
