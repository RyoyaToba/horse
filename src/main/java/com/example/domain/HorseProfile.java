package com.example.domain;

public class HorseProfile {

	private Integer id;
	private String name;
	private String birthYear;
	private String gender;
	private String father;
	private String mother;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(String birthYear) {
		this.birthYear = birthYear;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getFather() {
		return father;
	}

	public void setFather(String father) {
		this.father = father;
	}

	public String getMother() {
		return mother;
	}

	public void setMother(String mother) {
		this.mother = mother;
	}

	@Override
	public String toString() {
		return "horseProfile [id=" + id + ", name=" + name + ", birthYear=" + birthYear + ", gender=" + gender
				+ ", father=" + father + ", mother=" + mother + "]";
	}

}
