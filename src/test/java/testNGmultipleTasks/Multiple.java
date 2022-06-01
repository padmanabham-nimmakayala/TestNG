package testNGmultipleTasks;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Multiple {
	@Test
	public void flipkart() {
		System.out.println("this is first");
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.navigate().to("https://www.flipkart.com/");
    driver.manage().window().fullscreen();
    driver.findElement(By.xpath("/html/body/div[2]/div/div/button")).click();
    driver.findElement(By.xpath("//input[contains(@name,'q')]")).sendKeys("samsung");
    driver.findElement(By.className("L0Z3Pu")).click();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    System.out.println(driver.getTitle());
    System.out.println(driver.getCurrentUrl());
    driver.close();
}
	@Test
public void mousehover() {
		System.out.println("this is second");
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.navigate().to("https://www.flipkart.com/");
    driver.manage().window().fullscreen();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.findElement(By.xpath("/html/body/div[2]/div/div/button")).click();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    Actions action=new Actions(driver);
    action.moveToElement(driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[2]/div/div/div[5]/a/div[2]/div/div"))).perform();
    
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.findElement(By.xpath("//a[contains(@href,'view-all&cid=34WHNYFH5V2Y')]")).click();
}
}