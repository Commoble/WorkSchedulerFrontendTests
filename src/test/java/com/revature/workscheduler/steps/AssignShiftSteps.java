package com.revature.workscheduler.steps;

import com.revature.workscheduler.WorkSchedulerRunner;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AssignShiftSteps
{

    @When("The manager clicks create new schedule")
    public void theManagerClicksCreateNewSchedule()
    {
        WorkSchedulerRunner.DRIVER.findElement(By.xpath("/html/body/app-root/div/nav/div/ul/p/li[2]")).click();
    }

    @And("The manager selects a shift type and employee and clicks add shift")
    public void theManagerSelectsAShiftTypeAndEmployeeAndClicksAddShift()
    {
        Select shiftDropDown = new Select(WorkSchedulerRunner.DRIVER.findElement(By.xpath("//*[@id=\"shiftSelect0\"]")));
        Select empDropDown = new Select(WorkSchedulerRunner.DRIVER.findElement(By.xpath("//*[@id=\"empSelect0\"]")));
        WebElement addShiftBtn = WorkSchedulerRunner.DRIVER.findElement(By.xpath("/html/body/app-root/app-create-schedule/div/table[1]/tbody/tr/td[1]/div[1]/button"));

        shiftDropDown.selectByIndex(0);
        empDropDown.selectByIndex(0);

        addShiftBtn.click();
    }

    @Then("the shift should be added")
    public void theShiftShouldBeAdded()
    {
        WebElement shift = WorkSchedulerRunner.DRIVER.findElement(By.xpath("/html/body/app-root/app-create-schedule/div/table[1]/tbody/tr/td[1]/div[2]"));
        Assertions.assertNotNull(shift);
    }
}
