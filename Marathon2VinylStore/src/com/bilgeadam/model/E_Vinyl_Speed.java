package com.bilgeadam.model;

public enum E_Vinyl_Speed {
SLOW("33-rpm"),MEDIUM("45-rpm"),FAST("78-rpm");
	
	private final String value;
	
	private E_Vinyl_Speed(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
	
}
