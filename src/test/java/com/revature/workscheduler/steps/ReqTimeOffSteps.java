package com.revature.workscheduler.steps;

import com.revature.workscheduler.WorkSchedulerRunner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReqTimeOffSteps
{
    @When("User clicks the time off button")
    public void userClicksTheTimeOffButton()
    {
        WorkSchedulerRunner.DRIVER.findElement(By.xpath("/html/body/app-root/div/nav/div/ul/li[2]")).click();
    }

    @Then("User is on the time off screen")
    public void userIsOnTheTimeOffScreen()
    {
        WebElement requestTable = WorkSchedulerRunner.DRIVER.findElement(By.xpath("/html/body/app-root/app-time-off/div[1]/table"));
        Assertions.assertTrue(requestTable.isDisplayed());
    }

    @When("User fills out the time off request form")
    public void userFillsOutTheTimeOffRequestForm()
    {
        WebElement startTime = WorkSchedulerRunner.DRIVER.findElement(By.xpath("/html/body/app-root/app-time-off/div[2]/input[1]"));
        WebElement endTime = WorkSchedulerRunner.DRIVER.findElement(By.xpath("/html/body/app-root/app-time-off/div[2]/input[2]"));
        WebElement submit = WorkSchedulerRunner.DRIVER.findElement(By.xpath("/html/body/app-root/app-time-off/div[2]/button"));

        startTime.sendKeys("12122121" + Keys.ARROW_RIGHT + "1212A");
        endTime.sendKeys("12122121" + Keys.ARROW_RIGHT + "1212A");

        submit.click();
    }

    @Then("The request confirmation is shown")
    public void theRequestConfirmationIsShown()
    {

        Alert alert = new WebDriverWait(WorkSchedulerRunner.DRIVER, 2)
                .until(ExpectedConditions.alertIsPresent());

        Assertions.assertEquals("Request Submitted!",alert.getText());
        alert.dismiss();
    }
}
