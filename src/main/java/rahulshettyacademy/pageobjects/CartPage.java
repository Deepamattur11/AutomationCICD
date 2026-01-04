package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import rahulshettyacademy.AbstractComponents.AbstractComponents;

public class CartPage extends AbstractComponents{

	WebDriver driver;
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));
	
	@FindBy(css=".cartSection h3")
	List<WebElement> cartProducts;
	
	@FindBy(css=".totalRow button")
	WebElement checkoutEle;
	
	
	public boolean validateCartProducts(String productName) {
		boolean match=cartProducts.stream().anyMatch(cartproduct->cartproduct.getText().contains(productName));
		return match;
		
	}

	public CheckOutPage goToCheckOut() {
		checkoutEle.click();
		CheckOutPage checkoutPage=new CheckOutPage(driver);
		return checkoutPage;
	}
	
	
	
	
	}

