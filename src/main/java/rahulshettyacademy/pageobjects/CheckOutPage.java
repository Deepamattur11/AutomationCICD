package rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import rahulshettyacademy.AbstractComponents.AbstractComponents;

public class CheckOutPage extends AbstractComponents{

	WebDriver driver;
	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css="[placeholder='Select Country']")
	private WebElement countryTextBox;
	
	@FindBy(css=".ta-item:nth-of-type(2)")
	private WebElement country;
	
	By countryList=By.cssSelector(".ta-results");
	
	@FindBy(css=".action__submit")
	private WebElement placeOrder;
	
	
	public void selectCountry(String countryName) {
		Actions a=new Actions(driver);
		a.sendKeys(countryTextBox, countryName).build().perform();
		waitForElementToAppear(countryList);
		country.click();
		
	}
	
	public ConfirmationPage submitOrder() {
		placeOrder.click();
		ConfirmationPage confirmationPage=new ConfirmationPage(driver);
		return confirmationPage;
		
	}
	
}
