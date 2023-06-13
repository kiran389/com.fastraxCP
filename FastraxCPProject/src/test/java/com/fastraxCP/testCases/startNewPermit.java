package com.fastraxCP.testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fastrax.Base.Base;

public class startNewPermit extends Base {
	WebDriver driver;
	
//	dont initialize @beforemethod multiple times & initialize anywhere in the scipt
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


	@Test(priority = 1)
	public void startnewPermit() throws InterruptedException {
		Thread.sleep(4000);
		
		WebElement username=driver.findElement(By.xpath("//input[@id=\"exampleInputEmail1\"]"));
		username.sendKeys(prop.getProperty("validemail"));

		WebElement password = driver.findElement(By.xpath("//input[@id=\"exampleInputPassword1\"]"));
		password.sendKeys(prop.getProperty("validpassword"));
		Thread.sleep(2000);

		WebElement checkbox =driver.findElement(By.xpath("//input[@id='exampleCheck1']"));
		checkbox.click();
		Thread.sleep(2000);

		WebElement continuee = driver.findElement(By.xpath("//button[contains(text(),'Continue')]"));
		continuee.click();
		Thread.sleep(2000);
		WebElement StartNewPermit=driver.findElement(By.xpath("//button[contains(text(),' Start New Permit ')]"));
		StartNewPermit.click();
		System.out.println("The module name is ->"+StartNewPermit.getText());
		Thread.sleep(2000);

		WebElement dropdown = driver.findElement(By.xpath("//mat-select[@formcontrolname='permitType']"));
		dropdown.click();
		WebDriverWait waitSec = new WebDriverWait(driver,Duration.ofSeconds(60));

		WebElement web = waitSec.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#mat-option-47")));
		web.click();
		//	or selcect any dropdown by using below xpath
		//		driver.findElement(By.xpath("//mat-option[@id='mat-option-47']")).click();

		driver.findElement(By.cssSelector(".mat-focus-indicator.mat-icon-button.mat-button-base")).click();
		//          (or)
		//		driver.findElement(By.xpath("//button[@aria-label='Open calendar']")).click();
		driver.findElement(By.xpath("//button[@aria-label='Choose month and year']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//td[@aria-label='2023']")).click();

		driver.findElement(By.xpath("//td[@aria-label='July 2023']")).click();
		driver.findElement(By.xpath("//td[@aria-label='July 25, 2023']")).click();
		WebElement ack = driver.findElement(By.xpath("//div[6]/textarea[@formcontrolname='acknowledgement']"));
		ack.click();
		ack.sendKeys("Hey! this is automation script for main page");

		driver.findElement(By.xpath("//input[@id='flexCheckDefault']")).click();

		//if checkbox selected it print (True) else (False)
		Boolean bool= driver.findElement(By.xpath("//input[@id='flexCheckDefault']")).isSelected();
		System.out.println(bool);

		if(driver.findElement(By.xpath("//input[@id='flexCheckDefault']")).isSelected()){
			System.out.println("Main Page checkbox is selected");
		}else {
			System.out.println("not selected");
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(text(),'Next')]")).click();

		//		Company Details Page
		WebElement companyName=driver.findElement(By.xpath("//input[@formcontrolname='companyName']"));
		companyName.click();
		companyName.clear();
		Thread.sleep(2000);
		companyName.sendKeys("zibtek");

		Thread.sleep(2000);
		WebElement street= driver.findElement(By.xpath("//*[@formcontrolname='street']"));
		street.click();
		street.clear();
		street.sendKeys("#10 pipe lane kumbarapete - Bangalore");

		Thread.sleep(2000);
		WebElement city= driver.findElement(By.xpath("//*[@formcontrolname='city']"));
		city.click();
		city.clear();
		city.sendKeys("Bangalore");

		Thread.sleep(2000);
		WebElement state= driver.findElement(By.xpath("//*[@formcontrolname='state']"));
		state.click();
		state.clear();
		state.sendKeys("Karnataka");

		Thread.sleep(2000);
		WebElement zipcode= driver.findElement(By.xpath("//*[@formcontrolname='zipCode']"));
		zipcode.click();
		zipcode.clear();
		zipcode.sendKeys("560009");

		Thread.sleep(2000);
		WebElement name= driver.findElement(By.xpath("//*[@formcontrolname='name']"));
		name.click();
		name.clear();
		name.sendKeys("Raju");

		Thread.sleep(2000);
		WebElement phone= driver.findElement(By.xpath("//*[@formcontrolname='phone']"));
		phone.click();
		phone.clear();
		phone.sendKeys("9658769098");
		phone.getText();

		Thread.sleep(2000);
		WebElement email= driver.findElement(By.xpath("//*[@formcontrolname='email']"));
		email.click();
		email.clear();
		email.sendKeys("kiran@zibtek.in");

		WebElement referenceNote= driver.findElement(By.name("refrenceNote"));
		referenceNote.click();
		referenceNote.sendKeys("Hey! this is the automation script for Comapny Details Page");

		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(text(),'Next')]")).click();

