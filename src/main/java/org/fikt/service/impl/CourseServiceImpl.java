package org.fikt.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.fikt.domain.Course;
import org.fikt.domain.Section;
import org.fikt.domain.Student;
import org.fikt.domain.TranscriptEntity;
import org.fikt.pojo.CourseCatalog;
import org.fikt.service.CourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
@Service("courseService")
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseCatalog courseCatalog;
	
	@Override
	public List<HashMap<String, String>> queryCourse() {
		List<HashMap<String, String>> list=new ArrayList<HashMap<String, String>>();
		List<Course>  courses = courseCatalog.getCourseCatalog();
		int size = courseCatalog.getCourseCatalog().size();
		for(int i=0;i<size;i++){
			HashMap<String, String> map=new HashMap<String, String>();
			map.put("number", courses.get(i).getNumber());
			map.put("name", courses.get(i).getName());
			map.put("credits", String.valueOf(courses.get(i).getCredits()));
			list.add(map);
		}
		return list;
	}
	
	@Override
	public List<HashMap<String, String>> queryPrevCourse(String number) {
		List<HashMap<String, String>> list=new ArrayList<HashMap<String, String>>();
		if(courseCatalog.getMap().get(number).getPrevCourse()!=null){
			ArrayList<Course> courses=courseCatalog.getMap().get(number).getPrevCourse();
			int size=courses.size();
			for(int i=0;i<size;i++){
				HashMap<String, String> map=new HashMap<String, String>();
				map.put("name", courses.get(i).getName());
				map.put("number", courses.get(i).getNumber());
				map.put("credits", String.valueOf(courses.get(i).getCredits()));
				list.add(map);
			}
		}
		return list;
	}
	@Override
	public List<HashMap<String, String>> showCourse(Student student){
		List<HashMap<String, String>> list=new ArrayList<HashMap<String, String>>();
		List<Section> attends=student.getAttends();
		for(int i=0;i<attends.size();i++){
			HashMap<String, String> map=new HashMap<String, String>();
			map.put("name", attends.get(i).getCourse().getName());
			map.put("number", attends.get(i).getCourse().getNumber());
			map.put("credits", String.valueOf(attends.get(i).getCourse().getCredits()));
			list.add(map);
		}
		return list;
	}
	
	@Override
	public boolean addCourse(Course course) {
		return courseCatalog.addCourse(course);
	}
	
	@Override
	public boolean deleteCourse(String number) {
		return courseCatalog.deleteCourse(number);
	}
	
	@Override
	public Course selectCourseByNum(String num) {
		return courseCatalog.getMap().get(num);
	}

	

}
