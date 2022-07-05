package com.springrestapi.springrestspi.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springrestapi.springrestspi.dao.CourseDao;
import com.springrestapi.springrestspi.entities.Course;
import com.springrestapi.springrestspi.services.CourseService;

@RestController
public class MyController {
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private CourseDao courseDao;
	
	@GetMapping("/home")
	public String home() {
		return "this is home";
	}
	
	//Get the courses
	@GetMapping("/courses")
	public List<Course> getCourses(){
		return this.courseService.getCourses();
	}
	
	//Single courses get
	@GetMapping("/courses/{courseId}")
	public Course getCourse(@PathVariable String courseId) {
		return this.courseService.getCourse(Long.parseLong(courseId));
		
	}
	//course add
	@PostMapping(path = "/courses", consumes= "application/json")
	public Course addCourse(@RequestBody Course course) {
		return this.courseService.addCourse(course);
	}
	
	//update course using PUT request
	@PutMapping("/courses")
	public Course updateCourse(@RequestBody Course course) {
		return this.courseService.updateCourse(course);
	}
	
	//delete the course
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId){
		try {
			this.courseService.deleteCourse(Long.parseLong(courseId));
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e){
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//http://localhost:8080/products/filter?name=javaaaaa
			//http://localhost:9090/products/pagination?page=3&size=3
			@GetMapping("/pagination")
			public ResponseEntity<List<Course>> getProductPagination(@RequestParam int page, @RequestParam int size){
				Pageable pageable = PageRequest.of(page, size);
				List<Course> list = courseDao.findAll(pageable).getContent();
				return ResponseEntity.ok(list);
//				return ResponseEntity.ok(productRepository.findByName(name));
			}
}
