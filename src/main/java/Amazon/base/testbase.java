package Amazon.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testbase {
	
	public static WebDriver driver;
	public static Properties prop;
	

	public testbase()
	{
		prop=new Properties();
		try {
			FileInputStream FIS=new FileInputStream("./src/main/java/Amazon/config/config.properties");
			prop.load(FIS);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void initialization()
	{
		String browsername=prop.getProperty("BROWSER");
		if(browsername.equals("chrome")) 
		{
			
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
				
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		driver.get(prop.getProperty("URL"));
	}
	
	public void waitforvisibility(WebElement webE)
	{
		WebDriverWait wait=new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(webE));
	}
	
	
}
