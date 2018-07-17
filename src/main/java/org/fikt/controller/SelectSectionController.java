package org.fikt.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.fikt.domain.Professor;
import org.fikt.domain.Student;
import org.fikt.service.LoginService;
import org.fikt.service.SectionService;
import org.fikt.service.SelectSectionService;

/**
 * 选课流程
 */
@Controller
@SessionAttributes("Student")
public class SelectSectionController {
	private Professor professor;
	private Student student;
	
	@Autowired
	@Qualifier("loginService")
	private LoginService loginService;
	
	@Autowired
	@Qualifier("sectionService")
	private SectionService sectionService;
	
	@Autowired
	private SelectSectionService selectSectionService;
	
	@RequestMapping("/loginForm")
	public ModelAndView login(String ssn, String password, String radio,ModelAndView mv,
			 HttpSession session,ModelMap model){
		System.out.println(radio);
		if(radio.equals("student")){
			student = loginService.studentLogin(ssn, password);
			System.out.println(student);
			if(student != null)
			{
				session.setAttribute("student", student);
				model.addAttribute("Student",student);
				System.out.println(model.get("Student"));
				mv.setViewName("index");
			}else
			{
				mv.addObject("message", "登录名或密码错误，请重新输入");
				mv.setViewName("login");
			}
		}else if(radio.equals("professor")){
			System.out.println(ssn);
			System.out.println(password);
			
			professor=loginService.professorLogin(ssn, password);
			System.out.println(professor);
			if(professor != null)
			{
				session.setAttribute("professor", professor);
				mv.setViewName("index");
			}else
			{
				mv.addObject("message", "登录名或密码错误，请重新输入");
				mv.setViewName("login");
			}
		}
		
		return mv;
	}
	
	/**
	 * 课程管理index
	 * @return
	 */
	@RequestMapping("/querySection")
	@ResponseBody
	public Object querySection()
	{
		return sectionService.querySection();
	}
	/**
	 * 查看学生课程选课
	 * @return
	 */
	@RequestMapping("/querySectionAll")
	@ResponseBody
	public Object querySectionAll()
	{
		return sectionService.querySectionAll();
	}
	/**
	 * 查看老师课程选课
	 * @return
	 */
	@RequestMapping("/queryProfessorSectionAll")
	@ResponseBody
	public Object queryProfessorSectionAll()
	{
		return sectionService.queryProfessorSectionAll();
	}
	/**
	 * 学生选课
	 * @param sectionNo
	 * @return
	 */
	@RequestMapping(value="/selectSection",produces="text/html;charset=UTF-8")
	@ResponseBody  	  
	public Object selectSection(int sectionNo, HttpSession session) 
	{
		Student student=(Student)session.getAttribute("student");
		return selectSectionService.selectSection(student.getSsn(), sectionNo);
	}
	
	/**
	 * 老师选课
	 * @param sectionNo
	 */
	@RequestMapping(value="/selectProfessorSection",produces="text/html;charset=UTF-8")
	@ResponseBody  	  
	public void selectProfessorSection(int sectionNo, HttpSession session) 
	{
		Professor professor=(Professor)session.getAttribute("professor");
		 selectSectionService.selectProfessorSection(professor.getSsn(), sectionNo);
	}
	
	/**
	 * 查看某门课有哪些学生选了
	 */
	@RequestMapping(value="/queryEnrolledStudents")
	@ResponseBody
	public Object queryEnrolledStudents(@RequestParam("sectionNo") Integer sectionNo, Model model)
	{
		return selectSectionService.queryEnrolledStudents(String.valueOf( sectionNo ));
	}
	
	
}
