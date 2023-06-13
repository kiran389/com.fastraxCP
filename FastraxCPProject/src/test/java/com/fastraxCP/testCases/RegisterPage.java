package com.fastraxCP.testCases;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fastrax.Base.Base;

public class RegisterPage extends Base{
	WebDriver driver;

	@BeforeMethod
	public void browsersetup() throws InterruptedException {
		loadPropertiesFile();
        driver = initializeAndOpenBrowser(prop.getProperty("browser"));
	}

	@AfterMethod
	public void quitt() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}

	@Test
	public void registerPage() throws InterruptedException {
		driver.findElement(By.xpath("//button[text()='Create an Account']")).click();
		boolean motor=	driver.findElement(By.xpath("(//a[@class='nav-link'])[1]")).isDisplayed();
		System.out.println(motor);
		WebElement motor1=	driver.findElement(By.xpath("(//a[@class='nav-link'])[1]"));
		motor1.click();

		Thread.sleep(2000);
		try {
			driver.findElement(By.cssSelector("*[class='btn btn-primary nextBtn']")).click();
		} catch (Exception e) {
			
			JavascriptExecutor je= (JavascriptExecutor) driver;
			je.executeScript("arguments[0].click();", driver.findElement(By.cssSelector("*[class='btn btn-primary nextBtn']")));
		}
		
		driver.findElement(By.xpath("//input[@id='companyName']")).sendKeys("Techno");
		WebElement dot=driver.findElement(By.xpath("//input[@id='dot']"));
		dot.sendKeys("555");

		WebElement address=driver.findElement(By.xpath("//input[@id='address']"));
		address.sendKeys("KR Puram KL Road Bangalore");

		WebElement city=driver.findElement(By.xpath("//input[@id='city']"));
		city.sendKeys("Bangalore");

		WebElement state=driver.findElement(By.xpath("//input[@id='state']"));
		state.sendKeys("Karnataka");

		WebElement zipcode=driver.findElement(By.xpath("//input[@id='zipCode']"));
		zipcode.sendKeys("560009");
		Thread.sleep(2000);

		try {
			driver.findElement(By.xpath("//*[@type='submit']")).click();
			
		} catch (Exception e) {
			System.out.println("clicked on next");

			JavascriptExecutor je= (JavascriptExecutor) driver;
			je.executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[@type='submit']")));

		}
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Kir");
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Kumar");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("Kirw@zibtek.in");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("1232456");
		driver.findElement(By.xpath("//input[@id='confirmPassword']")).sendKeys("1232456");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Continue to sign in']")).click();
		System.out.println("CLicked on cont....");
		Thread.sleep(3000);
		System.out.println("Register is Done ----> PASSED ");
	}
}
