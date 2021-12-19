package com.bilgeadam.model;

public enum E_Vinyl_Diameter {

	SMALL("7-inch"),MEDIUM("10-inch"),LARGE("12-inch");
	
	private final String value;
	
	private E_Vinyl_Diameter(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
}
