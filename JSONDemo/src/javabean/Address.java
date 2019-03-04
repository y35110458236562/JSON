package javabean;

public class Address {
	private String schoolAddress;
	private String homeAddress;
	public String getSchoolAddress() {
		return schoolAddress;
	}
	public void setSchoolAddress(String schoolAddress) {
		this.schoolAddress = schoolAddress;
	}
	public String getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}
	public Address(String schoolAddress, String homeAddress) {
		
		this.schoolAddress = schoolAddress;
		this.homeAddress = homeAddress;
	}
	public Address() {
		
	}
}
