/**
 * 
 */
package stepDefinitions;

import resources.Base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.FactorialHomePage;

/**
 * @author vravindran
 *
 */
public class StepDef extends Base {
	private static Logger log = LogManager.getLogger(StepDef.class.getName());
	FactorialHomePage factHomePage;

	@Given("^Initialise driver and navigate to factorial home page$")
	public void initialise_driver_and_navigate_to_factorial_home_page() throws Throwable {
		driver = initialiseDriver();
		driver.get(props.getProperty("homeurl"));
		factHomePage = new FactorialHomePage(driver);

	}

	@Given("^Input an integer (.+) in the input box$")
    public void input_an_integer_in_the_input_box(String factNumber) throws Throwable {
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='number']")));
		factHomePage.InputBox().sendKeys(factNumber);
		log.info("Number given for which factorial is to be calculated");
	}


	@When("^User clicks Calculate button$")
	public void user_clicks_calculate_button() throws Throwable {
		factHomePage.Calculate().click();
		Thread.sleep(2000);
	}

	@Then("^Factorial of (.+) is calculated$")
	public void factorial_of_is_calculated(String number) throws Throwable {
		w.until(ExpectedConditions.visibilityOf(factHomePage.getResult()));
		Assert.assertTrue(factHomePage.getResult().getText().contains("The factorial of " + number + " is:"));
		log.info("Factorial of the input number is calculated");
		//System.out.println(factHomePage.getResult().getText());
	}

	@And("^Close the browser$")
	public void close_the_browser() throws Throwable {
		log.info("Closing the browser");
		driver.quit();

	}

}
