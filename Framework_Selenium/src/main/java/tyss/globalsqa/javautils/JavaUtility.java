package tyss.globalsqa.javautils;

import java.io.FileInputStream;
import java.time.LocalDateTime;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class JavaUtility {
	public String getDateandTime() {
		String time = LocalDateTime.now().toString().replace(":", "-");
		return time;
	}

	public Sheet getLoginCredentialsExcelSheet() throws Throwable {
		FileInputStream fis = new FileInputStream("./src/main/resources/DemoWebShop_Testdata.xlsx");

		Workbook workbook = WorkbookFactory.create(fis);

		Sheet loginCredentialsExcelSheet = workbook.getSheet("Sheet1");
		return loginCredentialsExcelSheet;

	}

	public Properties getProprtiesFileData() throws Throwable {
		FileInputStream fis = new FileInputStream("./src/main/resources/DemoWebShop_Testdata.properties");

		Properties properties = new Properties();
		properties.load(fis);
		return properties;

	}
}
