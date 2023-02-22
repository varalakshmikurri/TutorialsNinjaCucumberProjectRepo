package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class HomePage {

	WebDriver driver;
	private ElementUtils elementUtils;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver; //we are assigning Webdriver driver to this driver
		PageFactory.initElements(driver, this);
		elementUtils=new ElementUtils(driver);
	}
	
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccountDropmenu;
	
	@FindBy(xpath="//a[text()='Login']")
	private WebElement loginOption;
	
	@FindBy(xpath="//a[text()='Register']")
	private WebElement registerOption;
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement searchTextbox;
	
	@FindBy(xpath="//button[contains(@class,'btn-default')]")
	private WebElement searchButton;
	
	public void clickOnSearchButton()
	{
		//searchButton.click();
		elementUtils.clickOnElement(searchButton,CommonUtils.EXPLICIT_WAIT_TIME);
	}
	
	public void enterSearchBoxVal(String strProdText) 
	{
		// searchTextbox.sendKeys(strProdText);
		elementUtils.typeTextIntoElement(searchTextbox, strProdText, CommonUtils.EXPLICIT_WAIT_TIME);
	}
	
	
	public void clickOnRegisterOption()
	{
		elementUtils.clickOnElement(registerOption,CommonUtils.EXPLICIT_WAIT_TIME);
		//registerOption.click();
	}
	 
	public void clickOnMyAccount()
	{
		elementUtils.clickOnElement(myAccountDropmenu,CommonUtils.EXPLICIT_WAIT_TIME);
		//myAccountDropmenu.click();
	}
	
	public void clickonLoginOption() 
	{
		//loginOption.click();
		elementUtils.clickOnElement(loginOption,CommonUtils.EXPLICIT_WAIT_TIME);

	}
	
}
