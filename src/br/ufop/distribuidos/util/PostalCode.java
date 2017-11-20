package br.ufop.distribuidos.util;

import java.io.Serializable;

public class PostalCode implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String postalCode;
	private String placeName;
	private String state;
	private double latitude;
	private double longitude;
	
	private boolean placeNameInput;
	
	public PostalCode(){}
	
	public PostalCode(String postalCode, String placeName, String state,
			double latitude, double longitude) {
		super();
		this.postalCode = postalCode;
		this.placeName = placeName;
		this.state = state;
		this.latitude = latitude;
		this.longitude = longitude;
		placeNameInput = true;
	}
	
	public PostalCode(String postalCode, String placeName, String state){
		super();
		this.postalCode = postalCode;
		this.placeName = placeName;
		this.state = state;
		this.latitude = 999;
		this.longitude = 999;
		placeNameInput = true;
	}
	
	public PostalCode(double latitude, double longitude){
		this.latitude = latitude;
		this.longitude = longitude;
		placeNameInput = false;		
	}
	
	public PostalCode(String placeName){
		this.placeName = placeName;
		placeNameInput = true;
	}
	
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getPlaceName() {
		return placeName;
	}
	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public boolean isPlaceNameInput() {
		return placeNameInput;
	}
	public void setPlaceNameInput(boolean placeNameInput) {
		this.placeNameInput = placeNameInput;
	}
}
