package com.example.demoo.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Lecture {
	@Id
	private Long lectureId;
	private String name;
	private int experince;
	
	public Long getLectureId() {
		return lectureId;
	}
	public void setLectureId(Long lectureId) {
		this.lectureId = lectureId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getExperince() {
		return experince;
	}
	public void setExperince(int experince) {
		this.experince = experince;
	}
	
	
	
}
