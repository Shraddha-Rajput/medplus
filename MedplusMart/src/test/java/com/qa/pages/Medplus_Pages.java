package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Medplus_Pages {
	
	@FindBy(xpath="//a[@title='Sign In/Register']")
	WebElement Signin;
	
    public WebElement getSignin() 
    {
    	
    	return Signin;
    }
    
     @FindBy(xpath="//input[@id='username']")
     WebElement Username;
     
     public WebElement getUsername() 
     {
    	 return Username;
    	
     }
    
     @FindBy(xpath="//input[@id='password']")
     WebElement Password;
     
     public WebElement getPassword()
     {
    	 return Password;
     }
     
     @FindBy(xpath="//button[@title='Sign In']")
     WebElement Signinbtn;
	
     
     public WebElement getSigninbtn()
     {
    	 return Signinbtn;
     }
     
    @FindBy(xpath = "//*[@id=\"enterval\"]")
    WebElement Searcheng;
    
	
     public WebElement getSearcheng() {
		return Searcheng;
	}
	

	@FindBy(xpath = "//*[@id=\"productSearchFrm\"]/div/div[1]/span[3]/button")
     WebElement Clicksearch;
     
     

	public WebElement getClicksearch() {
		return Clicksearch;
	}
	@FindAll(@FindBy(className = "searchResultProductName"))
	List<WebElement> Fetchproduct;
	

	public List<WebElement> getFetchproduct() {
		return Fetchproduct;
	}
	

	 
	 @FindBy(id = "customerSignIn")
	 WebElement Customersignout;
	 
	

	public WebElement getCustomersignout() {
		return Customersignout;
	}
	
	@FindBy(linkText = "Logout")
	public WebElement Logout;
	

	public WebElement getLogout() {
		return Logout;
	}
	  @FindBy(id = "MartSearchCategories")
	     WebElement Martsearchcategories;
	     
	     
	    public WebElement getMartsearchcategories() {
			return Martsearchcategories;
		}
	    
	    
	  
	   
	 // ADD to cart  //*[@id="productSearchAllTable"]/tbody/tr[2]/td[4]/div/div/form/div[2]/button
	    @FindBy(xpath="//*[@id=\"productSearchAllTable\"]/tbody/tr[1]/td[4]/div/div/form/div[2]/button")
	//@FindBy(xpath="//*[@id="productSearchAllTable"]/tbody/tr[1]/td[4]/div/div/form/div[2]/button")
	    WebElement addtocart;
	         
	    public WebElement getaddtocart() 
	    {
			return addtocart;
		}
	   
	
	    
	    

	WebDriver driver;
     public Medplus_Pages(WebDriver driver)
 	{
 		this.driver=driver;
 		PageFactory.initElements(driver,this);
 	}
	

}
