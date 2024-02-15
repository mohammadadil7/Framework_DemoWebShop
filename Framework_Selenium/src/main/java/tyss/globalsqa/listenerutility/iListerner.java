package tyss.globalsqa.listenerutility;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;

import tyss.globalsqa.baseclass.BaseClass;

public class iListerner extends BaseClass implements ITestListener {
	public void onTestFailure(ITestListener result) throws Throwable {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File ss = ts.getScreenshotAs(OutputType.FILE);
		File file = new File("./target.ss.png");
		org.openqa.selenium.io.FileHandler.copy(ss, file);
		// test.addScreenCaptureFromBase64String(ss);

	}

}
