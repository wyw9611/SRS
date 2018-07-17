package org.fikt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import org.fikt.domain.Professor;
import org.fikt.service.ProfessorService;
/**
 * 对教师进行增删查改
 */
@Controller
public class ProfessorController {
	
	@Autowired
	@Qualifier("professorService")
	private ProfessorService professorService;
	
	@RequestMapping(value="/addProfessor")
	@ResponseBody
	public boolean addProfessor(@ModelAttribute Professor professor)
	{
		return professorService.addProfessor(professor);		
	}
	
	@RequestMapping(value="/queryProfessor")
	@ResponseBody
	public  Object queryProfessor()
	{
		
		return professorService.queryProfessor();
		
	}
	
	@RequestMapping(value="/deleteProfessor")
	@ResponseBody
	public boolean deleteProfessor(String ssn,ModelAndView mv)
	{
		
		return professorService.deleteProfessor(ssn);
		
	}
	
	@RequestMapping(value="/updateProfessor")
	@ResponseBody
	public boolean updateProfessor(ModelAndView mv,
			@ModelAttribute Professor professor)
	{
		return professorService.updateProfessor(professor);
	}
	
	
}
