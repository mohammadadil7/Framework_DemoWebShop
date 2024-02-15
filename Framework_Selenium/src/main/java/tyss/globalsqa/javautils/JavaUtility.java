package tyss.globalsqa.javautils;

import java.time.LocalDateTime;

public class JavaUtility {
	public String getDateandTime() {
		String time = LocalDateTime.now().toString().replace(":", "-");
		return time;
	}
    public void get() {
		
	}
}
