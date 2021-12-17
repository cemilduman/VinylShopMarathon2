package com.bilgeadam.dto;


public class StorageMedium {
	
	public enum Size{
		SMALL, MEDIUM, LARGE;
		
	}
	
	public enum Speed{
		SLOW, MIDDLE, FAST;
	}
	 
	public enum Quality{
		NORMAL,HD,FHD,UHD;
	}
	
	public enum Types{
		VINYL,CD,DVD
	}

	private String type;
	
	
	public StorageMedium() {
	}


	public String getCD() {
		this.type = Types.CD.toString();
		return type;
	}

	public String getDVD(Quality quality) {
		this.type = Types.DVD.toString() + " Properties: --> " + quality.toString();
		return type;
	}
	
	public String getVinyl(Speed speed, Size size) {
		this.type = Types.VINYL.toString() + "Properties: --> " + speed.toString() + " , " + size.toString();
		return type;
	}


	@Override
	public String toString() {
		return "StorageMedium [type=" + type + "]";
	}
	
}
