package com.example.demo;

import javax.persistence.*;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
     
    @Column(length = 64, unique = true, nullable = false)
    private String firstName;
	private String lastName;
	private String classGroup;

	public Student(){
		// required by JPA but not used by us
	}

	public Student(String fn, String ln, String cg){
		this.firstName = fn;
		this.lastName = ln;
		this.classGroup = cg;
	}

	public String getFirstName(){
		return this.firstName;
	}
	public String getLastName(){
		return this.lastName;
	}
	public int getId(){
		return this.id;
	}

	public String getGroup(){
		return this.classGroup;
	}
	public void setFirstName(String aName){
		this.firstName=aName;
	}
	public void setLastName(String aName){
		this.lastName=aName;
	}
	public void setId(int aId){
		this.id=aId;
	}
	public void setGroup(String aGroup){
		this.classGroup= aGroup;
	}

}

