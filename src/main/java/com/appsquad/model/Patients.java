package com.appsquad.model;

import java.io.Serializable;


public class Patients{
	private long id;
	public String name;
	public String doctor;
	public String height;
	public String weight;
	public String bloodType;
	public String sex;
	public String age;
	public String apptdate;
	
	/*public Patients(long id, String name, String doctor, String height, String weight, String bloodType, String sex, String age, String apptdate) {
        this.id = id;
        this.name = name;
        this.doctor = doctor;
        this.height= height;
        this.weight = weight;
        this.bloodType=bloodType;
        this.sex = sex;
        this.age = age;
        this.apptdate = apptdate;
    }*/
	
	
	

    @Override
    public String toString() {
        return String.format(
                "Patients[id=%d, name='%s', doctor='%s']",
                id, name, doctor);
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

	public String getDoctor() {
		return doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getBloodType() {
		return bloodType;
	}

	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getApptdate() {
		return apptdate;
	}

	public void setApptdate(String apptdate) {
		this.apptdate = apptdate;
	}
	
	
}
