package testdata;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

import basetest.BaseTest;
import models.ShopItem;
import page.MainPage;
import page.SearchPage;
import utilities.FileReaderUtils;

public class TestXmlReader extends BaseTest {

	private MainPage mainPage = new MainPage(driver);
	private SearchPage searchPage = new SearchPage(driver);
	
	@Test
	public void testTextReader() throws IOException {
		ShopItem item = new ShopItem();
		item.setName("iPhone");
		item.setBrand("Apple");
		item.setPrice("$123.20");
		
		String fileName = "phone";
		
		FileReaderUtils.writeShopItemToFile(item, fileName);
		
		ShopItem iPhone = FileReaderUtils.readFileToShopItem(fileName);
		String expectedResult = iPhone.getName();
		
		
		mainPage.writeInputSearch(expectedResult);
		mainPage.clickButtonSearch();
		
		String actualResult = searchPage.getTextFromLinkFirstItem();
		
		assertEquals("Actual resul does not match expected. Actual resul:" + actualResult + " , but expected:" + expectedResult, expectedResult, actualResult);
	}	
}
