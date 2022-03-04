package com.example.test.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="us")

public class Student {

@Id
private long id;
@Column(name = "first_name", nullable = false)
private String first_name;//first name
@Column(name = "last_name")
private String last_name;
@Column(name = "email")
private String email;
public Student() {
	super();
	
}
public Student(long Id, long contact, String fname, String lname, String dob, double age, String college, String branch) {
	super();
	this.id = Id;
	this.first_name = fname;
	this.last_name = lname;
	this.email = college;
}
public long get_id() {
	return id;
}
public void set_id(long Id) {
	this.id = Id;
}
public String getfirst_name() {
	return first_name;
}
public void setfirst_name(String fname) {
	this.first_name = fname;
}
public String getlast_name() {
	return last_name;
}
public void setlast_name(String lname) {
	this.last_name = lname;
}
public String getemail() {
	return email;
}
public void setemail(String college) {
	this.email = college;
}
}