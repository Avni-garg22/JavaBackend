package com.Hospital;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MedicalRecord {

    @Id
    private int id;

    private String bloodGroup;
    private String allergies;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public String getAllergies() {
		return allergies;
	}
	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}

   
}

