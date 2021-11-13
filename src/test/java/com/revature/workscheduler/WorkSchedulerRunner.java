package com.revature.workscheduler;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features", glue="com.revature.workscheduler.steps")
public class WorkSchedulerRunner
{
	private static final Logger LOGGER = LogManager.getLogger();
	public static final WebDriver DRIVER = initDriver();

	@io.cucumber.java.AfterAll
	public static void afterAllCucumber()
	{
		DRIVER.quit();
	}

	private static WebDriver initDriver()
	{
		Properties props = new Properties();
		try (InputStream input = WorkSchedulerRunner.class.getClassLoader().getResourceAsStream("workschedulerfrontendtests.properties"))
		{
			props.load(input);
		}
		catch (IOException e)
		{
			LOGGER.info("No test properties found. If desired, driverpath and drivertype can be specified in src/test/resources/workschedulerfrontendtests.properties");
		}
		String driverPath = props.getProperty("driverpath");
		String driverTypeName = props.getProperty("drivertype");
		if (driverPath == null || driverTypeName == null)
		{
			LOGGER.info("workschedulerfrontendtests.properties missing driverpath or drivertype propertie(s).");
			LOGGER.info("Defaulting to driverpath=C:/Program Files/Selenium/geckodriver.exe and drivertype=FIREFOX");
			driverPath = "C:/Program Files/Selenium/geckodriver.exe";
			driverTypeName = "FIREFOX";
		}

		WebDriverType driverType;

		try
		{
			driverType = WebDriverType.valueOf(driverTypeName);
		}
		catch(IllegalArgumentException e)
		{
			throw new IllegalArgumentException(String.format(
				"Could not evaluate driver type: %s -- allowed values are %s",
				driverTypeName,
				Arrays.toString(WebDriverType.values())
			));
		}

		WebDriver driver = driverType.getDriverStarter().apply(driverPath);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return driver;
	}
}
