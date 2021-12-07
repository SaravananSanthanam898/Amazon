package Amazon.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Amazon.base.testbase;

public class Amazondashboardpage extends testbase{
	
	
	@FindBy(xpath="//a[@id='nav-logo-sprites']")WebElement amazontext;
	@FindBy(css="div#nav-main>div.nav-left")WebElement all;
	@FindBy(xpath="//div[text()='shop by department']")WebElement scrollmensfashion;
	@FindBy(xpath="//a[@data-menu-id='10']")WebElement Mensfashion;
	@FindBy(css="ul.hmenu-translateX>li:nth-child(2)")WebElement MensClothing;
	@FindBy(css="ul.hmenu-translateX>li:nth-child(5)")WebElement Shirts;
	
	
	public Amazondashboardpage() 
	{
		PageFactory.initElements(driver, this);
	}
	
	public void getTitlefromAmazon()//GET THE TITLE FROM THE AMAZON
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		System.err.println("THE TITLE OF THE AMAZON IS: "+js.executeScript("return document.title").toString());
	}
	
	public String PageTitle()//CHECK THE AMAZON PAGE TITLE
	{
		return driver.getTitle();
	}
	
	public boolean PageText()//CHECK THE DASHBOARD TITLE
	{
		return amazontext.isDisplayed();
	}
	
    public ShirtsPage ClickAll() //CLICK ALL BUTTON AND SCROLL BY THE MENSFASHION AND CLICK MEN'S FASHION
	{
    	all.click();
    	try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true)",scrollmensfashion);
        Mensfashion.click();
        return new ShirtsPage();
    }
    public boolean CheckMensClothingPage()//CHECK THE MENS CLOTHING PAGE
    {
    	return MensClothing.isDisplayed();
    }
    public ShirtsPage ClickShirts()//CLICK SHIRTS
    {
    	Shirts.click();
    	return new ShirtsPage();
    }
}
