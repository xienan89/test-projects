package com.xienan.emun;

public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WeekDay weekDay = WeekDay.Fri;
		WeekDay weekDay1 = WeekDay.Fri;
		System.out.println(WeekDay.Mon);
		System.out.println(weekDay.getWeedDay());
		if (weekDay.equals(weekDay1)) {
			System.out.println("yes");
		}		
		
	}

}
