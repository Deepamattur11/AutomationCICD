package rahulshettyacademy.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckOutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.OrderPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;


public class SubmitOrderTest extends BaseTest {
	String productName="ADIDAS ORIGINAL";
	@Test(dataProvider ="getData",groups = {"Purchase"})
	public void submitOrder(HashMap<String,String> input) throws InterruptedException, IOException {
		ProductCatalogue productcatalog=landingPage.LoginApplication(input.get("email"), input.get("pwd"));
		List<WebElement> products=productcatalog.getProductList();
		productcatalog.addProductToCart(input.get("productName"));
		CartPage cartpage=productcatalog.goToCartPage();
		boolean match=cartpage.validateCartProducts(input.get("productName"));
		assertTrue(match);   // Assertions should be in main test page itself
		//driver.quit();
		CheckOutPage checkoutPage=cartpage.goToCheckOut();
		checkoutPage.selectCountry("India");
		ConfirmationPage confirmationPage=checkoutPage.submitOrder();
		String msg=confirmationPage.verifyConfirmationMessage();
		Assert.assertTrue(msg.equalsIgnoreCase("Thankyou for the order."));
		
	}
	//To verify ADIDAS ORIGINAL is present in orders page
	@Test(dependsOnMethods = {"submitOrder"})
	public void orderHistoryTest() {
		ProductCatalogue productcatalog=landingPage.LoginApplication("deeps1995@gmail.com", "Deeps@1995");
		driver.findElement(By.cssSelector("[routerlink='/dashboard/myorders']")).click();
		OrderPage orderpage=productcatalog.goToOrderPage();
		boolean match=orderpage.verifyOrderDisplay(productName);
		assertTrue(match);
	}
	

	@DataProvider
	public Object[][] getData() throws IOException {

		List<HashMap<String,String>> data=getJSONDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\rahulshettyacademy\\data\\PurchaseOrder.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}

}
//HashMap<String,String> map=new HashMap<String,String>();
//map.put("email", "deeps1995@gmail.com");
//map.put("pwd", "Deeps@1995");
//map.put("productName", "ADIDAS ORIGINAL");
//
//HashMap<String,String> map1=new HashMap<String,String>();
//map1.put("email", "asha1992@gmail.com");
//map1.put("pwd", "Ash@1992");
//map1.put("productName", "ZARA COAT 3");
