package testcases;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.Loginpage;
import utilities.BrowserSetup;

import utilities.BrowserSetup;
@Test

 class Signin extends BrowserSetup{
	
	HomePage homepage = new HomePage();
	Loginpage loginpage = new Loginpage();
	 public  void doLogin() {
			
//			getBrowser().get(homepage.homepageurl);
		    startBrowser();
			homepage.clickOnElement(homepage.loginbutton);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			loginpage.writeElement(loginpage.emailinput, loginpage.email);
			loginpage.writeElement(loginpage.passwordinput, loginpage.password);
			//driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
			loginpage.clickOnElement(loginpage.loginbutton);
			
		}
	
}
public class TestSignin  {

	
	public static void main(String[] args) {
		
		Signin signin= new Signin();
		signin.doLogin();
		BrowserSetup bs = new BrowserSetup();
		//bs.browserClose();
		
	}

}
