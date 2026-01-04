package rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents{

	WebDriver driver;
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement userpwd;
	
	@FindBy(id="login")
	WebElement login;
	
	@FindBy(css=".toast-message")
	WebElement errorMessage;
	
	public String getErrorMessage() {
		waitForWebElementToAppear(errorMessage);
		String msg=errorMessage.getText();
		return msg;
	}
		

	public ProductCatalogue LoginApplication(String email,String pwd) {
		userEmail.sendKeys(email);
		userpwd.sendKeys(pwd);
		login.click();
		ProductCatalogue productcatalog=new ProductCatalogue(driver);
		return productcatalog;
	}
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}

}
