package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class ReadDataFromCmdLine_Test {
	@Test
	public void cmdLine() {
	
		String browser = System.getProperty("browser");
		String url = System.getProperty("url");
		String username = System.getProperty("username");
		String password = System.getProperty("password");
		
		System.out.println("browser = "+browser);
		System.out.println("url = "+url);
		System.out.println("username = "+username);
		System.out.println("password = "+password);
		
		WebDriver driver = null;
		if(browser.equalsIgnoreCase("chrome")) {
			
			driver = new ChromeDriver();
			System.out.println("Chrome is lunched");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		
		else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		      
		       System.out.println("FireFox is lunched");
		}
		else if(browser.equalsIgnoreCase("edge")){
			System.setProperty(
            "webdriver.edge.driver",
            "C:\\Drivers\\msedgedriver.exe"
        );
			 driver = new EdgeDriver();
			System.out.println("Edge is lunched");
		}
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		driver.quit();
		 
	}
}
