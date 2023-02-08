package stepdefinitions;

import java.time.Duration;

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

//Comments added by sai jyothi
//added comments... for the first time in login page...
public class login {
	
	WebDriver driver;
	
	@Given("User navigates to Login page")
	public void User_navigates_to_Login_page()
	{	
		driver=driverFactory.getDriver();
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		
	}
	
	@When("User enters valid email address {string} into email field")
	public void User_enters_valid_email_address_into_email_field(String eMailText)
	{
		driver.findElement(By.id("input-email")).sendKeys(eMailText);
		
	}
	
	@And("User enters valid password {string} into password field")
	public void user_enters_valid_password_into_password_field(String strPwd) {
	
	    driver.findElement(By.id("input-password")).sendKeys(strPwd);
	}
	
	

	@When("User clicks on Login button")
	public void user_clicks_on_login_button() {
	
		driver.findElement(By.xpath("//input[@type='submit' and @value='Login']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		
	}

	@Then("User should logeed in successfully")
	public void user_should_logeed_in_successfully() {
	   
		boolean myAccText=driver.findElement(By.xpath("//h2[contains(text(), 'My Account')]")).isDisplayed();
		Assert.assertTrue(myAccText);
	}
	
	
	@When("User enters invalid email address into email field")
	public void user_enters_invalid_email_address_into_email_field() {
	   
		driver.findElement(By.id("input-email")).sendKeys(driverFactory.getEmailTimeStamp());
	}

	@When("User enters invalid password {string} into password field")
	public void user_enters_invalid_password_into_password_field(String strInvalidPwd) {
	  
		driver.findElement(By.id("input-password")).sendKeys(strInvalidPwd);
		
	}

	@Then("User should not logged in successfully")
	public void user_should_not_logged_in_successfully() {
	     
		Boolean errMsgText=driver.findElement(By.xpath("//div[contains(text(), 'Warning: No match for E-Mail Address and/or Password.')]")).isDisplayed();
		Assert.assertTrue(errMsgText);
	}

	@Then("User should get proper login error message as {string}")
	public void user_should_get_proper_login_error_message_as(String string) {
	   
		Boolean errMsgText=driver.findElement(By.xpath("//div[contains(text(), 'Warning: No match for E-Mail Address and/or Password.')]")).isDisplayed();
		Assert.assertTrue(errMsgText);

	}
}
