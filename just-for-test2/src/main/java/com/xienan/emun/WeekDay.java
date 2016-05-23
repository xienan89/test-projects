package com.xienan.emun;

public enum WeekDay {
	Mon("mon"), 
	Tue("t"), 
	Wed("a"), 
	Thu("b"), 
	Fri("dfsd"), 
	Sat("c"), 
	Sun("d");
	
	private String weedDay;

	public String getWeedDay() {
		return weedDay;
	}

	public void setWeedDay(String weekDay){
		this.weedDay = weekDay;
	}
	
	private WeekDay(String weedDay) {
		this.weedDay = weedDay;
	}
	
	@Override
	public String toString() {
		return getWeedDay();
	}
}
