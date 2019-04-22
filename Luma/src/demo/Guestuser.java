package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Guestuser
{

	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C://Users//Administrator//Downloads//chromedriver_win32//chromedriver.exe");
		WebDriver d = new ChromeDriver();

		d.navigate().to("http://cybersourcephase02a.van01.collinsharper.com/men/tops-men.html");
		d.manage().window().maximize();
		Thread.sleep(2000);
		d.findElement(By.xpath("(//div[@option-id='168'])[4]")).click();
		Thread.sleep(2000);
		d.findElement(By.xpath("(//div[@option-id='50'])[3]")).click();
		Thread.sleep(2000);
		d.findElement(By.xpath("(//button[@title='Add to Cart'])[4]")).click();

		Thread.sleep(4000);

		d.findElement(By.xpath("//a[@class='action showcart']")).click();
		Thread.sleep(5000);
		d.findElement(By.xpath("//button[@title='Go to Checkout']")).click();

		WebDriverWait w = new WebDriverWait(d, 10000);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("customer-email"))).sendKeys("alok@matrixnmedia.com");

		Thread.sleep(3000);
		d.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Alok");
		d.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Sharma");
		d.findElement(By.xpath("//input[@name='street[0]']")).sendKeys("1010 EASY ST");
		d.findElement(By.xpath("//input[@name='city']")).sendKeys("OTTAWA");
		Select country = new Select(d.findElement(By.name("country_id")));
		country.selectByVisibleText("Canada");
		Select state = new Select(d.findElement(By.name("region_id")));
		state.selectByVisibleText("Ontario");
		d.findElement(By.xpath("//input[@name='postcode']")).sendKeys("K1A 0B1");
		Thread.sleep(3000);
		d.findElement(By.name("telephone")).sendKeys("9056728831");

		Thread.sleep(5000);

		WebElement element1 = d.findElement(By.xpath("//button[@data-role='opc-continue']"));
		((JavascriptExecutor) d).executeScript("arguments[0].scrollIntoView(true);", element1);
		element1.click();

		Thread.sleep(4000);

		d.findElement(By.xpath("//input[@id='cybersourcepaypal']")).click();
		d.findElement(By.xpath("//button[@id='placeOrder']")).click();

		Thread.sleep(30000);
		if (d.findElements(By.xpath("//input[@id='submitLogin']")).size() != 0)
		{

			d.findElement(By.xpath("//input[@name='login_email']")).sendKeys("chrisrduffharper-buyer@gmail.com");
			d.findElement(By.xpath("//input[@name='login_password']")).sendKeys("1967camero");
			d.findElement(By.id("submitLogin")).click();
			Thread.sleep(12000);
			d.findElement(By.xpath("//input[@id='continue_abovefold']")).click();

		}
		else
		{
			Thread.sleep(3000);
			d.switchTo().frame("injectedUl");
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='login_email']"))).sendKeys("chrisrduffharper-buyer@gmail.com");
			d.findElement(By.xpath("//input[@name='login_password']")).sendKeys("1967camero");
			d.findElement(By.id("btnLogin")).click();

			Thread.sleep(13000);
			WebElement element = d.findElement(By.xpath("//input[@id='confirmButtonTop']"));
			((JavascriptExecutor) d).executeScript("arguments[0].scrollIntoView(true);", element);
			element.click();

		}

	}
}
