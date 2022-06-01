import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dataprovider {
	@Test(dataProvider="details")
	public void data(String username,String password) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.instagram.com/?hl=en");
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[contains(@name,'username')]")).sendKeys(username);
		driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div[2]/div/label/input")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div[3]")).click();
		driver.close();

}   @DataProvider 
	public Object[][]details(){
		String data[][]= {{"papapappa","132456"},{"hsjklop","6789000"}};
		return data;
		
	}
	
	
	
	
}