package maven_cucumber_project.Cucumber_Guru_Scenarios;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseMethods {
    WebDriver driver;
	public void options() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\bsekar6\\eclipse-workspace\\Cucumber_Guru_Project\\Cucumber_Guru_Scenarios\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/V4/manager/addcustomerpage.php");
		List<WebElement> genderOptions = driver.findElements(By.xpath("//input[@type='radio']"));
		for (int i = 0; i < genderOptions.size(); i++) {
			String genValue = genderOptions.get(i).getAttribute("value");
			
		if(genValue.equals("m"))
		{
			genderOptions.get(i).click();
		}
		else {
			genderOptions.get(i).click();
		}
		
	}
	
}
}