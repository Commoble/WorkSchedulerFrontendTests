package com.revature.workscheduler;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features", glue="com.revature.workscheduler.steps")
public class WorkSchedulerRunner
{

}
