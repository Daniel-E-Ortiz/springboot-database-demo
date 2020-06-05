package com.mins.database.databasedemo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


//@Table(name="person") unnecessary since class name == table name.

@Entity
@NamedQuery(name="find_all_persons", query="select p from Person p")
public class Person {
	//Makes the id below a primary key.
	//Hibernate generates an ID for me
	@Id 
	@GeneratedValue 
	private int id;
	
	//@Column(name="name") unnecessary since the column name already matches variable name.
	private String name;
	private String location;
	private Date birthdate;
	
	public Person() {
		
	}
	
	@Override
	public String toString() {
		return "\nPerson [id=" + id + ", name=" + name + ", location=" + location + ", birthdate=" + birthdate + "]";
	}
	
	public Person(int id, String name, String location, Date birthdate) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.birthdate = birthdate;
	}
	// constructor without id so we can allow hibernate to construct with it's own id.
	public Person(String name, String location, Date birthdate) {
		super();
		this.name = name;
		this.location = location;
		this.birthdate = birthdate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	
	
}
