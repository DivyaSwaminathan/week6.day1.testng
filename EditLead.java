package week6.day1;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead extends BaseClass{
@Test(dependsOnMethods= { "week6.day1.CreateLead.createLead"})
	public  void editLead() throws InterruptedException {
		
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("Divya");
		driver.findElement(By.xpath("//em/button[text()='Find Leads']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first ']//a")).click();
		String title = driver.getTitle();
		System.out.println("The title of the page is " + title);
		driver.findElement(By.xpath("(//a[contains(text(),'Edit')])")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("(//input[@name='companyName'])[2]")).clear();
		driver.findElement(By.xpath("(//input[@name='companyName'])[2]")).sendKeys("Edited companyname");
		driver.findElement(By.xpath("//input[@Value='Update']")).click();
		String newName = driver.findElement(By.xpath("//span[@id='viewLead_companyName_sp']")).getText();
		System.out.println(newName);
		if(newName.contains("Edited companyname")) {
			System.out.println("Edit lead is successful");}
		else {
			System.out.println("unable to update company name");
		}
		
		
	}

}
