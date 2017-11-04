package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.*;

import com.example.model.CourseModel;
import com.example.model.StudentModel;

@Mapper
public interface CourseMapper {
	@Select("select s.npm, s.name, s.gpa from student s, studentcourse sc where sc.npm = s.npm and id_course=#{id_course}")
	@Results(value = {
	   @Result(property="npm", column="npm"),
	   @Result(property="name", column="name"),
	   @Result(property="gpa", column="gpa")
	   })
	StudentModel selectStudent (@Param("id_course") String id_course);
	
	@Select("select * from course where id_course = #{id_course}")
	@Results(value = {
	   @Result(property="idCourse", column="id_course"),
	   @Result(property="name", column="name"),
	   @Result(property="credits", column="credits"),
	   @Result(property="students", column="id_course", 
	           javaType = List.class,
	           many=@Many(select="selectStudent"))
	})
	CourseModel selectCourse (@Param("id_course") String id_course);
}
