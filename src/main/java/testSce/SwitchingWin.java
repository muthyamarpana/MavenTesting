package testSce;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SwitchingWin {

	WebDriver driver;
	@Test
	public void switchWin()
	{
		driver=new EdgeDriver();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("/html/body/button")).click();
		Set<String> allWinIds=driver.getWindowHandles();
		System.out.println("total number of windows="+allWinIds.size());
		Iterator<String> itr=allWinIds.iterator();
		String win1=null;
		String win2=null;
		win1=itr.next();
		win2=itr.next();
		System.out.println(win1);
		System.out.println(win2);
		System.out.println("Window1 title="+driver.getTitle());
		driver.switchTo().window(win2);
		System.out.println("Window2 title="+driver.getTitle());
		boolean chkSignin=driver.findElement(By.xpath("//*[@id=\"tnb-login-btn\"]/span[1]")).isEnabled();
		System.out.println(chkSignin);
		Assert.assertEquals(chkSignin, true);
		driver.quit();
	}
}
