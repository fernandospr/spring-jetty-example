package com.fernandospr.example.model;

import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Student {
	@JsonProperty("first_last_name")
	@Size(min=2, max=50) 
	private String firstAndLastName;

	private String id;

	public Student(@JsonProperty("first_last_name") String firstAndLastName) {
		this.firstAndLastName = firstAndLastName;
	}

	public String getFirstAndLastName() {
		return firstAndLastName;
	}

	public void setFirstAndLastName(String firstAndLastName) {
		this.firstAndLastName = firstAndLastName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void merge(Student other) {
		this.setFirstAndLastName(other.getFirstAndLastName());
		this.setId(other.getId());
	}
	
	public String toString() {
		String idString = this.id != null ? this.id.toString() : "null";
		return "Student: firstAndLastName:" + this.firstAndLastName + ", id:" + idString;
	}
}
