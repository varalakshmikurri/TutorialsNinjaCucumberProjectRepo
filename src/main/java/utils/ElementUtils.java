package utils;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {
	
	private WebDriver driver;
	public ElementUtils(WebDriver driver)
	{
		this.driver=driver;
		
	}
	
	public void clickOnElement(WebElement element, long durationInSeconds)
	{
		WebElement webelement=waitForElement(element,durationInSeconds);
		webelement.click();
	}

	public void typeTextIntoElement(WebElement element,String text, long durationInSeconds)
	{
		WebElement webElement=waitForElement(element,durationInSeconds);
		webElement.click();
		webElement.clear();
		webElement.sendKeys(text);
	}
	
	public boolean displayElement(WebElement element, long durationInSeconds)
	{
		WebElement webElement=waitForElement(element,durationInSeconds);
		return webElement.isDisplayed();
	}
	
	public String getTextElement(WebElement element, long durationInSeconds)
	{
		WebElement webElement=waitForElement(element,durationInSeconds);
		return webElement.getText();
	}
	
	public WebElement waitForElement(WebElement element, long durationInSeconds)
	{
		WebElement webElement = null;
		try{
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(durationInSeconds));
		webElement=wait.until(ExpectedConditions.elementToBeClickable(element));
		}
		catch(Throwable e)
		{
			e.printStackTrace();
		}
	
		return webElement;
	}
	
	public void selectOptionInDropdown(WebElement element, String dropdownoption, long durationInSeconds)
	{
		WebElement webElement=waitForElement(element,durationInSeconds);
		
		Select selDrop=new Select(webElement);
		selDrop.selectByVisibleText(dropdownoption);
	
	}
	
	public void acceptAlert(long durationInSeconds)
	{
		try
		{
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(durationInSeconds));
			Alert alert=wait.until(ExpectedConditions.alertIsPresent());
			alert.accept();
		}
		catch(Throwable e)
		{
			e.printStackTrace();
		}
	}
	
	public void dismissAlert(long durationInSeconds)
	{
		try
		{
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(durationInSeconds));
			Alert alert=wait.until(ExpectedConditions.alertIsPresent());
			alert.dismiss();;
		}
		catch(Throwable e)
		{
			e.printStackTrace();
		}
	}
	
	public void mouseOverAndClick(WebElement element, long durationInSeconds)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(durationInSeconds));
		WebElement webElement=wait.until(ExpectedConditions.visibilityOf(element));
		Actions act=new Actions(driver);
		act.moveToElement(webElement).click().build().perform();
		
	}
	
	public void javaScriptClick(WebElement element, long durationInSeconds)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(durationInSeconds));
		WebElement webElement=wait.until(ExpectedConditions.visibilityOf(element));
		
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();",webElement);
				
	}
	
	public void javaScriptType(WebElement element,String textToEnter,long durationInSeconds)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(durationInSeconds));
		WebElement webElement=wait.until(ExpectedConditions.visibilityOf(element));
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].value='"+textToEnter+"'",webElement);
	
	}
	
}
