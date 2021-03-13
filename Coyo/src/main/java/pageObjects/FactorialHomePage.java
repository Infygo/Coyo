package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FactorialHomePage {
	
	public WebDriver driver;
	
	public FactorialHomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By inputBox   = By.xpath("//input[@id='number']");
	private By calculate  = By.xpath("//button[@id='getFactorial']");
	private By factResult = By.cssSelector("div[class='col-md-6 col-md-offset-3'] p:nth-child(1)"); //By.xpath("//p[@id='resultDiv']");
	
	public WebElement InputBox() {
		return driver.findElement(inputBox);
	}
	
	public WebElement Calculate() {
		return driver.findElement(calculate);
	}
	
	public WebElement getResult() {
		return driver.findElement(factResult);
	}

}
