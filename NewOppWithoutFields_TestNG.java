package week4.day3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class NewOppWithoutFields_TestNG
{

	@Test
	public void newOpp() throws InterruptedException
	{
		ChromeOptions apt=new ChromeOptions();
		apt.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.xpath("//input[@name='pw']")).sendKeys("Leaf@123");
		driver.findElement(By.xpath("//input[@name='Login']")).click();
		//apt.addArguments("--disable-notifications");
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		Thread.sleep(2000);
		WebElement click = driver.findElement(By.xpath("//span[text()='Opportunities']"));
		driver.executeScript("arguments[0].click()", click);
		driver.findElement(By.xpath("//a[@class='forceActionLink']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@class='slds-input'])[3]")).sendKeys("4/23/2023");
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		String checkMsg = driver.findElement(By.xpath("//div[@class='genericNotification']")).getText();
		if(checkMsg.contains("Review the following fields"))
		{
			System.out.println("Error message has appeared: "+"\n"	+checkMsg);

		}
		else
		{
			System.out.println("warning not appeared");

		}
	}
}
