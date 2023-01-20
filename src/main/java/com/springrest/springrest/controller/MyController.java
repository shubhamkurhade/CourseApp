package com.springrest.springrest.controller;
import java.util.List;
import java.util.Optional;

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

import com.springrest.springrest.entities.Course;
import com.springrest.springrest.services.CourseService;

@RestController
public class MyController {
	@Autowired
	private CourseService courseservice;
	
	//GET request method to get list of all the courses
	@GetMapping("/courses")
	public List<Course> getCourses()
	{
		return this.courseservice.getCourses();
	}
	//GET request method to get single particular course out of all the courses
	@GetMapping("/courses/{courseID}")
	public Optional<Course> getCourse(@PathVariable String courseID)
	{
		return this.courseservice.getCourse(Long.parseLong(courseID));
	}
	//POST method used to add the new course into out application
	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course course)
	{
		return this.courseservice.addCourse(course);
	}
	//Put method used to modify and edit the pre-existing course details
	@PutMapping("/courses")
	public Course updateCourse(@RequestBody Course course)
	{
		return this.courseservice.updateCourse(course);
	}
	// Delete method is used to delete the records of the courses
	
	@DeleteMapping("/courses/{courseID}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseID){
// HttpStatus - this will handle our exceptions
// if the course is available it will fetch and delete the same
// while if the course is not in the database we will return the internal server error or when there is 
// error in the request object given by the user
		try {
			this.courseservice.deleteCourse(Long.parseLong(courseID));
			return new ResponseEntity<>(HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
}
