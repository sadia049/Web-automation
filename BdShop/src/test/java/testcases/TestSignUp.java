package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import pages.HomePage;

import pages.SignUpPage;
import utilities.BrowserSetup;

class SignUp extends BrowserSetup{
	
	
	HomePage homepage = new HomePage();
	SignUpPage signup = new SignUpPage();
	
	public void doSignup() throws InterruptedException {
		
		startBrowser();
		JavascriptExecutor  js = (JavascriptExecutor)driver; 
		homepage.clickOnElement(homepage.resgisterButton);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		signup.writeElement(signup.firstnameInput, "Sadia");
		signup.writeElement(signup.lastNameInput, "Nawsin");
		
		signup.writeElement(signup.emailInput, "sadianawsin018@gmail.com");
		signup.writeElement(signup.passwordInput, "1982@Gonzo");
		signup.writeElement(signup.confirmpasswordInput, "1982@Gonzo");
        Thread.sleep(5000);
		
        
//      WebElement element = homepage.getElement(signup.rememberMe);
//	   js.executeScript("arguments[0].scrollIntoView()", element);
//		
//	   element.click();
//	   Thread.sleep(5000);
        signup.writeElement(signup.captcha, "ABCDE");;
		
	   WebElement element = homepage.getElement(signup.registerButton);
	   js.executeScript("arguments[0].scrollIntoView()", element);
		
	   element.click();
	   Thread.sleep(5000);
		
//		js.executeScript("arguments[0].scrollIntoView()", signup.registerButton);
//		
//		
//		
//		signup.clickOnElement(signup.registerButton);
		
		
	}
}
public class TestSignUp {

	public static void main(String[] args) {
		
		SignUp signup = new SignUp();
		try {
			signup.doSignup();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
