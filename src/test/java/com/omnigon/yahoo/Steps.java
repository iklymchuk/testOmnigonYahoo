package com.omnigon.yahoo;

import static org.hamcrest.MatcherAssert.assertThat;

import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import ru.yandex.qatools.allure.annotations.Step;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@SuppressWarnings("deprecation")
public class Steps {
	
	WebDriver driver;
	long pageLoadTime;
	
	@Before
	public void setUp () {
		driver = new FirefoxDriver();
		driver.manage().timeouts().pageLoadTimeout(20,	TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(20,	TimeUnit.SECONDS);
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}

	@Step("^I am on the yahoo home page$")
	@Given("^I am on the yahoo home page$")
	public void shouldNavigateToYahooSite() throws Throwable {
		driver.get("http://www.yahoo.com/");
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		    long loadEventEnd = (long) js.executeScript("return window.performance.timing.loadEventEnd;");
		    long navigationStart = (long) js.executeScript("return window.performance.timing.navigationStart;");
		    pageLoadTime = (loadEventEnd - navigationStart)/1000;
		assertThat("Incorrect title. Title is: " + driver.getTitle(), driver.getTitle().contains("Yahoo"));
	}
	
	@Step("I click on leftlink")
	@When("^I click on ([^\"]*)$")
	public void shouldClickOnLeftSite(String link) throws Throwable {
		driver.findElement(By.id(link)).click();
	}
	
	@Step("^I check that page has correct title")
	@Then("^I check that page has ([^\"]*)$")
	public void shouldBeCorrectTitle(String title) throws Throwable {
		assertThat("Incorrect title. Title is: " + driver.getTitle(), driver.getTitle().contains(title));
	}
	
	@Step("^I check page load time")
	@And("^I check page load time$")
	public void shouldBePageLoadTimeLessThan_7_Sec() {
		Assert.assertTrue(pageLoadTime<=7);
	}
	
	
}
