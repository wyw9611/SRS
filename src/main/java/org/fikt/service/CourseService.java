package org.fikt.service;

import java.util.HashMap;
import java.util.List;

import org.fikt.domain.Course;
import org.fikt.domain.Student;

public interface CourseService {

	List<HashMap<String, String>> queryCourse();

	boolean addCourse(Course course);

	boolean deleteCourse(String number);

	List<HashMap<String, String>> queryPrevCourse(String number);

	Course selectCourseByNum(String string);
	
	List<HashMap<String, String>> showCourse(Student student);

}
