package maven_cucumber_project.Cucumber_Guru_Scenarios;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import junit.framework.Assert;

public class Test_Guru_Login {
	static WebDriver driver;
	String id;

	@Given("The user is in guru login page")
	public void the_user_is_in_guru_login_page() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\bsekar6\\eclipse-workspace\\Cucumber_Guru_Project\\Cucumber_Guru_Scenarios\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/V4/index.php");
	}

	@When("The user enter valid username and password")
	public void the_user_enter_valid_username_and_password() {
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("mngr162508");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("aqehatY");
	}

	@When("The user clicks the submit button")
	public void the_user_clicks_the_submit_button() {
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}

	@Then("The user should be manager home")
	public void the_user_should_be_manager_home() {
		Assert.assertTrue(driver.getCurrentUrl().contains("Managerhomepage"));
	}

	@Given("The user clicks New customer button")
	public void the_user_clicks_New_customer_button() {
		driver.findElement(By.xpath("//a[text()='New Customer']")).click();
	}

	@When("The user enters the mandatory fields")
	public void the_user_enters_the_mandatory_fields() {
		System.out.println("the user enters the mandatory details");
	}

	@When("The user clicks the submit new register button")
	public void the_user_clicks_the_submit_new_register_button(DataTable Credentials) throws AWTException {
		Map<String, String> credentailsMap = Credentials.asMap(String.class, String.class);
		driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys(credentailsMap.get("customername"));
		List<WebElement> genderOptions = driver.findElements(By.xpath("//input[@type='radio']"));
		for (int i = 0; i < genderOptions.size(); i++) {
			String genValue = genderOptions.get(i).getAttribute("value");
			
		if(genValue.equals("f"))
		{
			genderOptions.get(i).click();
		}
	
		}
		WebElement dob = driver.findElement(By.xpath("//input[@name='dob']"));
		Actions a = new Actions(driver);
		a.doubleClick(dob).build().perform();
		Robot r = new Robot();
		for (int i =0; i < 27;i++)
		{
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
			
		}
		
		r.keyPress(KeyEvent.VK_LEFT);
		r.keyRelease(KeyEvent.VK_LEFT);
		for(int i = 0; i< 30; i++)
		{
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
		}
		
		r.keyPress(KeyEvent.VK_LEFT);
		r.keyRelease(KeyEvent.VK_LEFT);
		for(int i = 0; i< 7; i++)
		{
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
		}
		
		driver.findElement(By.xpath("//textarea[@name='addr']")).sendKeys(credentailsMap.get("address"));
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys(credentailsMap.get("city"));
		driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys(credentailsMap.get("state"));
		driver.findElement(By.xpath("(//input[@type='text'])[4]")).sendKeys(credentailsMap.get("pin"));
		driver.findElement(By.xpath("(//input[@type='text'])[5]")).sendKeys(credentailsMap.get("mobileNum"));
		driver.findElement(By.xpath("(//input[@type='text'])[6]")).sendKeys(credentailsMap.get("email"));
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(credentailsMap.get("password"));
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}

	@Then("The user should be Registered successfully")
	public void the_user_should_be_Registered_successfully() {
 Assert.assertTrue(driver.findElement(By.xpath("//p[text()='Customer Registered Successfully!!!']")).getText().contains("Registered"));
	}
	
	
	@Given("The user get the customer ID")
	public void the_user_get_the_customer_ID() {
	   List<WebElement> tRow = driver.findElements(By.tagName("tr"));
	   List<WebElement> data = tRow.get(4).findElements(By.tagName("td"));
	    id = data.get(1).getText();
	   System.out.println(id);
   
	}

	@Given("The user click on Edit customer button")
	public void the_user_click_on_Edit_customer_button() {
	   driver.findElement(By.xpath("//a[text()='Edit Customer']")).click();
	}

	@When("The user gives the customer ID")
	public void the_user_gives_the_customer_ID() {
	    driver.findElement(By.xpath("//input[@type='text']")).sendKeys(id);
	}

	@When("The user clicks on Submit button")
	public void the_user_clicks_on_Submit_button() {
	   driver.findElement(By.xpath("//input[@type='submit']")).click();
	}

	@When("The user should be in edit customer page")
	public void the_user_should_be_in_edit_customer_page() {
	    Assert.assertTrue(driver.getCurrentUrl().contains("editCustomerPage"));
	}

	@Then("user validate the details and does the change in the details")
	public void user_validate_the_details_and_does_the_change_in_the_details() {
	    driver.findElement(By.xpath("//input[@name='city']")).sendKeys("Athur");
	}

	@Then("clicks on submit")
	public void clicks_on_submit() {
	    driver.findElement(By.xpath("//input[@type='submit']")).click();
	}


}

















