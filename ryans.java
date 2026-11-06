import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ryans {
	public static void main (String [] args)
{
	System.setProperty("WebDriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	
	//open ryans
	driver.get("https://www.ryans.com/");
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	
	//search_for_a_product
	driver.findElement(By.xpath("//input[@id='user-search-box']"));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("search"))).sendKeys("ram",Keys.ENTER);
	driver.findElement(By.xpath("//*[@id=\"_05a9179c8744145209d5e72a\"]/div/label/input"));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"_05a9179c8744145209d5e72a\"]/div/label/input"))).click();

	//add_product_to_the_cart
	
	driver.findElement(By.xpath("(//button[@type='submit'][normalize-space()='Add to Cart'])[2]"));
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@type='submit'][normalize-space()='Add to Cart'])[2]"))).click();
    
	//open_the_cart
	
	// Click View Cart
	  //  ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'View Cart')]")));viewCart.click();

	//wait.until(ExpectedConditions.urlContains("cart"));

	//System.out.println("Cart opened successfully");



}
	
}
