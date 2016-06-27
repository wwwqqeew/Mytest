package com.JSON;

public class Point {

	public String latitude;
	public String longitue;
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitue() {
		return longitue;
	}
	public void setLongitue(String longitue) {
		this.longitue = longitue;
	}
	@Override
	public String toString() {
		return "Point [latitude=" + latitude + ", longitue=" + longitue + "]";
	}

	
}
