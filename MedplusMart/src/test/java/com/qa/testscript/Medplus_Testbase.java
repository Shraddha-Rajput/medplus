package com.qa.testscript;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.qa.pages.Medplus_Pages;

public class Medplus_Testbase 
{

	WebDriver driver;
	Medplus_Pages medplus;
	Actions act;


	@Parameters({"Browser","Url"})
	@BeforeClass
	public void setup(String Browser,String Url)
	{
		if(Browser.equalsIgnoreCase("Chrome"))
		{

			System.setProperty("webdriver.chrome.driver","C:\\Users\\Rajput\\Desktop\\MedplusMart\\Driver\\chromedriver.exe");
			driver = new ChromeDriver();
		}


		else if(Browser.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver","C:\\Users\\Rajput\\Desktop\\MedplusMart\\Driver\\msedgedriver.exe");
			driver= new EdgeDriver();

		}

		driver.manage().window().maximize();
		act=new Actions(driver);
		medplus=new Medplus_Pages(driver);
		driver.get(Url);

	}



	public void CaptureScreenshot(WebDriver driver, String name) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File Source = ts.getScreenshotAs(OutputType.FILE);
		String target = System.getProperty("user.dir") + "/Screenshots/" + name + System.currentTimeMillis() + ".png";
		FileUtils.copyFile(Source ,new File(target));
		System.out.println("Screenshot captured");

	}


	@AfterClass
	public void tearDown()
	{
		driver.close();

	}


}
