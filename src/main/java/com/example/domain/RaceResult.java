package com.example.domain;

public class RaceResult {
	private Integer id;
	private String raceId;
	private Integer rank;
	private Integer waku;
	private Integer horseNumber;
	private String horseName;
	private String gender;
	private Integer age;
	private Integer jockeyWeight;
	private String jockeyName;
	private String raceTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRaceId() {
		return raceId;
	}
	public void setRaceId(String raceId) {
		this.raceId = raceId;
	}
	public Integer getRank() {
		return rank;
	}
	public void setRank(Integer rank) {
		this.rank = rank;
	}
	public Integer getWaku() {
		return waku;
	}
	public void setWaku(Integer waku) {
		this.waku = waku;
	}
	public Integer getHorseNumber() {
		return horseNumber;
	}
	public void setHorseNumber(Integer horseNumber) {
		this.horseNumber = horseNumber;
	}
	public String getHorseName() {
		return horseName;
	}
	public void setHorseName(String horseName) {
		this.horseName = horseName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getJockeyWeight() {
		return jockeyWeight;
	}
	public void setJockeyWeight(Integer jockeyWeight) {
		this.jockeyWeight = jockeyWeight;
	}
	public String getJockeyName() {
		return jockeyName;
	}
	public void setJockeyName(String jockeyName) {
		this.jockeyName = jockeyName;
	}
	public String getRaceTime() {
		return raceTime;
	}
	public void setRaceTime(String raceTime) {
		this.raceTime = raceTime;
	}
	@Override
	public String toString() {
		return "RaceResult [id=" + id + ", raceId=" + raceId + ", rank=" + rank + ", waku=" + waku + ", horseNumber="
				+ horseNumber + ", horseName=" + horseName + ", gender=" + gender + ", age=" + age + ", jockeyWeight="
				+ jockeyWeight + ", jockeyName=" + jockeyName + ", raceTime=" + raceTime + "]";
	}
	

}
