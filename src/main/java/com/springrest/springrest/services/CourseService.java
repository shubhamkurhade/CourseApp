package com.springrest.springrest.services;

import java.util.List;
import java.util.Optional;

import com.springrest.springrest.entities.Course;

// This is interface
// The interface is created for future ref purposes
// If we want to change anything in the applicaiton in the future times we wont be changing the full codes and controller
// we will be only changing the particular service layer

public interface CourseService {
	public List<Course> getCourses();
	public Optional<Course> getCourse(long courseID);
	public Course addCourse(Course course);
	public Course updateCourse(Course course);
	public void deleteCourse(long parseLong);
}
