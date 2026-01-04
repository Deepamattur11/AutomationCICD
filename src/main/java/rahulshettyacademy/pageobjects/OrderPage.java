package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import rahulshettyacademy.AbstractComponents.AbstractComponents;

public class OrderPage extends AbstractComponents{

	WebDriver driver;
	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));
	
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> productNames;
	
	@FindBy(css=".totalRow button")
	WebElement checkoutEle;
	
	public boolean verifyOrderDisplay(String productName) {
		boolean match=productNames.stream().anyMatch(cartproduct->cartproduct.getText().contains(productName));
		return match;
		
	}

	public CheckOutPage goToCheckOut() {
		checkoutEle.click();
		CheckOutPage checkoutPage=new CheckOutPage(driver);
		return checkoutPage;
	}
	
	
	
	
	}

