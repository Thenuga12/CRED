package com.example.demoo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demoo.Entity.Lecture;

@Service
public interface LectureService {

	void saveLecture(Lecture lecture);

	List<Lecture> getAllLecture();

	public Lecture getById(Long id);

	void deletLecture(Long id);

	boolean isLectureId(Long lectureId);
	

	void updateLectureById(Lecture lecture);

	

}
