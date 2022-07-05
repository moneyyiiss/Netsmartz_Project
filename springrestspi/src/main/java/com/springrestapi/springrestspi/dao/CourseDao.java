package com.springrestapi.springrestspi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springrestapi.springrestspi.entities.Course;

public interface CourseDao extends JpaRepository<Course, Long>{
	
}
