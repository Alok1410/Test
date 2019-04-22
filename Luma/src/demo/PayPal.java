package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PayPal
{
	public void paypal(WebDriver d) throws InterruptedException
	{
		System.out.println("Hi apl");
		WebDriverWait w = new WebDriverWait(d, 40);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='cybersourcepaypal']"))).click();
		d.findElement(By.xpath("//button[@id='placeOrder']")).click();

		Thread.sleep(30000);

		if (d.findElements(By.xpath("//input[@id='submitLogin']")).size() != 0)
		{

			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='login_email']"))).sendKeys("chrisrduffharper-buyer@gmail.com");
			d.findElement(By.xpath("//input[@name='login_password']")).sendKeys("1967camero");
			d.findElement(By.id("submitLogin")).click();
			Thread.sleep(12000);

			w.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='continue_abovefold']")));
			WebElement element3 = d.findElement(By.xpath("//input[@id='continue_abovefold']"));
			((JavascriptExecutor) d).executeScript("arguments[0].scrollIntoView(true);", element3);
			element3.click();

		}
		else
		{
			Thread.sleep(5000);
			d.switchTo().frame("injectedUl");
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='login_email']"))).sendKeys("chrisrduffharper-buyer@gmail.com");
			d.findElement(By.xpath("//input[@name='login_password']")).sendKeys("1967camero");
			d.findElement(By.id("btnLogin")).click();

			Thread.sleep(15000);
			WebElement element2 = d.findElement(By.xpath("//input[@id='confirmButtonTop']"));
			((JavascriptExecutor) d).executeScript("arguments[0].scrollIntoView(true);", element2);
			element2.click();

		}

	}

}
