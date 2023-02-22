package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class RegisterPage {
	
	WebDriver driver;
	
	private ElementUtils elementUtils;
	
	public RegisterPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementUtils=new ElementUtils(driver);
	}

	@FindBy(id="input-firstname")
	private WebElement firstNameField;
	
	@FindBy(id="input-lastname")
	private WebElement lastNameField;
	
	@FindBy(id="input-email")
	private WebElement emailField;
	
	@FindBy(id="input-telephone")
	private WebElement telePhoneField;
	
	@FindBy(id="input-password")
	private WebElement passWordField;
	
	@FindBy(id="input-confirm")
	private WebElement confirmPasswordField;
	
	@FindBy(name="agree")
	private WebElement privacyPolicyField;
	
	@FindBy(xpath="//input[contains(@class, 'btn-primary')]")
	private WebElement continueButton;
	
	@FindBy(xpath="//input[@name='newsletter' and @value=1]")
	private WebElement newsLetterOption;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement dupEmailErrorMessage;
	
	@FindBy(xpath="//div[contains(@class, 'alert-dismissible')]")
	private WebElement privacyWarningErrorMessage;
	
	@FindBy(xpath="//input[@id='input-firstname']/following-sibling::div")
	private WebElement firstNameWarningMsg;
	
	@FindBy(xpath="//input[@id='input-lastname']/following-sibling::div")
	private WebElement lastNameWarningMsg;
	
	@FindBy(xpath="//input[@id='input-email']/following-sibling::div")
	private WebElement eMailWarningMsg;
	
	@FindBy(xpath="//input[@id='input-telephone']/following-sibling::div")
	private WebElement telePhoneWarningMsg;
	
	@FindBy(xpath="//input[@id='input-password']/following-sibling::div")
	private WebElement passwordWarningMsg;
	
	public String verifyfirstNameWarningMsg()
	{
		//return firstNameWarningMsg.getText();
		return elementUtils.getTextElement(firstNameWarningMsg,CommonUtils.EXPLICIT_WAIT_TIME);
		
	}
	
	public String verifyLastNameWarningMsg()
	{
		//return lastNameWarningMsg.getText();
		return elementUtils.getTextElement(lastNameWarningMsg,CommonUtils.EXPLICIT_WAIT_TIME);
	}
	
	public String verifyeMailWarningMsg()
	{
		//return eMailWarningMsg.getText();
		return elementUtils.getTextElement(eMailWarningMsg,CommonUtils.EXPLICIT_WAIT_TIME);
	}
	
	public String verifytelePhoneWarningMsg()
	{
		//return telePhoneWarningMsg.getText();
		return elementUtils.getTextElement(telePhoneWarningMsg,CommonUtils.EXPLICIT_WAIT_TIME);
	}
	
	public String verifyPasswordWarningMsg()
	{
		//return passwordWarningMsg.getText();
		return elementUtils.getTextElement(passwordWarningMsg,CommonUtils.EXPLICIT_WAIT_TIME);
	}
	
	public Boolean verifyPrivacyWarningErrorMessage()
	{
		//return privacyWarningErrorMessage.isDisplayed();
		return elementUtils.displayElement(privacyWarningErrorMessage,CommonUtils.EXPLICIT_WAIT_TIME);
	}
	
	
	public String verifyDuplicateEmailErrorMessage()
	{
		//return dupEmailErrorMessage.getText();
		return elementUtils.getTextElement(dupEmailErrorMessage,CommonUtils.EXPLICIT_WAIT_TIME);
	}
	
	public void enterNewsLetterOption()
	{
		//newsLetterOption.click();
		elementUtils.clickOnElement(newsLetterOption,CommonUtils.EXPLICIT_WAIT_TIME);
	}
	
	public void enterPrivacyPolicy()
	{
		//privacyPolicyField.click();
		elementUtils.clickOnElement(privacyPolicyField,CommonUtils.EXPLICIT_WAIT_TIME);
	}
	
	public void clickOnContinueButton()
	{
		//continueButton.click();
		elementUtils.clickOnElement(continueButton,CommonUtils.EXPLICIT_WAIT_TIME);
	}
		
	public void enterPassword(String passwordText)
	{
		//passWordField.sendKeys(passwordText);
		elementUtils.typeTextIntoElement(passWordField, passwordText,CommonUtils.EXPLICIT_WAIT_TIME);
	}
	
	public void enterConfirmPassword(String confirmPasswordText)
	{
		//confirmPasswordField.sendKeys(confirmPasswordText);
		elementUtils.typeTextIntoElement(confirmPasswordField, confirmPasswordText,CommonUtils.EXPLICIT_WAIT_TIME);
	}
	
	public void enterTelephone(String telePhoneText)
	{
		//telePhoneField.sendKeys(telePhoneText);
		elementUtils.typeTextIntoElement(telePhoneField, telePhoneText,CommonUtils.EXPLICIT_WAIT_TIME);
	}
	
	public void enterEmail(String eMailText)
	{
		//emailField.sendKeys(eMailText);
		elementUtils.typeTextIntoElement(emailField, eMailText,CommonUtils.EXPLICIT_WAIT_TIME);
	}
	
	public void enterFirstName(String firstNameText)
	{
		elementUtils.typeTextIntoElement(firstNameField, firstNameText,CommonUtils.EXPLICIT_WAIT_TIME);
		//firstNameField.sendKeys(firstNameText);
	}
	
	public void enterLastName(String lastNameText)
	{
		//lastNameField.sendKeys(lastNameText);
		elementUtils.typeTextIntoElement(lastNameField, lastNameText,CommonUtils.EXPLICIT_WAIT_TIME);
	}
}
