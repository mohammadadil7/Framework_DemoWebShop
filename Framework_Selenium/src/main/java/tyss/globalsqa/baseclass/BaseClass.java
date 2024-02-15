package tyss.globalsqa.baseclass;

import java.security.PublicKey;
import java.time.LocalDateTime;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseClass {
	public static WebDriver driver;
	public static ExtentTest test;
	public static ExtentReports reports;

	@BeforeClass
	public void browserSetup() {
		driver = new ChromeDriver();

	}

	@BeforeMethod
	public void navigation() {
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");

	}

	@AfterClass
	public void quit() {
		driver.quit();

	}

	@AfterSuite
	public void flushReport() {
		reports.flush();
	}
}