		Thread.sleep(2000);
		WebElement load= driver.findElement(By.xpath("//input[@formcontrolname='loadDescription']"));
		load.click();
		load.clear();
		load.sendKeys("Kiran Load");

		Thread.sleep(2000);
		WebElement savedunits= driver.findElement(By.xpath("//a[@class='btn btn-primary savedUnits']"));
		savedunits.click();
		driver.findElement(By.xpath("//tbody/tr/td[contains(text(),'India')]")).click();
		Thread.sleep(2000);               
		driver.findElement(By.xpath("//button[contains(text(),'Confirm')]")).click();

		driver.findElement(By.xpath("//input[@id='lengthFeet']")).sendKeys("222");
		driver.findElement(By.xpath("//input[@id='lengthInches']")).sendKeys("22");
		driver.findElement(By.xpath("//input[@id='widthFeet']")).sendKeys("200");
		driver.findElement(By.xpath("//input[@id='widthInches']")).sendKeys("200");
		driver.findElement(By.xpath("//input[@id='heightFeet']")).sendKeys("250");
		driver.findElement(By.xpath("//input[@id='heightInches']")).sendKeys("25");
		driver.findElement(By.xpath("//input[@id='trailerLengthFeet']")).sendKeys("300");
		driver.findElement(By.xpath("//input[@id='trailerLengthInches']")).sendKeys("30");
		driver.findElement(By.xpath("//input[@id='frontOverhangFeet']")).sendKeys("400");
		driver.findElement(By.xpath("//input[@id='frontOverhangInches']")).sendKeys("40");
		driver.findElement(By.xpath("//input[@id='rearOverhangFeet']")).sendKeys("40");
		driver.findElement(By.xpath("//input[@id='rearOverhangInches']")).sendKeys("40");
		driver.findElement(By.xpath("//input[@id='noOfAxile']")).sendKeys("3");

		driver.findElement(By.xpath("(//input[@formcontrolname='nAxles'])[1]")).sendKeys("02");
		driver.findElement(By.xpath("(//input[@formcontrolname='weight'])[1]")).sendKeys("10");
		driver.findElement(By.xpath("(//input[@formcontrolname='nAxles'])[2]")).sendKeys("03");
		driver.findElement(By.xpath("(//input[@formcontrolname='weight'])[2]")).sendKeys("20");
		driver.findElement(By.xpath("(//input[@formcontrolname='nAxles'])[3]")).sendKeys("04");
		driver.findElement(By.xpath("(//input[@formcontrolname='weight'])[3]")).sendKeys("30");

		WebElement total_no_Of_axles= driver.findElement(By.xpath("//input[@formcontrolname='totalAxies']"));
		String totalvalue1= total_no_Of_axles.getAttribute("value");
		System.out.println("Total Number of axles is "+totalvalue1);
		Thread.sleep(2000);

