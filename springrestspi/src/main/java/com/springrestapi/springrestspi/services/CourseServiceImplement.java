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
	
//	List<Course> list;
	public CourseServiceImplement() {
//		list = new ArrayList<>();
//		list.add(new Course(145, "Java Core Course", "this course is useful"));
//		list.add(new Course(4343, "Spring Boot course", "Creating Spring Boot"));
	}
	
	
	@Override
	public List<Course> getCourses() {
		// TODO Auto-generated method stub
		return courseDao.findAll();
	}

//this is for single course
	@Override
	public Course getCourse(long courseId) {
//		Course c = null;
//		for(Course course: list) {
//			if(course.getId() == courseId) {
//				c = course;
//				break;
//			}
//		}
		return courseDao.getOne(courseId);
	}

// this is for add course
	@Override
	public Course addCourse(Course course) {
		// TODO Auto-generated method stub
//		list.add(course);
		courseDao.save(course);
		return course;
	}

//update the course
	@Override
	public Course updateCourse(Course course) {
//		list.forEach(e -> {
//			if(e.getId() == course.getId()) {
//				e.setTitle(course.getTitle());
//				e.setDescription(course.getDescription());
//			}
//		});
		courseDao.save(course);
		return course;
	}


	@Override
	public void deleteCourse(long parseLong) {
//		list = this.list.stream().filter(e->e.getId() != parseLong).collect(Collectors.toList());
		Course entity = courseDao.getOne(parseLong);
		courseDao.delete(entity);
	}
	

}
