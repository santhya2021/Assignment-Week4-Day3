package week4.day3;

import java.time.Duration;

import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class CreateNewOpportunity {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions apt=new ChromeOptions();
		apt.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.xpath("//input[@name='pw']")).sendKeys("Leaf@123");
		driver.findElement(By.xpath("//input[@name='Login']")).click();
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		Thread.sleep(2000);
		WebElement click = driver.findElement(By.xpath("//span[text()='Opportunities']"));
		driver.executeScript("arguments[0].click()", click);
		driver.findElement(By.xpath("//a[@class='forceActionLink']")).click();
		Thread.sleep(3000);
		WebElement name = driver.findElement(By.xpath("(//div[@class='slds-form-element__control slds-grow']/input)[2]"));
		name.sendKeys("Salesforce Automation By Santhya");
		String oppName = name.getText();
		System.out.println(oppName);
		driver.findElement(By.xpath("(//input[@class='slds-input'])[3]")).sendKeys("4/21/2023");
		
		driver.findElement(By.xpath("//button[contains(@class,'slds-combobox__input slds-input_faux')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@title='Needs Analysis']")).click();
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		Thread.sleep(3000);
		String afterName = driver.findElement(By.xpath("//lightning-formatted-text[text()='Salesforce Automation By Santhya']")).getText();
		System.out.println(afterName);
		if(oppName.equals(afterName))
		{
			System.out.println("Name verified sucessfully");
		}
		else
		{
			System.out.println("Name verification not matched");
		}
		driver.close();
	}

}
