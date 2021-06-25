package com.qa.testscript;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

//import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.utility.ExcelUtility;

public class TC_Medplus extends Medplus_Testbase 
{
	//1.phone no and pwd
	@Test(dataProvider="getData",priority=1)
	public void MedplusLogin(String input1, String input2) throws IOException, Exception{

		//captureScreenshot(driver,"MedplusLogin");
		medplus.getSignin().click();
		Thread.sleep(2000);
		medplus.getUsername().sendKeys(input1);
		Thread.sleep(2000);
		medplus.getPassword().sendKeys(input2);
		Thread.sleep(2000);
		//  CaptureScreenshot(driver, "MedplusLogin");
		medplus.getSigninbtn().click();
		Thread.sleep(6000);

	}

	//2.Searching product



	@Test(dataProvider = "getDataForMedplusSearch", priority = 2, dependsOnMethods = "MedplusLogin")

	public void MedplusSearch(String input1) throws Exception {
		medplus.getMartsearchcategories().click();
		Thread.sleep(3000);
		act.sendKeys(Keys.TAB).
		pause(Duration.ofSeconds(1)).
		sendKeys(Keys.TAB).
		pause(Duration.ofSeconds(1)).
		sendKeys(Keys.TAB).
		pause(Duration.ofSeconds(1)).
		sendKeys(Keys.ENTER).
		build().perform();
		Thread.sleep(2000);

		medplus.getSearcheng().sendKeys(input1);
		Thread.sleep(3000);
		// CaptureScreenshot(driver, "MedplusSearch");
		medplus.getClicksearch().click();
		Thread.sleep(4000);



		medplus.getaddtocart().click();Thread.sleep(3000);


		List<WebElement> fetchpro=medplus.getFetchproduct();
		for(WebElement products:fetchpro) 
		{

			String getproducts=products.getText();
			Reporter.log(getproducts,true);


		}


		String title = driver.getTitle();
		//if(title.contains(input1))
	/*	if(title ==  input1) 
		{

			Reporter.log("title matched",true);
			Assert.assertTrue(true);
		}
		else
		{

			CaptureScreenshot(driver,"MedplusSearch");
			Reporter.log("title not matched",true);
			Assert.assertTrue(false);
		}

*/
		 
	}


	//signout
	@Test(priority = 3,dependsOnMethods = "MedplusSearch")
	public void medplussignout() throws Exception {
		medplus.getCustomersignout().click();
		Thread.sleep(2000);
		medplus.getLogout().click();
		CaptureScreenshot(driver, "medplussignout");
		Thread.sleep(2000);
	}




	@DataProvider
	public String[][] getData() throws IOException
	{

		String xlPath="C:\\Users\\Rajput\\Desktop\\MedplusMart\\src\\test\\java\\com\\testdata\\TestData1.xlsx";
		String xlSheet="Sheet1";
		int rowCount=ExcelUtility.getRowCount(xlPath, xlSheet);
		int cellCount=ExcelUtility.getCellCount(xlPath, xlSheet,rowCount);


		String[][] data=new String[rowCount][cellCount];

		for(int i=1;i<=rowCount;i++)
		{
			for(int j=0;j<cellCount;j++)
			{
				data[i-1][j]=ExcelUtility.getCellData(xlPath,xlSheet,i,j);
			}
		}	
		return data;		

	}


	@DataProvider
	public String[][] getDataForMedplusSearch() throws IOException
	{

		String xlPath="C:\\Users\\Rajput\\Desktop\\MedplusMart\\src\\test\\java\\com\\testdata\\TestData1.xlsx";
		String xlSheet="Sheet2";
		int rowCount=ExcelUtility.getRowCount(xlPath, xlSheet);
		int cellCount=ExcelUtility.getCellCount(xlPath, xlSheet,rowCount);


		String[][] data=new String[rowCount][cellCount];

		for(int i=1;i<=rowCount;i++)
		{
			for(int j=0;j<cellCount;j++)
			{
				data[i-1][j]=ExcelUtility.getCellData(xlPath,xlSheet,i,j);
			}
		}	
		return data;		

	}

}
