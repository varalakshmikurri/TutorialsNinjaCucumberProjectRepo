package factory;

import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class driverFactory {
	
	 static WebDriver driver = null;
		
	public static WebDriver intializeBrowser(String browserName) {	
		
		if(browserName.equals("chrome"))
		{
			 driver=new ChromeDriver();
		}
		else if(browserName.equals("safari"))
		{
			 driver=new SafariDriver();
		}
		else if(browserName.equals("firefox"))
		{
			 driver=new FirefoxDriver();
		}
		
		return driver;
	}
	
	public static WebDriver getDriver()
	{
		return driver;
	}
	
	public static String getEmailTimeStamp()
	{
		Date date=new Date();
		String strDate=date.toString().replaceAll(" ", "_").replace(":", "_");
		
		String eMailTxt="vara"+strDate+"@gmail.com";
		
		return eMailTxt.trim();
	}

}
