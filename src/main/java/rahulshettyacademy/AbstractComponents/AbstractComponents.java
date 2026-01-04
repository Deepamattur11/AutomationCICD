package rahulshettyacademy.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.OrderPage;

public class AbstractComponents {

		WebDriver driver;
	public AbstractComponents(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//button[@routerlink='/dashboard/cart']")
	WebElement cart;
	
	@FindBy(css="[routerlink='/dashboard/myorders']")
	WebElement orderHeader;
	
	public void waitForElementToAppear(By findBy) {
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfElementLocated((findBy)));
	}
	
	public void waitForWebElementToAppear(WebElement errorMsg) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(errorMsg));
		}
	
	
	public void waitForlementToDisappear(WebElement spinner) throws InterruptedException {
		Thread.sleep(1000);
//		//4 seconds-application issue due to load
//		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(2));
//		wait.until(ExpectedConditions.invisibilityOf(spinner));
	}
	

	//defining below method here as Cart option is common at all steps so it can be used by any class
	public CartPage goToCartPage() {
		cart.click();
		CartPage cartpage=new CartPage(driver);
		return cartpage;
		
	}
	
	public OrderPage goToOrderPage() {
		orderHeader.click();
		OrderPage orderpage=new OrderPage(driver);
		return orderpage;
		
	}

}
