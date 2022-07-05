package com.springrestapi.springrestspi.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrestapi.springrestspi.dao.CourseDao;
import com.springrestapi.springrestspi.entities.Course;
@Service
public class CourseServiceImplement implements CourseService {
	@Autowired
	private CourseDao courseDao;
	

	public CourseServiceImplement() {

	}
	
	
	@Override
	public List<Course> getCourses() {

		return courseDao.findAll();
	}

//this is for single course
	@Override
	public Course getCourse(long courseId) {

		return courseDao.getOne(courseId);
	}

// this is for add course
	@Override
	public Course addCourse(Course course) {

		courseDao.save(course);
		return course;
	}

//update the course
	@Override
	public Course updateCourse(Course course) {

		courseDao.save(course);
		return course;
	}


	@Override
	public void deleteCourse(long parseLong) {

		Course entity = courseDao.getOne(parseLong);
		courseDao.delete(entity);
	}
	

}
