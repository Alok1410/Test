package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SecureAcceptanceSOP
{
	public void sop(WebDriver d) throws InterruptedException
	{

		WebElement element1 = d.findElement(By.id("chcybersource"));
		((JavascriptExecutor) d).executeScript("arguments[0].scrollIntoView(true);", element1);
		element1.click();

		d.findElement(By.id("cybersource-token-new")).click();

		Select visa = new Select(d.findElement(By.id("card_type")));
		visa.selectByVisibleText("Visa");

		d.findElement(By.id("card_number")).sendKeys("4111111111111111");

		Select mnth = new Select(d.findElement(By.name("payment['cc_exp_month']")));
		mnth.selectByIndex(3);
		Select year = new Select(d.findElement(By.name("payment['cc_exp_year']")));
		year.selectByIndex(5);

		d.findElement(By.name("card_cvn")).sendKeys("123");

		WebElement element = d.findElement(By.xpath("(//button[@title='Place Order'])[2]"));
		((JavascriptExecutor) d).executeScript("arguments[0].scrollIntoView(true);", element);
		element.click();

	}

}
