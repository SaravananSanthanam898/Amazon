package AdminScript;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Amazon.base.testbase;
import Amazon.pages.Amazondashboardpage;

public class AmazonDashboardTest extends testbase{
	
	Amazondashboardpage dashobj;
	
	public AmazonDashboardTest() 
	{
		super();
	}
	
	@BeforeClass
	public void setup()
	{
		initialization();
		dashobj=new Amazondashboardpage();
	}
	@Test
	public void DashboardTest() 
	{
		dashobj.getTitlefromAmazon();
		String expectedpagetitle="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		Assert.assertEquals(dashobj.PageTitle(), expectedpagetitle);
		Assert.assertTrue(dashobj.PageText());
		dashobj.ClickAll();
		Assert.assertTrue(dashobj.CheckMensClothingPage());
		dashobj.ClickShirts();
	}

	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
}
