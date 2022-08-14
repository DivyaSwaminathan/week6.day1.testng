package week6.day1;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead extends BaseClass{
@Test(invocationCount=2)
	public  void createLead() throws InterruptedException {
		
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("VzCompany");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Divya",Keys.TAB,"Swaminathan");
		Thread.sleep(3000);
		//driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Swaminathan");
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Tester");
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Quality Assurance");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Test lead who confirms testing quality of products");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("mynewemail@gmail.com");
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("5632169854");
		WebElement state = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select stateDropdown1= new Select(state);
		stateDropdown1.selectByVisibleText("New York");
		driver.findElement(By.className("smallSubmit")).click();
		String title = driver.getTitle();
		if(title.contains("View Lead")) {
			System.out.println("Create Lead is Successful");
		}


	}
}