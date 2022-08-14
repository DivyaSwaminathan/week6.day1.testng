package week6.day1;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
//import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeLeads extends BaseClass {
@Test
	public  void mergeLead() throws InterruptedException {
		wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		driver.findElement(By.linkText("Merge Leads")).click();
		driver.findElement(By.xpath("//span[text()='From Lead']/following::a[1]")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowHandleslst=new ArrayList<String>(windowHandles);
		String secondWindow=windowHandleslst.get(1);
		driver.switchTo().window(secondWindow);
		driver.findElement(By.name("firstName")).sendKeys("Babu");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	
		// webele = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"));
	try {
		WebElement webele = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"));
	
		webele.click();
		}catch (NoSuchElementException e) {
			System.out.println("click failed due to noSuchElemet  exception ");
			Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"))));
			driver.findElement(By.xpath("//a[@class='linktext'][1]")).click();
			
			
		}
		String firstWindow=windowHandleslst.get(0);
		driver.switchTo().window(firstWindow);
		String title = driver.getTitle();
		System.out.println(title);
		
		

	}

}
