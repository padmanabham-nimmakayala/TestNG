import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.DataFormatter;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;

import org.testng.annotations.BeforeSuite;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataproviderExcel {
	WebDriver driver;

	@BeforeSuite
	public void InitialiseBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.navigate().to("https://www.instagram.com/?hl=en");
		driver.manage().window().fullscreen();
	}

	@AfterSuite
	public void Exit() {
		driver.close();

	}

	@Test(dataProvider = "details")
	public void data(String username, String password) {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[contains(@name,'username')]")).sendKeys(username);
		driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div[2]/div/label/input")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div[3]")).click();

	}

	@DataProvider
	public Object[][] details() throws Exception {
		FileInputStream file = new FileInputStream("C:\\Users\\prade\\Desktop\\Padmanabham.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet sheet = wb.getSheet("Sheet1");
		int rowcount = sheet.getPhysicalNumberOfRows();
		int columncount = sheet.getRow(0).getLastCellNum();
		String data[][] = new String[rowcount - 1][columncount];
		for (int i = 0; i < rowcount - 1; i++) {
			for (int j = 0; j < columncount; j++) {
				DataFormatter df = new DataFormatter();
				data[i][j] = df.formatCellValue(sheet.getRow(i + 1).getCell(j));
			}
		}
		return data;

	}
}