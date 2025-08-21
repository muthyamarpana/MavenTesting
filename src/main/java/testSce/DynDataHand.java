package testSce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;



public class DynDataHand 
{
	WebDriver driver;
	@Test
	public void readDynData() throws InterruptedException
	{
	driver=new EdgeDriver();
	driver.get("https://www.jqueryscript.net/demo/Simple-Math-Captcha-Plugin-for-jQuery-ebcaptcha/demo/");
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	driver.manage().window().maximize();
	for(int i=1;i<=3;i++)
	{
	String str=driver.findElement(By.id("ebcaptchatext")).getText();
	System.out.println(str);
	String str1=str.substring(8, 9);
	String str2=str.substring(12, 13);
	System.out.println(str1+"\t"+str2);
	Integer res=Integer.valueOf(str1) + Integer.valueOf(str2);
	System.out.println(res);
	driver.findElement(By.id("ebcaptchainput")).sendKeys(String.valueOf(res));
	Thread.sleep(5000);
	boolean chkSubBtn=driver.findElement(By.xpath("//*[@id=\"form\"]/input[2]")).isEnabled();
	System.out.println(chkSubBtn);
	Assert.assertEquals(chkSubBtn, true);
	driver.navigate().refresh();
	}
	driver.quit();
	
	}
}
