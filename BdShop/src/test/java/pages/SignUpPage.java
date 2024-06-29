package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.BrowserSetup;
public class SignUpPage extends BasePage {
	

	
	
	public By firstnameInput = By.xpath("//input[@id='firstname']");
	public By lastNameInput = By.xpath("//input[@id='lastname']");
	public By firsttNameLabel = By.xpath("//label[@for='firstname']/span");
	public By lastNameLabel = By.xpath("//label[@for='lastname']/span");
	public By signUpneswsChecked = By.xpath("//input[@type='checkbox' and @name='is_subscribed']");
	public By emailInput = By.xpath("//input[@id='email_address']");
	public By passwordInput = By.xpath("//input[@id='password']");
	public By passwordStrength = By.xpath("//div[ @id='password-strength-meter']");
	public By confirmpasswordInput = By.xpath("//input[@id='password-confirmation']");
	public By rememberMe = By.xpath("//input[ @name='persistent_remember_me']");
	public By captcha = By.xpath("//input[@name='captcha[user_create]']");
	public By phoneNumber = By.xpath("//input[ @name='mobilenumber']");
	public By registerButton = By.xpath("//button[ @title='Create an Account']");

}
