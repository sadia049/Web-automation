package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utilities.BrowserSetup;

public class BasePage extends BrowserSetup {
	
	public   WebElement getElement(By locator) {
		 return getBrowser().findElement(locator);
	}
	public  void writeElement(By locator, String text) {
		
		getElement(locator).clear();
		getElement(locator).sendKeys(text);		
		
	}
 public  Boolean displayElement(By locator) {
		
		return getElement(locator).isDisplayed();
			
		
	}
 
 public  void clickOnElement(By locator) {
		
		getElement(locator).click();
			
		
	}
 
 public Boolean checkElement(By locator) {
	 return getElement(locator).isSelected();
 }

 
 public String getText(By locator) {
	 
	 return getElement(locator).getText();
 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
