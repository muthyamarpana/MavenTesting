package testSce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class LetsCodeIt {

	WebDriver driver;
	@Test
	public void radAndCheckBox() throws InterruptedException
	{
		driver=new EdgeDriver();
		driver.get("https://www.letskodeit.com/practice");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		WebElement radBMW=driver.findElement(By.id("bmwradio"));
		radBMW.click();
		WebElement chkBenz=driver.findElement(By.id("benzcheck"));
		WebElement chkHonda=driver.findElement(By.id("hondacheck"));
		chkBenz.click();
		chkHonda.click();
		
		if(radBMW.isSelected())
		{
			System.out.println("BMW Radio button is selected, Passed");
		}
		else
		{
			System.out.println("BMW Radio button is not selected, Failed");
		}
		
		if(chkBenz.isSelected() && chkHonda.isSelected())
		{
			System.out.println("Benz and Honda checkboxes are selected... Passed");
		}
		else
		{
			System.out.println("Benz or Honda checkboxes not selected... Failed");
		}
		Thread.sleep(5000);
		driver.quit();
		
	}
}
