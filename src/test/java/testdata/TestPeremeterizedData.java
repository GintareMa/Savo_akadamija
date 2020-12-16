package testdata;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import basetest.BaseTest;
import page.MainPage;
import page.SearchPage;
import utilities.FileReaderUtils;

@RunWith(Parameterized.class)
public class TestPeremeterizedData extends BaseTest {

	private MainPage mainPage = new MainPage(driver);
	private SearchPage searchPage = new SearchPage(driver);
	private String productName;
	
		public TestPeremeterizedData(String productName) {
		super();
		this.productName = productName;
	}



	@Test
	public void TestPeremeterizedData() {
		
		mainPage.writeInputSearch(productName);
		mainPage.clickButtonSearch();
		
		String actualResult = searchPage.getTextFromLinkFirstItem();
		
		assertEquals("Actual resul does not match expected. Actual resul:" + actualResult + " , but expected:" + productName, productName, actualResult);
	}	
	
	@Parameters
	public static Collection<String> parameters() throws IOException{
		return FileReaderUtils.getTestData("src/test/resources/TestData_3Items.txt");
	}
	
//	@Parameters
//	public static Collection<String> parameters(){
//		return Arrays.asList("iPhone", "MacBook", "Canon EOS 5D");
//	}
}
