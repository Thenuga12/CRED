package com.example.demoo.Repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.example.demoo.Entity.Student;

@Repository
public interface StudentRepo extends JpaRepositoryImplementation<Student, String>{

	Student findByStuId(String id);

	void deleteByStuId(String id);

	boolean existsByStuId(String stuId);

	Object existsByName(Student stu);

}
