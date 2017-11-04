package com.example.dao;

import java.util.List;

import com.example.model.*;

public interface CourseDAO {

	CourseModel selectCourse(String id);
	
	List<CourseModel> selectAllCourse();

}