		WebElement total_weight = driver.findElement(By.xpath("//input[@formcontrolname='totalweight']"));
		String totalvalue2= total_weight.getAttribute("value");
		System.out.println("Total Gross Weight is "+totalvalue2);
		Thread.sleep(2000);

		driver.findElement(By.xpath("(//input[@id='axelFeet'])[1]")).sendKeys("11");
		driver.findElement(By.xpath("(//input[@id='axelInches'])[1]")).sendKeys("11");
		driver.findElement(By.xpath("(//input[@id='axelFeet'])[2]")).sendKeys("21");
		driver.findElement(By.xpath("(//input[@id='axelInches'])[2]")).sendKeys("22");
		driver.findElement(By.xpath("(//input[@id='axelFeet'])[3]")).sendKeys("31");
		driver.findElement(By.xpath("(//input[@id='axelInches'])[3]")).sendKeys("32");
		driver.findElement(By.xpath("(//input[@id='axelFeet'])[4]")).sendKeys("41");
		driver.findElement(By.xpath("(//input[@id='axelInches'])[4]")).sendKeys("42");
		driver.findElement(By.xpath("(//input[@id='axelFeet'])[5]")).sendKeys("51");
		driver.findElement(By.xpath("(//input[@id='axelInches'])[5]")).sendKeys("52");
		driver.findElement(By.xpath("(//input[@id='axelFeet'])[6]")).sendKeys("61");
		driver.findElement(By.xpath("(//input[@id='axelInches'])[6]")).sendKeys("62");
		driver.findElement(By.xpath("(//input[@id='axelFeet'])[7]")).sendKeys("71");
		driver.findElement(By.xpath("(//input[@id='axelInches'])[7]")).sendKeys("72");
		driver.findElement(By.xpath("(//input[@id='axelFeet'])[8]")).sendKeys("81");
		driver.findElement(By.xpath("(//input[@id='axelInches'])[8]")).sendKeys("82");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(text(),'Next')]")).click();
		System.out.println("The Load Page has been completed");
		System.out.println("Clicked on Next page in load page");

		//		to click on saved routes
		WebElement clickon_savedRoute = driver.findElement(By.xpath("//div[@class='save-btn']/a[contains(text(),' Saved Routes')]"));
		clickon_savedRoute.click();

		WebElement selectsaved_Route = driver.findElement(By.xpath("//tbody/tr/td[contains(text(),'Kiran Route')]"));
		selectsaved_Route.click();

		Thread.sleep(2000);
		WebElement clickon_confirm= driver.findElement(By.xpath("(//button[contains(text(),'Confirm')])[1]"));
		clickon_confirm.click();
		WebElement RefNote = driver.findElement(By.xpath("//textarea[@formcontrolname='referenceNote']"));
		RefNote.sendKeys("Hey! this is the automation script for Rourte");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[contains(text(),'Next')]")).click();
		System.out.println("Route page is successfully completed & clicked on Next");

		//		save to draft
		driver.findElement(By.xpath("//button[contains(text(),'Save to Drafts')]")).click();
		System.out.println("Successfully saved to draft");

		//click on Permit Drafts
		driver.findElement(By.xpath("//button[contains(text(),' Permit Drafts ')]")).click();

		Thread.sleep(3000);
		WebElement view_button = driver.findElement(By.xpath("//table/tbody/tr/td[contains(text(),' 2023-00416')]//following-sibling::td[contains(text(),'View')]"));
		view_button.click();
		Thread.sleep(2000);

		JavascriptExecutor je = (JavascriptExecutor)driver;

		WebElement scroll = driver.findElement(By.xpath("//label[contains(text(),'Permit Cost')]"));
		Thread.sleep(3000);
		je.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", scroll);
		Thread.sleep(3000);
		WebElement scroll1= driver.findElement(By.xpath("//label[contains(text(),'Permit Details')]"));
		je.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'end' });", scroll1);
		Thread.sleep(3000);

		driver.findElement(By.xpath("//mat-icon[contains(text(),'close')]")).click();
		System.out.println("Permit View and Scroll function are done");
		WebElement clickContinue_onDraft = driver.findElement(By.xpath("//tbody/tr/td[contains(text(),' 2023-00922')]//following-sibling::td[contains(text(),'Continue')]"));
		clickContinue_onDraft.click();
		Thread.sleep(3000);
		WebElement Next_mainpage =  driver.findElement(By.xpath("//form/div/div[8]/button[contains(text(),'Next')]"));
		Next_mainpage.click();
		//		(or) //button[contains(text(),'Next')]

		Thread.sleep(3000);
		WebElement Next_company = driver.findElement(By.xpath("//button[contains(text(),'Next')]"));
		Next_company.click();
		//		(or) //button[contains(text(),'Next')]

		Thread.sleep(3000);
		WebElement Next_loadpage = driver.findElement(By.xpath("//form/div/div[12]/div[1]/div[1]/button[contains(text(),'Next')]"));
		Next_loadpage.click();
		//		(or) //button[contains(text(),'Next')]

		Thread.sleep(3000);
		WebElement Next_route = driver.findElement(By.xpath("//form/div/div[13]/div[1]/button[contains(text(),'Next')]"));
		Next_route.click();
		//		(or) //button[contains(text(),'Next')]

	}

	@Test(priority = 2)
	public void sample() throws InterruptedException {
		WebElement username=driver.findElement(By.xpath("//input[@id=\"exampleInputEmail1\"]"));
		username.sendKeys(prop.getProperty("validemail")); 
		WebElement password = driver.findElement(By.xpath("//input[@id=\"exampleInputPassword1\"]"));
		password.sendKeys(prop.getProperty("validpassword")); 
		WebElement checkbox = driver.findElement(By.xpath("//input[@id='exampleCheck1']"));
		checkbox.click(); 
		WebElement continuee = driver.findElement(By.xpath("//button[contains(text(),'Continue')]"));
		continuee.click();
		driver.findElement(By.xpath("//button[contains(text(),' Permit Drafts ')]")).click();
		Thread.sleep(3000);

		//search and click on element, if not click on next page & search for ele.
		int maxPages = 4; // Maximum number of pages to check

		try {
			WebElement element = findElementOnPage(driver);
			Thread.sleep(3000);
			element.click();
		} catch (NoSuchElementException e) {
			System.out.println("Element not found on the first page");

			for (int page = 2; page <= maxPages; page++) {
				System.out.println("Navigating to page " + page);
				driver.findElement(By.xpath("(//div/button[@aria-label='Next page'])[5]")).click();

				try {
					WebElement element = findElementOnPage(driver);
					Thread.sleep(3000);
					element.click();
					System.out.println("Element is found on the page "+page);
					break;
				} catch (NoSuchElementException ex) {
					System.out.println("Element not found on page " + page);
				}
			}
		}
		JavascriptExecutor je1 = (JavascriptExecutor)driver;

		WebElement scroll = driver.findElement(By.xpath("//label[contains(text(),'Permit Cost')]"));
		Thread.sleep(3000);
		je1.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", scroll);
		Thread.sleep(3000);
		WebElement scroll1= driver.findElement(By.xpath("//label[contains(text(),'Permit Details')]"));
		je1.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'end' });", scroll1);
		Thread.sleep(3000);

		driver.findElement(By.xpath("//mat-icon[contains(text(),'close')]")).click();
	}

	private static WebElement findElementOnPage(WebDriver driver) {
		return driver.findElement(By.xpath("//table/tbody/tr/td[contains(text(),' 2023-00075')]//following-sibling::td[contains(text(),'View')]"));
	}
}













