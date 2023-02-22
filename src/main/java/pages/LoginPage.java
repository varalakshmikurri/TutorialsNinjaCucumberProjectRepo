package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class LoginPage {

	WebDriver driver;
	private ElementUtils elementUtils;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementUtils=new ElementUtils(driver);
	}
	
	@FindBy(id="input-email")
	private WebElement inputEmail;
	
	@FindBy(id="input-password")
	private WebElement inputPassword;
	
	@FindBy(xpath="//input[@type='submit' and @value='Login']")
	private WebElement loginButton;
	
	@FindBy(xpath="//div[contains(text(), 'Warning: No match for E-Mail Address and/or Password.')]")
	private WebElement inputPwdErrorMsg;
	
	
	public void enterEmailAddress(String eMailText)
	{
		//inputEmail.sendKeys(eMailText);
		elementUtils.typeTextIntoElement(inputEmail, eMailText, CommonUtils.EXPLICIT_WAIT_TIME);
	}
	
	public void enterPasswordField(String strPwd)
	{
		//inputPassword.sendKeys(strPwd);
		elementUtils.typeTextIntoElement(inputPassword, strPwd, CommonUtils.EXPLICIT_WAIT_TIME);
	}
	
	public void clickOnLoginButton() throws InterruptedException
	{
		//loginButton.click();
		elementUtils.clickOnElement(loginButton, CommonUtils.EXPLICIT_WAIT_TIME);
	}
	
	public boolean verifyInputPwdErrorMessage()
	{
		return elementUtils.displayElement(inputPwdErrorMsg,CommonUtils.EXPLICIT_WAIT_TIME);
		//return inputPwdErrorMsg.isDisplayed();
	}
	
}
