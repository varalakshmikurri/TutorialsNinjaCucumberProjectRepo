package stepdefinitions;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.driverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import pages.AccountSuccessPage;
import pages.HomePage;
import pages.RegisterPage;

public class Register {
	
	WebDriver driver;
	RegisterPage rp;
 	
	@Given("User navigates to the Register Account page")
	public void user_navigates_to_the_register_account_page() {
	 
		driver=driverFactory.getDriver();
		HomePage homePage=new HomePage(driver);
		homePage.clickOnMyAccount();
		homePage.clickOnRegisterOption();
	}

	@When("User enters the details into the below fields")
	public void user_enters_the_details_into_the_below_fields(DataTable dataTable) {
	  
		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
		
		RegisterPage rp=new RegisterPage(driver);
		rp.enterFirstName(dataMap.get("Firstname"));
		rp.enterLastName(dataMap.get("lastname"));
		System.out.println("email time stamp"+driverFactory.getEmailTimeStamp());
		rp.enterEmail(driverFactory.getEmailTimeStamp());
		rp.enterTelephone(dataMap.get("telephone"));
		rp.enterPassword(dataMap.get("password"));
		rp.enterConfirmPassword(dataMap.get("password"));
		
		//driver.findElement(By.id("input-firstname")).sendKeys(dataMap.get("Firstname"));
		//driver.findElement(By.id("input-lastname")).sendKeys(dataMap.get("lastname"));
		//driver.findElement(By.id("input-email")).sendKeys(driverFactory.getEmailTimeStamp());
		//driver.findElement(By.id("input-telephone")).sendKeys(dataMap.get("telephone"));
//		driver.findElement(By.id("input-password")).sendKeys(dataMap.get("password"));
//		driver.findElement(By.id("input-confirm")).sendKeys(dataMap.get("password"));
//			
	}
	
	
	@When("User enters the duplicate details into the below fields")
	public void user_enters_the_duplicate_details_into_the_below_fields(DataTable dataTable) {
	  
		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
		
		RegisterPage rp=new RegisterPage(driver);
		rp.enterFirstName(dataMap.get("Firstname"));
		rp.enterLastName(dataMap.get("lastname"));
		rp.enterEmail(dataMap.get("eMail"));
		rp.enterTelephone(dataMap.get("telephone"));
		rp.enterPassword(dataMap.get("password"));
		rp.enterConfirmPassword(dataMap.get("password"));			
	}

	@When("User selects Private Policy")
	public void user_selects_private_policy() {
	  
		RegisterPage rp=new RegisterPage(driver);
		rp.enterPrivacyPolicy();
		
	}

	@When("User clicks on Continue button")
	public void user_clicks_on_continue_button() throws InterruptedException {
	  
		RegisterPage rp=new RegisterPage(driver);
		rp.clickOnContinueButton();
		
	}

	@Then("User account should get created successfully")
	public void user_account_should_get_created_successfully() {
	
		AccountSuccessPage accsuccpage=new AccountSuccessPage(driver);
		String strText=accsuccpage.verifyPageHeadingText();
		System.out.println("resgister success messge"+strText);
		//driver.findElement(By.xpath("//div[@id='content']/h1/following-sibling::p[1]")).getText();
		//System.out.println("user account creation msg"+strText);
		Assert.assertEquals("Congratulations! Your new account has been successfully created!", strText);
	}

	@When("User selects Yes for Newsletter")
	public void user_selects_yes_for_newsletter() {
	    
		RegisterPage rp=new RegisterPage(driver);
		rp.enterNewsLetterOption();
		//driver.findElement(By.xpath("//input[@name='newsletter' and @value=1]")).click();
	}

	@Then("User account should not get created")
	public void user_account_should_not_get_created() {
		
		RegisterPage rp=new RegisterPage(driver);
		Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).isDisplayed());
		//String strText=driver.findElement(By.xpath("//div[@id='account-register']/child::div/child::i")).getText();
		//System.out.println("duplicte error email msg"+strText);
		//Assert.assertEquals("Warning: E-Mail Address is already registered!", strText);
		
		
	}

	@Then("User should get proper error message about duplicate account")
	public void user_should_get_proper_error_message_about_duplicate_account() {
		
		RegisterPage rp=new RegisterPage(driver);
		String strWariningText=rp.verifyDuplicateEmailErrorMessage();
		Assert.assertEquals("Warning: E-Mail Address is already registered!",strWariningText);
		//String strText=driver.findElement(By.xpath("//div[@id='account-register']/child::div/child::i")).getText();
		//System.out.println("duplicate error email message"+strText);
		//Assert.assertEquals("Warning: E-Mail Address is already registered!", strText);
	}

	@When("User does not enter any data into fields")
	public void user_does_not_enter_any_data_into_fields() {
	  
		RegisterPage rp=new RegisterPage(driver);
		
	}

	@Then("User should get proper error message for each mandatory field")
	public void user_should_get_proper_error_message_for_each_mandatory_field() {
	  
		RegisterPage rp=new RegisterPage(driver);
		Assert.assertTrue(rp.verifyPrivacyWarningErrorMessage());
		Assert.assertEquals("First Name must be between 1 and 32 characters!",rp.verifyfirstNameWarningMsg());
		Assert.assertEquals("Last Name must be between 1 and 32 characters!",rp.verifyLastNameWarningMsg());
		Assert.assertEquals("E-Mail Address does not appear to be valid!",rp.verifyeMailWarningMsg());
		Assert.assertEquals("Telephone must be between 3 and 32 characters!", rp.verifytelePhoneWarningMsg());
		Assert.assertEquals("Password must be between 4 and 20 characters!", rp.verifyPasswordWarningMsg());
	}
	


}
