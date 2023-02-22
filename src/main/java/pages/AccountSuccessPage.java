package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class AccountSuccessPage {

	WebDriver driver;
	
	private ElementUtils elementUtils;
	
	public AccountSuccessPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementUtils=new ElementUtils(driver);
	}
	
	@FindBy(xpath="//div[@id='content']/h1/following-sibling::p[1]")
	private WebElement pageHeadingText;
	
	public String verifyPageHeadingText()
	{
		//return pageHeadingText.getText();
		return elementUtils.getTextElement(pageHeadingText,CommonUtils.EXPLICIT_WAIT_TIME);
	}
	
}
