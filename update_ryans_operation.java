import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import org.openqa.selenium.WebElement;
public class update_ryans_operation {
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
	
	/*
	driver.findElement(By.xpath("//*[@id=\"_05a9179c8744145209d5e72a\"]/div/label/input"));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"_05a9179c8744145209d5e72a\"]/div/label/input"))).click();
*/
	//add_product_to_the_cart
	
	driver.findElement(By.xpath("(//button[@type='submit'][normalize-space()='Add to Cart'])[2]"));
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@type='submit'][normalize-space()='Add to Cart'])[2]"))).click();    
	// open the cart
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'View Cart')]"))).click();
	wait.until(ExpectedConditions.urlContains("cart"));
	System.out.println("Cart opened successfully");
	List<WebElement> cartItems = wait.until(
	        ExpectedConditions.visibilityOfAllElementsLocatedBy(
	                By.xpath("//table//tbody/tr")));
//verify the product
	int productCount = cartItems.size();
	System.out.println("Products in cart: " + productCount);

	if (productCount == 1) {
	    System.out.println("PASS: Product count is correct");
	} else {
	    System.out.println("FAIL: Expected 1 product but found " + productCount);
	}
	WebElement qtyBox = wait.until(ExpectedConditions.visibilityOfElementLocated(
	        By.xpath("//input[contains(@class,'qty') or @name='quantity']")));

	String qty = qtyBox.getAttribute("value");
	System.out.println("Quantity in cart: " + qty);

	if (qty.equals("1")) {
	    System.out.println("PASS: Quantity is correct");
	} else {
	    System.out.println("FAIL: Expected quantity 1 but found " + qty);
	}
	// remove the product
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@class,'remove')] | //button[contains(@class,'remove')] | //*[contains(text(),'Remove')]"))).click();
	// handle a confirmation popup if the site shows one
	// driver.switchTo().alert().accept();
	// verify the cart is updated
	wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//table//tbody/tr"), 0));

	List<WebElement> itemsAfter = driver.findElements(By.xpath("//table//tbody/tr"));
	if (itemsAfter.isEmpty()) {
	    System.out.println("PASS: Product removed, cart updated");
	} else {
	    System.out.println("FAIL: Product still in cart");
	}

	driver.quit();


}
	
}
