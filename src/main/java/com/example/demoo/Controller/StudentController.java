package com.example.demoo.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoo.Dto.NewStudentDto;
import com.example.demoo.Dto.StudentDto;
import com.example.demoo.Entity.Student;
import com.example.demoo.Service.StudentService;
import com.example.demoo.Util.Constant;

@RestController
public class StudentController {
  @Autowired
  private StudentService studentservice;

  @PostMapping("/student")
  public ResponseEntity<Object> addStudent(@RequestBody StudentDto studto) {
    Student stu = new Student();
    BeanUtils.copyProperties(studto, stu);
    studentservice.saveStudent(stu);
    return new ResponseEntity<>(Constant.ADD_STUDENT_SUCCESS, HttpStatus.OK);

  }

  @GetMapping("/getallstudent")
  public ResponseEntity<Object> getAllStudent() {
    List<Student> stude = new ArrayList<Student>();
    stude = studentservice.getAllStudents();
    return new ResponseEntity<Object>(stude, HttpStatus.OK);

  }

  @GetMapping("/getById/{id}")
  public ResponseEntity<Object> getById(@PathVariable String id) {
    return new ResponseEntity<Object>(studentservice.getById(id), HttpStatus.OK);

  }

  @DeleteMapping("/deletestu/{id}")
  public ResponseEntity<Object> deleteById(@PathVariable String id) {
    studentservice.deletestudentById(id);
    return new ResponseEntity<>("Deleted Success", HttpStatus.OK);

  }

  @PutMapping("/update")
  public ResponseEntity<Object> updatStudent(@RequestBody StudentDto studto) {
    if (!studentservice.isStudentId(studto.getStuId())) {
      return new ResponseEntity<>(Constant.STUDENT, HttpStatus.BAD_REQUEST);
    }
    Student student = new Student();
    BeanUtils.copyProperties(studto, student);
    studentservice.updateStudentById(student);
    return new ResponseEntity<Object>(Constant.UPDATE_STUDENT_SUCCESS, HttpStatus.OK);

  }

  @PutMapping("/updatebyname")
  public ResponseEntity<Object> updateStudentByName(@RequestBody NewStudentDto newstudentdto) {
    if (!studentservice.isStudentId(newstudentdto.getStuId())) {
      return new ResponseEntity<>(Constant.STUDENT, HttpStatus.BAD_REQUEST);
    }
    Student student = new Student();
    BeanUtils.copyProperties(newstudentdto, student);
    studentservice.updateStudentByName(student);

    return new ResponseEntity<Object>(Constant.UPDATE_STUDENT_SUCCESS, HttpStatus.OK);

  }

}
