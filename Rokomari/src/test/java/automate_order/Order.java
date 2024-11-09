package automate_order;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Order {
	public static WebDriver driver;
	public static void browserSetup() throws Exception {
		
		WebDriverManager.firefoxdriver().setup();
		
		driver = new FirefoxDriver();
		
		driver.get("https://www.rokomari.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	public static void testScript() throws InterruptedException {
		
		
		WebElement popup = driver.findElement(By.className("close-btn-outside"));
        popup.click();
	    //Task 1   ****************signup using google********************///////////
        
		WebElement signin = driver.findElement(By.xpath("//a[@class=\"logged-out-user-menu-btn\"]"));
		signin.click();
		
		WebElement signin_google = driver.findElement(By.className("btn-social-google"));
		signin_google.click();
		Thread.sleep(3000);
		WebElement google_email = driver.findElement(By.id("identifierId"));
		google_email.sendKeys("sadianawsin018@gmail.com");
		WebElement next_button = driver.findElement(By.id("identifierNext"));
		next_button.click();
		
		
		//Task2 **********************select lekhok from menu*************///////////
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement Lekhok = driver.findElement(By.id("js--authors"));
		Actions action = new Actions(driver);
		action.moveToElement(Lekhok).perform();
		
		//Task 3 *********************select humayun ahmed************//////////////
		driver.findElement(By.linkText("হুমায়ূন আহমেদ")).click();	
		driver.get("https://www.rokomari.com/book/author/1/humayun-ahmed?ref=mm_p0");
		
		
		//Scroll to Categorys
//		WebElement categorys = driver.findElement(By.id("js--categoryIds"));
//		action.moveToElement(categorys).perform();

//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("js--categoryIds")));
//		//List<WebElement> category_ids = driver.findElements(By.name("categoryIds"));
//		WebElement category_ids = driver.findElement(By.className("custom-control-label"));
//		JavascriptExecutor jse = (JavascriptExecutor)driver;
//      jse.executeScript("arguments[0].scrollIntoView()", category_ids); 
//        
        //*********************Task5. Scroll down and go to the next page************/////////////////////////////
        
	   WebElement pagination = driver.findElement(By.className("pagination"));
	   action.moveToElement(pagination).perform();
	   List<WebElement> pages = driver.findElements(By.xpath("//div[@class='pagination']//a"));
	   WebElement currentpage = driver.findElement(By.xpath("//span[@class='current']"));
	   int  current_page = Integer.parseInt(currentpage.getText());
	   if((current_page)<pages.size()) {
		  
		   for(WebElement e : pages) {
			   if(Integer.parseInt(e.getText())== current_page+1) {
				   e.click();
			   }
			   
			   break;
	       	
	       }
		   
	   }
	   
     //***********Task 6 Add to cart any item************/////////////////////////////
	   
	 WebElement hover_over_item = driver.findElement(By.xpath("//div[@class='books-wrapper__item']"));
	 action.moveToElement(hover_over_item).click().perform();  
	 
	 driver.get("https://www.rokomari.com/book/15313/misir-ali-somogro-2");
	 WebElement cart_button = driver.findElement(By.xpath("//div[@id='js--details-btn-area']/a[2]"));
	 
	 //*************Task 7 Click on Cart******//////////////////////////////
	 action.moveToElement(cart_button).perform();
	 cart_button.click();
	 
	 
	 //Click on cart icon
	 WebElement cart_icon = driver.findElement(By.xpath("//div[@class='cart-menu-wrapper']"));
	 cart_icon.click();
	 Thread.sleep(5000);
	 
	 driver.navigate().back();
	
	}
	
	public static void browserClose() {
		
		
		driver.close();
	}

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		try {
			browserSetup();
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
		
		try {
			testScript();	
		}
        catch(Exception ex) {
        	System.out.println(ex);
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//browserClose();
	}

}
