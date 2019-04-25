package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class aLOK
{
	static WebDriver d;
	public void test()
	{
		String url = "https://www.google.com";
		System.setProperty("webdriver.chrome.driver", "C://Users//Administrator//Downloads//chromedriver_win32//chromedriver.exe");
		d = new ChromeDriver();
		d.get(url);
		d.findElement(By.name("as")).click();
		d.close();

	}

	public void testalok()
	{
		Assert.assertEquals("an", "a");
	}
}
