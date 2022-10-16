package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public static Properties prop;
	public static WebDriver driver;
	@BeforeTest
	public void loadConfig() {
//		ExtentManager.setExtent();
//		DOMConfigurator.configure("log4j.xml");
		
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("C:\\Program Files\\ecomp\\configuration\\config.properties"));
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

public void launchApp() {
		
		// String browserName = prop.getProperty("browser");
		//if (browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			String browserName = prop.getProperty("browser");

			// Set Browser to ThreadLocalMap
			//driver.set(new ChromeDriver());
		if (browserName.contains("Chrome")) {
			//WebDriverManager.firefoxdriver().setup();
			driver=new ChromeDriver();
		} else if (browserName.contains("Firefox")) {
			driver=new FirefoxDriver();
			//driver.set(new InternetExplorerDriver());
		}
//		//Maximize the screen
//		getDriver().manage().window().maximize();
//		//Delete all the cookies
//		getDriver().manage().deleteAllCookies();
//		//Implicit TimeOuts
//		getDriver().manage().timeouts().implicitlyWait
//		(Integer.parseInt(prop.getProperty("implicitWait")),TimeUnit.SECONDS);
//		//PageLoad TimeOuts
//		getDriver().manage().timeouts().pageLoadTimeout
//		(Integer.parseInt(prop.getProperty("pageLoadTimeOut")),TimeUnit.SECONDS);
//		//Launching the URL
//		getDriver().get(prop.getProperty("url"));
	
		
	
}

}
