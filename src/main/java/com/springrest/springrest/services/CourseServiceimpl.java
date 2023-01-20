package com.springrest.springrest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.CourseDAO;
import com.springrest.springrest.entities.Course;
@Service
public class CourseServiceimpl implements CourseService {

	@Autowired
	private CourseDAO courseDAO;
	// we are making one variable from the object of CourseDAO interface
	// now this will be handled by the SPring boot, we dont need to create it and manage it
	//here this will be used in out service implementation for performing operations in our application
	
	
	@Override
	public List<Course> getCourses() {
		return courseDAO.findAll()
;	}


	@Override
	public Optional<Course> getCourse(long courseID) {
		return courseDAO.findById(courseID);
	}

	@Override
	public Course addCourse(Course course) {
		courseDAO.save(course); // if we pass the course with the save method, 
		//it will just fetch the course and update the details and save the same eventually
		return course;
	}


	@Override
	public Course updateCourse(Course course) {
		courseDAO.save(course);
		return course;
	}

	@Override
	public void deleteCourse(long parseLong) {
		courseDAO.deleteById(parseLong);
	}

}
