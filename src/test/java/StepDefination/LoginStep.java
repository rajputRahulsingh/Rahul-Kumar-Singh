package StepDefination;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStep {
	WebDriver driver;
	@Given("login page should be open in default browse")
	public void login_page_should_be_open_in_default_browse() {
	    // Write code here that turns the phrase above into concrete actions
	
		  driver = new ChromeDriver();

	        driver.manage().window().maximize();

	        driver.manage().timeouts()
	              .implicitlyWait(Duration.ofSeconds(10));

	        driver.get("http://zero.webappsecurity.com/login.html");

	        System.out.println("Login page opened");}

	@When("click on username field and add valid user username")
	public void click_on_username_field_and_add_valid_user_username() {
	    // Write code here that turns the phrase above into concrete actions
		 driver.findElement(By.id("user_login"))
         .sendKeys("username");

   System.out.println("Username entered");
	}

	@And("then click on password button and enter valid password")
	public void then_click_on_password_button_and_enter_valid_password() {
	    // Write code here that turns the phrase above into concrete actions

		  driver.findElement(By.id("user_password"))
          .sendKeys("password");

    System.out.println("Password entered");
	}

	@And("now click on submit button")
	public void now_click_on_submit_button() {
	
		// Write code here that turns the phrase above into concrete actions
	
		  driver.findElement(By.name("submit"))
          .click();

    System.out.println("Login button clicked");
	}

	@Then("login successfully and redirect to home page")
	public void login_successfully_and_redirect_to_home_page() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Login successfully done"); driver.quit();
	}
}
