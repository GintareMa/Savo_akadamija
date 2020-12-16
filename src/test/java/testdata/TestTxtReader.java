package testdata;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

import basetest.BaseTest;
import page.MainPage;
import page.SearchPage;
import utilities.FileReaderUtils;

public class TestTxtReader extends BaseTest {

	private MainPage mainPage = new MainPage(driver);
	private SearchPage searchPage = new SearchPage(driver);
	
	@Test
	public void testTextReader() throws IOException {
		List<String> testdata = FileReaderUtils.getTestData("src/test/resources/TestData_iPhone.txt");
		
		String productName = testdata.get(0);
		
		mainPage.writeInputSearch(productName);
		mainPage.clickButtonSearch();
		
		String actualResult = searchPage.getTextFromLinkFirstItem();
		
		assertEquals("Actual resul does not match expected. Actual resul:" + actualResult + " , but expected:" + productName, productName, actualResult);
	}	
}
