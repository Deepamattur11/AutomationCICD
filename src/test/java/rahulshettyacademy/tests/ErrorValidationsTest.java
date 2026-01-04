package rahulshettyacademy.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;



import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.TestComponents.Retry;
import rahulshettyacademy.pageobjects.ProductCatalogue;


public class ErrorValidationsTest extends BaseTest {
	
	@Test(groups= {"ErrorHandling"},retryAnalyzer=Retry.class)
	public void loginErrorValidation() throws InterruptedException, IOException {
		
		String productName="ADIDAS ORIGINAL";
		ProductCatalogue productcatalog=landingPage.LoginApplication("deeps2025@gmail.com", "Deeps@1995");
		Assert.assertEquals(landingPage.getErrorMessage(),"Incorrect email or password.");
	}

}
