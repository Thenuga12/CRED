package com.example.demoo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demoo.Entity.Lecture;
import com.example.demoo.Repo.LectureRepo;

@Service
public class LectureServiceImplementation implements LectureService{
	@Autowired
	private LectureRepo lecturerepo;

	@Override
	public void saveLecture(Lecture lecture) {
		lecturerepo.save(lecture);
		
	}

	@Override
	public List<Lecture> getAllLecture() {
		return lecturerepo.findAll();
	}

	
	@Override
	public Lecture getById(Long id) {
		return lecturerepo.findByLectureId(id);
	}

	@Transactional
	public void deletLecture(Long id) {
		lecturerepo.deleteAllByLectureId(id);
		
	}

	@Override
	public boolean isLectureId(Long lectureId) {
		return lecturerepo.existsByLectureId(lectureId);
	}

	@Override
	public void updateLectureById(Lecture lecture) {
		lecturerepo.save(lecture);
		
	}
	
	

}
