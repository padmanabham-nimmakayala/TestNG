package testNG;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownTestNG {
	
	@Test
	public void Drop() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.facebook.com/login/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"login_link\"]/a[2]")).click();
		Select dropdown=new Select(driver.findElement(By.xpath("//*[@id=\"month\"]")));
		List<WebElement> options = dropdown.getOptions();
		int expected_value=12;
		int length = options.size();
		for (int i = 0; i < length; i++) {
			String month = options.get(i).getText();
			System.out.println(month);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			if (month.equalsIgnoreCase("jun")) {
				options.get(i).click();
				
			}
			
         Assert.assertEquals(length, expected_value);
		
	

}
}}