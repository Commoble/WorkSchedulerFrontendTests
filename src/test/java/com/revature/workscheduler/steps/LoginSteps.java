package com.revature.workscheduler.steps;

import com.revature.workscheduler.WorkSchedulerRunner;
import com.sun.corba.se.spi.orbutil.threadpool.Work;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class LoginSteps
{
	@Given("User is on the login screen")
	public void userIsOnTheLoginScreen()
	{
		WorkSchedulerRunner.DRIVER.get("http://localhost:4200/");
	}

	@Given("Non-Manager user has logged in")
	public void nonManagerUserHasLoggedIn()
	{
		this.userIsOnTheLoginScreen();
		WebElement usernameInput = WorkSchedulerRunner.DRIVER.findElement(By.name("username"));
		usernameInput.sendKeys("steveclerk");
		WebElement passwordInput = WorkSchedulerRunner.DRIVER.findElement(By.name("password"));
		passwordInput.sendKeys("stevepassword");
		this.userClicksTheLoginButton();
		// wait for dashboard to show up
		WebElement element = WorkSchedulerRunner.DRIVER.findElement(By.tagName("app-dash-board-screen"));
	}

	@Given("Manager user has logged in")
	public void managerUserHasLoggedIn()
	{
		this.userIsOnTheLoginScreen();
		WebElement usernameInput = WorkSchedulerRunner.DRIVER.findElement(By.name("username"));
		usernameInput.sendKeys("larrymanager");
		WebElement passwordInput = WorkSchedulerRunner.DRIVER.findElement(By.name("password"));
		passwordInput.sendKeys("larrypassword");
		this.userClicksTheLoginButton();
		// wait for dashboard to show up
		WebElement element = WorkSchedulerRunner.DRIVER.findElement(By.tagName("app-dash-board-screen"));
	}

	@When("User types in the correct username")
	public void userTypesInTheCorrectUsername()
	{
		WebElement usernameInput = WorkSchedulerRunner.DRIVER.findElement(By.name("username"));
		usernameInput.sendKeys("larrymanager");
	}

	@When("User types in the correct password")
	public void userTypesInTheCorrectPassword()
	{
		WebElement passwordInput = WorkSchedulerRunner.DRIVER.findElement(By.name("password"));
		passwordInput.sendKeys("larrypassword");
	}

	@When("User presses enter")
	public void userPressesEnter()
	{
		WorkSchedulerRunner.DRIVER.switchTo().activeElement().sendKeys(Keys.ENTER);
	}

	@When("User clicks the login button")
	public void userClicksTheLoginButton()
	{
		// there's only one button on the main screen at the moment
		WorkSchedulerRunner.DRIVER.findElement(By.tagName("button")).click();
	}

	@When("User presses tab")
	public void userPressesTab()
	{
		WorkSchedulerRunner.DRIVER.switchTo().activeElement().sendKeys(Keys.TAB);
	}

	@When("User types in incorrect password")
	public void userTypesInIncorrectPassword()
	{
		WebElement passwordInput = WorkSchedulerRunner.DRIVER.findElement(By.name("password"));
		passwordInput.sendKeys("this is not a password");
	}

	@When("User types in incorrect username")
	public void userTypesInIncorrectUsername()
	{
		WebElement usernameInput = WorkSchedulerRunner.DRIVER.findElement(By.name("username"));
		usernameInput.sendKeys("this is not a username");
	}

	@Then("User is on the main user control screen")
	public void userIsOnTheMainUserControlScreen()
	{
		WebElement logoutButton = WorkSchedulerRunner.DRIVER.findElement(By.tagName("app-dash-board-screen"));
		Assertions.assertNotNull(logoutButton);
	}

	@Then("The password field is focused")
	public void thePasswordFieldIsFocused()
	{
		WebElement passwordInput = WorkSchedulerRunner.DRIVER.findElement(By.name("password"));
		WebElement activeElement = WorkSchedulerRunner.DRIVER.switchTo().activeElement();
		Assertions.assertEquals(passwordInput, activeElement);
	}

	@Then("A login error is displayed")
	public void aLoginErrorIsDisplayed()
	{
		WebElement invalidLoginPrompt = WorkSchedulerRunner.DRIVER.findElement(By.className("invalid-login-prompt"));
		Assertions.assertNotNull(invalidLoginPrompt);
	}

	@Then("Manager options are not present")
	public void managerOptionsAreNotPresent()
	{
		long managerButtons = WorkSchedulerRunner.DRIVER.findElements(By.tagName("button"))
			.stream()
			.filter(element ->
				element.getText().equals("Approve Time Off")
				|| element.getText().equals("Create the Schedule")
			)
			.count();
		Assertions.assertEquals(0L, managerButtons);
	}

	@Then("Manager options are present")
	public void managerOptionsArePresent()
	{
		long managerButtons = WorkSchedulerRunner.DRIVER.findElements(By.tagName("button"))
			.stream()
			.filter(element ->
				element.getText().equals("Approve Time Off")
					|| element.getText().equals("Create the Schedule")
			)
			.count();
		Assertions.assertEquals(2L, managerButtons);
	}
}
