package com.example.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.model.CourseModel;




@Service
public class CourseDAOImpl implements CourseDAO {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Override
	public CourseModel selectCourse(String id) {
		CourseModel course = restTemplate.getForObject("http://localhost:8080/rest/course/view/" + id,
				CourseModel.class);
		return course;
	}
	
	@Override
	public List<CourseModel> selectAllCourse() {
		List<CourseModel> courses = restTemplate.getForObject("http://localhost:8080/rest/course/viewall", List.class);
		return courses;
	}
}
