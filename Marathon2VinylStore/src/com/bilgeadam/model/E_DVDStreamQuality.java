package com.bilgeadam.model;

public enum E_DVDStreamQuality {
SD("SD-480P"),HD("HD-720P"),FHD("FHD-1080P"),UHD("UHD-4K");
	
	private final String value;
	
	private E_DVDStreamQuality(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
}
