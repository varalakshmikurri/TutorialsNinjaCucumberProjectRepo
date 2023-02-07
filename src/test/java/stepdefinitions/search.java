package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.driverFactory;
import io.cucumber.java.en.*;

public class search {

	WebDriver driver;
	@Given("User lands on the home page")
	public void user_lands_on_the_home_page() {
	   
		driver=driverFactory.getDriver();
		
	}

	@When("User enter valid product name {string} in search box field")
	public void user_enter_valid_product_name_in_search_box_field(String strText) {
	   
		driver.findElement(By.xpath("//input[@name='search']")).sendKeys(strText);
		
	}

	@When("User clicks on Search button")
	public void user_clicks_on_search_button() {
	   
		driver.findElement(By.xpath("//button[contains(@class,'btn-default')]")).click();		
	}

	@Then("User should get valid product displayed on the search results page")
	public void user_should_get_valid_product_displayed_on_the_search_results_page() {
	  
		Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed());
	}

	@When("User enter invalid product name {string} in search box field")
	public void user_enter_invalid_product_name_in_search_box_field(String strInvalidprodNAme) {
	   
		driver.findElement(By.xpath("//input[@name='search']")).sendKeys(strInvalidprodNAme);
	}

	@Then("User should get a error message about invalid product")
	public void user_should_get_a_error_message_about_invalid_product() {
	  
		Assert.assertEquals("There is no product that matches the search criteria.", driver.findElement(By.xpath("//input[@id='button-search']/following-sibling::p")).getText());
		
	}

	@When("User does not enter any product name in search box field")
	public void user_does_not_enter_any_product_name_in_search_box_field() {
	   
		//do not enter anything
		
	}

	@Then("User should get a error message about no product matching")
	public void user_should_get_a_error_message_about_no_product_matching() 	
	{	   
		Assert.assertEquals("There is no product that matches the search criteria.", driver.findElement(By.xpath("//input[@id='button-search']/following-sibling::p")).getText());
			
	}
	
	
	
}
