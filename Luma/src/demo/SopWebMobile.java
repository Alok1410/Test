package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SopWebMobile
{
	public void sopwm(WebDriver d) throws InterruptedException
	{
		Thread.sleep(2000);
		WebElement element1 = d.findElement(By.id("chcybersource"));
		((JavascriptExecutor) d).executeScript("arguments[0].scrollIntoView(true);", element1);
		element1.click();

		d.findElement(By.id("cybersource-token-new")).click();

		WebElement element = d.findElement(By.xpath("(//button[@title='Place Order'])[2]"));
		((JavascriptExecutor) d).executeScript("arguments[0].scrollIntoView(true);", element);
		element.click();
		//WebDriverWait w = new WebDriverWait(d, 20000);

		if (d.findElement(By.id("cybersource-frame")).isDisplayed())
		{
			d.switchTo().frame("cybersource-frame");
			Thread.sleep(7000);

		}
		Thread.sleep(8000);

		WebElement element3 = d.findElement(By.xpath("//input[@id='card_type_001']"));
		((JavascriptExecutor) d).executeScript("arguments[0].scrollIntoView(true);", element3);
		element3.click();

		d.findElement(By.id("card_number")).sendKeys("4111111111111111");

		Select mnth = new Select(d.findElement(By.name("card_expiry_month")));
		mnth.selectByIndex(3);
		Select year = new Select(d.findElement(By.name("card_expiry_year")));
		year.selectByIndex(5);

		d.findElement(By.id("card_cvn")).sendKeys("123");

		Thread.sleep(3000);

		WebElement element2 = d.findElement(By.xpath("//input[@name='commit']"));
		((JavascriptExecutor) d).executeScript("arguments[0].scrollIntoView(true);", element2);
		element2.click();

		Thread.sleep(2000);

		d.findElement(By.xpath("//input[@name='commit']")).click();

	}
}
