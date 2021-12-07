package AdminScript;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Amazon.base.testbase;
import Amazon.pages.Amazondashboardpage;
import Amazon.pages.ShirtsPage;

public class AddCarttest extends testbase{
	
	Amazondashboardpage dashobj;
	ShirtsPage shobj;
	
	public AddCarttest()
	{
		super();
	}

	
	@BeforeClass
	public void setup() 
	{
		initialization();
		dashobj=new Amazondashboardpage();
		shobj=dashobj.ClickAll();
		shobj=dashobj.ClickShirts();
	}
	@Test
	public void AddCartTest() 
	{
		shobj.ClickSize40();
		Assert.assertTrue(shobj.ProductPageverfication());
		shobj.ScrollPayOnDelivery();
		shobj.TillAddtoCart();
		Assert.assertTrue(shobj.VerifyCart());
		shobj.Print();
		
	}
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
}
