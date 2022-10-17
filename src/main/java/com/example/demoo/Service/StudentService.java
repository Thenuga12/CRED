package com.example.demoo.Service;

import java.util.List;
import com.example.demoo.Entity.Student;

public interface StudentService {

  public void saveStudent(Student stu);

  public List<Student> getAllStudents();

  public Student getById(String id);

  public void deletestudentById(String id);

  public void updateStudentById(Student student);

  public boolean isStudentId(String stuId);

  public boolean isStudentName(String stuId);

  public void updateStudentByName(Student student);
}


