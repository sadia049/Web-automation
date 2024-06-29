package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import static utilities.BrowserSetup.startBrowser;

public class Loginpage extends BasePage{
	
	public String email = "sadianawsin018@gmail.com";
	public String password = "12345samara";
	
	public By emailinput = By.xpath("//input[@id='email-login']");
	public By passwordinput = By.xpath("//input[@id='pass-popup']");
	public By loginbutton = By.xpath("//button[@id='btn-social-login-authentication']");
	public By errormsg = By.xpath("//div[@id='email-login-error']");
	
	
	
	

}
