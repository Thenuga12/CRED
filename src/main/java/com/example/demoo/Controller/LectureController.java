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

import com.example.demoo.Dto.LectureDto;
import com.example.demoo.Dto.NewLectureDto;
import com.example.demoo.Entity.Lecture;
import com.example.demoo.Service.LectureService;




@RestController
public class LectureController {
	@Autowired
	LectureService lectureservice;
	
	@PostMapping("/addlecture")
	public ResponseEntity<Object> addLecture(@RequestBody LectureDto lecturedto)
	{
		Lecture lecture=new Lecture();
		BeanUtils.copyProperties(lecturedto, lecture);
		lectureservice.saveLecture(lecture);
		return new ResponseEntity<Object>("Lecture added successfully",HttpStatus.OK);
		
	}
	
	@GetMapping("/alllecture")
	public ResponseEntity<Object> getAllLecture()
	{
		List<Lecture> lecture=new ArrayList<Lecture>();
		lecture= lectureservice.getAllLecture();
		return new ResponseEntity<Object>(lecture,HttpStatus.OK);
		
	}
	
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<Object> getByID(@PathVariable Long id)
	{
		
		return new ResponseEntity<Object>(lectureservice.getById(id),HttpStatus.OK);
		
	}
	
	@DeleteMapping("/deletelecture/{id}")
	public ResponseEntity<Object> deleteLecture(@PathVariable Long id)
	{
		lectureservice.deletLecture(id);
		return new ResponseEntity<Object>("Delete Successfully",HttpStatus.OK);
		
	}
	
	@PutMapping("/updatelecture")
	public ResponseEntity<Object> updateLecture(@RequestBody LectureDto lecturedto)
	{
		if(!lectureservice.isLectureId(lecturedto.getLectureId()))
		{
			return new ResponseEntity<Object>("Enter Correct Id",HttpStatus.BAD_REQUEST);
		}
		Lecture lecture=new Lecture();
		BeanUtils.copyProperties(lecturedto, lecture);
		lectureservice.updateLectureById(lecture);
		return new ResponseEntity<Object>("Update Successfully",HttpStatus.OK);
		
	}
	@PutMapping("/updatebyNamelecture")
	public ResponseEntity<Object> updateLectureByName(@RequestBody NewLectureDto newlecturedto)
	{
		if(!lectureservice.isLectureId(newlecturedto.getLectureId()))
		{
			return new ResponseEntity<Object>("Enter Correct Id",HttpStatus.BAD_REQUEST);
		}
		Lecture lecture=new Lecture();
		BeanUtils.copyProperties(newlecturedto, lecture);
		lectureservice.updateLectureByName(lecture);
		return new ResponseEntity<Object>("Update Successfully",HttpStatus.OK);
		
	}
}
