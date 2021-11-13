package com.revature.workscheduler.testutils;

public class SeleniumHelper
{
	public static void sleepMillis(long millis)
	{
		try
		{
			Thread.sleep(millis);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
