package com.nevexis.jtdemo.passengers.domain;

public class Driver {
	private long id;
	private String name;
	private String driverLicenseId;

	public Driver() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDriverLicenseId() {
		return driverLicenseId;
	}

	public void setDriverLicenseId(String driverLicenseId) {
		this.driverLicenseId = driverLicenseId;
	}

	@Override
	public String toString() {
		return "Driver [id=" + id + ", name=" + name + ", driverLicenseId=" + driverLicenseId + "]";
	}
}
