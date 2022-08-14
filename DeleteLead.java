package week6.day1;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead extends BaseClass{
@Test(dependsOnMethods="week6.day1.CreateLead.createLead")
	public  void deleteLead() throws InterruptedException {
	
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("(//label[contains(text(),'Phone Number')])[4]/following::input[@name='phoneNumber']")).sendKeys("5632169854");
		driver.findElement(By.xpath("//em/button[text()='Find Leads']")).click();
		String text = driver.findElement(By.xpath("(//div[contains(text(),'5632169854')])[1]/preceding::div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
		System.out.println("Lead ID of 1st Lead : " + text);
		driver.findElement(By.xpath("(//div[contains(text(),'5632169854')])[1]/preceding::div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.findElement(By.xpath("//a[text()='Delete']")).click();
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(text);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(300);
		String message = driver.findElement(By.xpath("//div[@class='x-paging-info']")).getText();
		//System.out.println(message);
		if (message.contains("No records")) {
			System.out.println("Delete Lead is Successful");
		}
		else {
			System.out.println("It is unsuccessful");
		}



	}

}
