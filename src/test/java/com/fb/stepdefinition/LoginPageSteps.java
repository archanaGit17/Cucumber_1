package com.fb.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginPageSteps 
{
static WebDriver driver;
@Given("User is on facebook page")
public void user_is_on_facebook_page() {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\subbian\\eclipse-workspace\\Arch\\CucumberClass\\driver\\chromedriver.exe");
    driver=new ChromeDriver();
	driver.get("http://www.adactin.com/HotelApp/");
}

@When("User enters crendentials and click the login button")
public void user_enters_crendentials_and_click_the_login_button() 
{
   WebElement user=driver.findElement(By.id("username"));
   user.sendKeys("archana");
   WebElement  pwd=driver.findElement(By.id("password"));
   pwd.sendKeys("123456");
   WebElement  btn=driver.findElement(By.id("login"));
   btn.click();
}

@Then("Verify url contains login_attempt")
public void verify_url_contains_login_attempt() 
 {
	 WebElement user=driver.findElement(By.xpath("//b[contains(text(),'Invalid Login details')]"));
	 String url=user.getText();
	
    //String url=driver.getCurrentUrl();
    boolean b=url.contains("Invalid Login details");
    Assert.assertTrue(b);  
 }
}
