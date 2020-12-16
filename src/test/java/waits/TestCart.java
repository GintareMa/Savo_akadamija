package waits;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basetest.BaseTest;
import junit.framework.Assert;
import page.MainPage;

public class TestCart extends BaseTest {
	
	private MainPage mainPage = new MainPage(driver);
	
	@Test
	public void testCart() {
		String text = "%s item(s)";
		
		mainPage.clickLinkDesktops();
		mainPage.clickLinkAllDesktops();
				
		addToCart("iPhone", "MacBook","Sony VAIO");
		
		String actualCartText = mainPage.buttonCart.getText();
		String expectedCartText = String.format(text, 3);
		assertTrue("Chart does not contain expected text", actualCartText.contains(expectedCartText));
			
		//mainPage.removeItemFromCart();
		//mainPage.removeItemFromCart();
		//mainPage.removeItemFromCart();
		
		mainPage.getButtonsRemoveItem().forEach(button -> mainPage.removeItemFromCart());
		
		actualCartText = mainPage.buttonCart.getText();
		expectedCartText = String.format(text, 0);
		assertTrue("Chart does not contain expected text", actualCartText.contains(expectedCartText));

		
	}
	
	private void addToCart(String...productNames) { // a
		for (String name : productNames) {
			mainPage.clickAddToCart(name);
		}
	}
}


	
	