package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Loggeduser
{

	public static void main(String[] args) throws InterruptedException
	{
		WebDriver d;
		System.setProperty("webdriver.chrome.driver", "C://Users//Administrator//Downloads//chromedriver_win32//chromedriver.exe");
		d = new ChromeDriver();
		//d = new FirefoxDriver();

		d.navigate().to("http://cybersourcephase02a.van01.collinsharper.com/customer/account/login/");
		d.manage().window().maximize();
		d.findElement(By.xpath("//input[@name='login[username]']")).sendKeys("alok@matrixnmedia.com");
		d.findElement(By.xpath("//input[@name='login[password]']")).sendKeys("alok_123456");
		d.findElement(By.xpath("//button[@id='send2']")).click();

		d.navigate().to("http://cybersourcephase02a.van01.collinsharper.com/men/tops-men.html");

		Thread.sleep(1000);
		d.findElement(By.xpath("(//div[@option-id='168'])[4]")).click();
		Thread.sleep(1000);
		d.findElement(By.xpath("(//div[@option-id='50'])[3]")).click();
		Thread.sleep(1000);
		d.findElement(By.xpath("(//button[@title='Add to Cart'])[4]")).click();

		Thread.sleep(2000);

		d.findElement(By.xpath("//a[@class='action showcart']")).click();
		Thread.sleep(2000);
		d.findElement(By.xpath("//button[@title='Go to Checkout']")).click();

		Thread.sleep(12000);

		WebDriverWait w = new WebDriverWait(d, 20000);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-role='opc-continue']")));

		WebElement element1 = d.findElement(By.xpath("//button[@data-role='opc-continue']"));
		((JavascriptExecutor) d).executeScript("arguments[0].scrollIntoView(true);", element1);
		element1.click();

		Thread.sleep(4000);
		//PayPal r = new PayPal();
		//r.paypal(d);

		//SecureAcceptanceSOP e = new SecureAcceptanceSOP();
		//e.sop(d);

		SopWebMobile t = new SopWebMobile();
		t.sopwm(d);

	}
}