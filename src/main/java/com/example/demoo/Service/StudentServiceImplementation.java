package com.example.demoo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demoo.Entity.Student;
import com.example.demoo.Repository.StudentRepository;

@Service
public class StudentServiceImplementation implements StudentService {
	@Autowired
	private StudentRepository sturepo;

	public void saveStudent(Student student) {
		sturepo.save(student);
	}

	@Override
	public List<Student> getAllStudents() {
		return sturepo.findAll();
	}

	@Override
	public Student getById(String id) {
		// TODO Auto-generated method stub
		return sturepo.findByStuId(id);
	}

	@Transactional
	public void deletestudentById(String id) {
		sturepo.deleteByStuId(id);
	}

	@Override
	public void updateStudentById(Student student) {
		sturepo.save(student);

	}

	@Override
	public boolean isStudentId(String stuId) {
		return sturepo.existsByStuId(stuId);
	}

	@Override
	public void updateStudentByName(Student stu) {
		Student oldStuData = new Student();
		oldStuData = sturepo.findByStuId(stu.getStuId());
		stu.setAge(oldStuData.getAge());
		
		sturepo.save(stu);
	}

	@Override
	public boolean isStudentName(String stuId) {
		// TODO Auto-generated method stub
		return false;
	}

}
