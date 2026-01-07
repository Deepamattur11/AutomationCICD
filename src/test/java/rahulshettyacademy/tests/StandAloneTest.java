package rahulshettyacademy.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.pageobjects.LandingPage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
public class StandAloneTest {
//new comments added to test cicd
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		LandingPage landingPage=new LandingPage(driver);
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		String productName="ADIDAS ORIGINAL";
		driver.findElement(By.id("userEmail")).sendKeys("deeps1995@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Deeps@1995");
		driver.findElement(By.id("login")).click();
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector(".mb-3"))));
		List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));
		WebElement prod=products.stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().contains(productName)).findFirst().orElse(null);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector("#toast-container"))));
		//ng-animating
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
		List<WebElement> cartProducts=driver.findElements(By.cssSelector(".cartSection h3"));
		boolean match=cartProducts.stream().anyMatch(cartproduct->cartproduct.getText().contains(productName));
		Assert.assertTrue(match);
		
	
		driver.findElement(By.cssSelector(".totalRow button")).click();
		Actions a=new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "Ind").build().perform();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
	driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();  //OR xpath= (//button[contains(@class,'ta-item')])[2]
	driver.findElement(By.cssSelector(".action__submit")).click();
	String confirmMessage=driver.findElement(By.cssSelector(".hero-primary")).getText();
	Assert.assertTrue(confirmMessage.equalsIgnoreCase("Thankyou for the order."));
	driver.quit();
	
	}

}
