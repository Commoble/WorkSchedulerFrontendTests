package com.revature.workscheduler.steps;

import com.revature.workscheduler.WorkSchedulerRunner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ViewScheduleSteps
{
    @When("the user clicks the view schedule tab")
    public void theUserClicksTheViewScheduleTab()
    {
        WorkSchedulerRunner.DRIVER.findElement(By.xpath("/html/body/app-root/div/nav/div/ul/li[3]")).click();
    }

    @Then("the users is on the work schedule page")
    public void theUsersIsOnTheWorkSchedulePage()
    {
        WebElement scheduleTable = WorkSchedulerRunner.DRIVER.findElement(By.xpath("/html/body/app-root/app-view-schedule/div/table[1]/thead/tr/th[1]"));
        Assertions.assertTrue(scheduleTable.isDisplayed());
    }
}
