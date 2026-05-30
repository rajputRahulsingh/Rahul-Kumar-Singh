package StepDefination;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AllStepdemoninja {
	WebDriver driver;
	@Given("Home page of tutorialninja is opned")
	public void home_page_of_tutorialninja_is_opned() {
	    // Write code here that turns the phrase above into concrete actions
		  driver = new ChromeDriver();

		    driver.manage().window().maximize();

		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		    driver.get("https://tutorialsninja.com/demo/");
	}

	@When("Click  on my account and register")
	public void click_on_my_account_and_register() {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("(//i[@class='fa fa-user'])[1]")).click();

	    driver.findElement(By.xpath("(//a[normalize-space()='Register'])[1]")).click();

	    }
	

	@And("Enter Your Personal Details")
	public void enter_your_personal_details() {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("(//input[@id='input-firstname'])[1]"))
        .sendKeys("rahul");

driver.findElement(By.xpath("//input[@id='input-lastname']"))
        .sendKeys("singh");

driver.findElement(By.xpath("//input[@id='input-email']"))
        .sendKeys("taxeni6289@nriza.com");

driver.findElement(By.xpath("//input[@id='input-telephone']"))
        .sendKeys("9696672808");

driver.findElement(By.xpath("(//input[@id='input-password'])[1]"))
        .sendKeys("Rahul@12");

driver.findElement(By.xpath("(//input[@id='input-confirm'])[1]"))
        .sendKeys("Rahul@12");

driver.findElement(By.xpath("(//input[@value='0'])[1]")).click();

driver.findElement(By.xpath("(//input[@name='agree'])[1]")).click();

driver.findElement(By.xpath("//input[@value='Continue']")).click();

	}

	@And("Click on login")
	public void click_on_login() {
	    // Write code here that turns the phrase above into concrete actions
		 driver.findElement(By.xpath("(//i[@class='fa fa-user'])[1]")).click();

		    driver.findElement(By.xpath("(//a[normalize-space()='Login'])[1]")).click();

		    driver.findElement(By.xpath("(//input[@id='input-email'])[1]"))
		            .sendKeys("taxeni6289@nriza.com");

		    driver.findElement(By.xpath("//input[@id='input-password']"))
		            .sendKeys("Rahul@12");

		    driver.findElement(By.xpath("//input[@value='Login']")).click();
	}
	

	@And("click on home button")
	public void click_on_home_button() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		 driver.findElement(By.xpath("//i[@class='fa fa-home']")).click();
		 Thread.sleep(3000);
		System.out.println("Click on home button");
	}

	@And("click on add to cart")
	public void click_on_add_to_cart() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		 driver.findElement(By.name("search"))
         .sendKeys("iPhone");

 driver.findElement(
         By.xpath("//button[@class='btn btn-default btn-lg']"))
         .click();

 Thread.sleep(3000);
	}

	@And("again click on add to cart")
	public void again_click_on_add_to_cart() {
	    // Write code here that turns the phrase above into concrete actions
		
		driver.findElement(
		         By.xpath("//button[@class='btn btn-default btn-lg']"))
		         .click();
	}

	@And("click on cart")
	public void click_on_cart() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(
                By.xpath("(//button[contains(@onclick,'cart.add')])[1]"))
                .click();

        Thread.sleep(3000);
        System.out.println("add to cart");
	}

	@And("view cart")
	public void view_cart() {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(
                By.xpath("(//button[contains(@onclick,'cart.add')])[1]"))
                .click();
		
		System.out.println("Cart viewed");
	}

	@Then("click on remove button")
	public void click_on_remove_button() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	      driver.findElement(By.id("cart-total")).click();

	        Thread.sleep(2000);

	        driver.findElement(
	                By.xpath("//button[contains(@title,'Remove')]"))
	                .click();

	        Thread.sleep(3000);
	        
	        System.out.println("Product Removed");
	}

}
