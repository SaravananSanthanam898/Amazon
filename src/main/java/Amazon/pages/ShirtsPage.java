package Amazon.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Amazon.base.testbase;

public class ShirtsPage extends testbase{
	
	@FindBy(xpath="//button[@value='40']")WebElement Size;
	@FindBy(xpath="//span[text()='Price and other details may vary based on product size and colour.']")WebElement PageVerification;
	@FindBy(xpath="//span[text()='Standard Size']")WebElement ScrollPayOnDelivery;
	@FindBy(xpath="//ul[@aria-labelledby='p_n_is_cod_eligible-title']")WebElement eligible;
	@FindBy(xpath="//img[@data-image-index='3']")WebElement profile;
    @FindBy(css="select#native_dropdown_selected_size_name")WebElement dropdown;
    @FindBy(xpath="//input[@id='add-to-cart-button']")WebElement AddCart;
    @FindBy(css="div#nav-cart-count-container")WebElement Cart;
    @FindBy(css="span.a-truncate.a-size-medium")WebElement verifycart;
    
	public ShirtsPage()//PAGE FACTORY INITIALIZATION
	{
		PageFactory.initElements(driver,this);
	}
	
	public void ClickSize40()//CLICK SIZE NO. 40
	{
		Size.click();
	}
	public boolean ProductPageverfication()//PAGE VERFICATION
	{
		return PageVerification.isDisplayed();
	}
	public void ScrollPayOnDelivery()//SCROLL BY PAY ON DELEIVERY
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)",ScrollPayOnDelivery);
	}
	public void TillAddtoCart() //CLICK ELEGIBLE,CLICK PROFILE,
	{
		eligible.click();
		profile.click();
		String win1=driver.getWindowHandle();
		System.out.println("PARENT WINDOW ID: "+win1);
		Set<String>st=driver.getWindowHandles();
		List<String>lst=new ArrayList<String>(st);
		driver.switchTo().window(lst.get(1));
		String win2=driver.getWindowHandle();
		System.out.println("CHILD WINDOW ID: "+win2);
		Select sl=new Select(dropdown);
		sl.selectByValue("1,B079TQ5NT6");
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,200)");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AddCart.click();
		Cart.click();
	}
	public boolean VerifyCart()
	{
		return verifycart.isDisplayed();
	}
	public void Print()
	{
		System.out.println("SELECTED ITEM IS: "+verifycart.getText());
	}

}
