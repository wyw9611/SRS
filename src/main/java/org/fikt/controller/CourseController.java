package org.fikt.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.fikt.domain.Course;
import org.fikt.domain.Section;
import org.fikt.domain.Student;
import org.fikt.pojo.StudentCatalog;
import org.fikt.service.CourseService;
import org.fikt.service.SectionService;

/**
 * 对课程进行增删查改
 */
@Controller
@SessionAttributes("Student")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	@Autowired
	private SectionService sectionService;
	
//	index(学生选课)列出课程
	@RequestMapping(value="/queryCourse")
	@ResponseBody
	public Object queryCourse(){
		
		return sectionService.querySection();

		
	}
	
	@RequestMapping(value="/queryPrevCourse")
	@ResponseBody
	public Object queryPrevCourse(String number){
		
		return courseService.queryPrevCourse(number);
		
	}
	
//	课程管理的增加课程
	@RequestMapping(value="/addCourse")
	@ResponseBody
	public Object addCourse(@Param("course")Course course ,@Param("prevCourseNum")String prevCourseNum,@Param("section")Section section){
		List<Map<String, String>> result=new ArrayList<Map<String, String>>();
		if(prevCourseNum!=null)
		{
			String[] pNum = prevCourseNum.split(",");
			for(int i = 0; i < pNum.length; i++)
			{
				Course c = courseService.selectCourseByNum(pNum[i]);
				if( course.getPrevCourse() != null )
				{
					course.getPrevCourse().add(c);
				}else
				{
					ArrayList<Course> li = new ArrayList<Course>();
					li.add(c);
					course.setPrevCourse(li);
				}
				
			}
		}
		
		return courseService.addCourse(course)&&sectionService.addSection(section, course.getNumber());

	}
//	删除课程
	@RequestMapping(value="/deleteCourse")
	@ResponseBody
	public boolean deleteCourse(String number){
		return courseService.deleteCourse(number)&&sectionService.deleteSection(number);
	}
//	展示我的课程
	@RequestMapping(value="/showCourse")
	@ResponseBody
	public Object showCourse(@ModelAttribute("Student")Student student,ModelMap model){
		System.out.println(student.getSsn());
		//Student student=studentCatalog.getMap().get(student.getSsn());;
		return sectionService.showCourse(student.getSsn());
	}
//退选
	@RequestMapping(value="/cancelSection")
	@ResponseBody
	public Object cancelSection(int sectionNo, HttpSession session){ 
		Student student=(Student)session.getAttribute("student");
		return sectionService.deleteSectionBySsnAndSn(student.getSsn(), sectionNo);
	}
}
