package steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleStep {
	WebDriver driver;
	
	@Given("user navigates to Google website")
	public void user_navigates_to_google_website() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.google.com");
		System.out.println("hello");
	}
	@When("user validate Google title")
	public void user_validate_google_title() {
		//google title
		String actualTitle = driver.getTitle();
		String expectedTitle = "Google";
		Assert.assertEquals(actualTitle, expectedTitle);
		//google logo
		Boolean flag = driver.findElement(By.className("lnXdpd")).isDisplayed();
		Assert.assertTrue(flag);
	}
	@Then("user close Google browser")
	public void user_close_google_browser() {
		driver.quit();
	}

}
