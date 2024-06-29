package utilities;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import io.github.bonigarcia.wdm.WebDriverManager;


public class BrowserSetup {
	
	public static String browser=System.getProperty("browser", "Chrome"); 
	public static WebDriver driver;
	public static final ThreadLocal<WebDriver> LOCAL_BROWSER = new ThreadLocal<>();
	
	public static WebDriver getBrowser() {
		return LOCAL_BROWSER.get();
	}
	
   public static void setBrowser(WebDriver browserName) {
	   
	   BrowserSetup.LOCAL_BROWSER.set(browserName);
		
	}
	
	
	public static WebDriver openBrowser(String browser) throws Exception {
		
		
        if(browser.equalsIgnoreCase("Chrome")) {
			
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
			 
			 
		}
		
		else if(browser.equalsIgnoreCase("Firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			 
		}
		
        else if(browser.equalsIgnoreCase("Edge")) {
			
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			 
		}
        else {
        	
        	throw new Exception("Browser is not available");
        }
    
    driver.get("https://www.bdshop.com/");
    
    return driver;
    

    
    
}
	
	@BeforeMethod
	public static void startBrowser() {
		WebDriver browserdriver = null;
		try {
			browserdriver = openBrowser(browser);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  driver.manage().window().maximize();
		  setBrowser(browserdriver);
	}
	
	
	
	@AfterMethod
	
	public static void browserClose() {
		
		getBrowser().quit();	
		
	}

}
