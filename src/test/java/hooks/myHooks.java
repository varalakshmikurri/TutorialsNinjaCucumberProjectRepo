package hooks;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import factory.driverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class myHooks {
	WebDriver driver;
	
	@Before
	public void setUp()
	{
		driverFactory.intializeBrowser("chrome");
		driver=driverFactory.getDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		driver.get("http://www.tutorialsninja.com/demo/");
		
	}
	
	@After
	public void tearDown()
	{
		driver.quit();
	}
	


	
	
}
