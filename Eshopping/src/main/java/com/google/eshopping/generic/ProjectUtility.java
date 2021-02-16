package com.google.eshopping.generic;

public class ProjectUtility {
	/**
	 * 
	 * @param seconds provide the number in seconds 
	 */
	public static void sleepInSeconds(long seconds) {
		try {
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
