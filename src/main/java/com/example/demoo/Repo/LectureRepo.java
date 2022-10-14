package com.example.demoo.Repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.example.demoo.Entity.Lecture;

@Repository
public interface LectureRepo extends JpaRepositoryImplementation<Lecture, Long> {

	Lecture findByLectureId(Long id);

	void deleteAllByLectureId(Long id);

	boolean existsByLectureId(Long lectureId);

}
