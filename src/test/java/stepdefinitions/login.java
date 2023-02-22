package stepdefinitions;

import java.time.Duration;

//comment added by varalakshmi

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import factory.driverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;

//Comments added by sai jyothi
//added comments... for the first time in login page...
public class login {
	
	WebDriver driver;
	private LoginPage loginPage;
	
	@Given("User navigates to Login page")
	public void User_navigates_to_Login_page()
	{	
		driver=driverFactory.getDriver();
		HomePage homePage=new HomePage(driver);
		homePage.clickOnMyAccount();
		homePage.clickonLoginOption();		
	}
	
	@When("^User enters valid email address (.+) into email field$")
	public void User_enters_valid_email_address_into_email_field(String eMailText)
	{
		loginPage=new LoginPage(driver);
		loginPage.enterEmailAddress(eMailText);
		
	}
	
	@And("^User enters valid password (.+) into password field$")
	public void user_enters_valid_password_into_password_field(String strPwd) {
	
		loginPage=new LoginPage(driver);
		loginPage.enterPasswordField(strPwd);

	}
	
	

	@When("User clicks on Login button")
	public void user_clicks_on_login_button() throws InterruptedException {
	
		loginPage=new LoginPage(driver);
		loginPage.clickOnLoginButton();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		
	}

	@Then("User should logeed in successfully")
	public void user_should_logeed_in_successfully() {
		
		AccountPage accountpage=new AccountPage(driver);
		
		boolean myAccText=accountpage.verifyMyAccountOption();
		Assert.assertTrue(myAccText);
	}
	
	
	@When("User enters invalid email address into email field")
	public void user_enters_invalid_email_address_into_email_field() {
	   
		loginPage=new LoginPage(driver);
		loginPage.enterEmailAddress(driverFactory.getEmailTimeStamp());
	}

	@When("User enters invalid password {string} into password field")
	public void user_enters_invalid_password_into_password_field(String strInvalidPwd) {
	  		
		loginPage.enterPasswordField(strInvalidPwd);
		
	}

	@Then("User should not logged in successfully")
	public void user_should_not_logged_in_successfully() {
	     
		Boolean errMsgText=loginPage.verifyInputPwdErrorMessage();
		Assert.assertTrue(errMsgText);
	}

	@Then("User should get proper login error message as {string}")
	public void user_should_get_proper_login_error_message_as(String string) {
	   
		Boolean errMsgText=loginPage.verifyInputPwdErrorMessage();
		Assert.assertTrue(errMsgText);

	}
}
