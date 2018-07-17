package org.fikt.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.fikt.domain.Section;
import org.fikt.domain.Student;
import org.fikt.domain.TranscriptEntity;
import org.fikt.mapper.TranscriptDao;
import org.fikt.pojo.SectionCatalog;
import org.fikt.pojo.StudentCatalog;
import org.fikt.pojo.TranscriptCatalog;
import org.fikt.service.SectionService;
@Service("sectionService")
public class SectionServiceImpl implements SectionService {
	
	@Autowired
	private SectionCatalog sectionCatalog;
	@Autowired
	private StudentCatalog studentCatalog;
	@Autowired  
	private TranscriptCatalog transcript;
	@Autowired
	private TranscriptDao transcriptDao;
	@Override
	public List<Map<String, String>> querySection() 
	{
		List<Section> list=sectionCatalog.getSectionCatalog();
		
		int size=list.size();
		
		List<Map<String, String>> result=new ArrayList<Map<String, String>>();
		
		for(int i = 0; i < size; i++)
		{
			Map<String, String> map=new HashMap<String, String>();
			 map.put("sectionNo", String.valueOf(list.get(i).getSectionNo()));
			 System.out.println(String.valueOf(list.get(i).getSectionNo()));
			 map.put("name", list.get(i).getCourse().getName());
			 System.out.println(list.get(i).getCourse().getName());
			 String capacity=list.get(i).getEnrolledStudents().size()+"/"+String.valueOf(list.get(i).getCapacity());
			 map.put("capacity", capacity);
			 map.put("room", list.get(i).getRoom());
			 map.put("timeOfDay", list.get(i).getTimeOfDay());
			 map.put("dayOfWeek", list.get(i).getDayOfWeek());
			 map.put("credits", String.valueOf(list.get(i).getCourse().getCredits()));
			 map.put("number", list.get(i).getCourse().getNumber());
			 result.add(map);
		}
		return result;
	}
	
	@Override
	public boolean addSection(Section section,String course_number) {
		// TODO Auto-generated method stub
		return sectionCatalog.addSection(section, course_number);
	}

	
	@Override
	public boolean deleteSection(String number) {
		return sectionCatalog.deleteSection(number);
	}

	
	@Override
	public List<Map<String, String>> deleteSectionBySsnAndSn(String ssn, int sectionNo) {
		//List<Section> list=sectionCatalog.getSectionCatalog();
		Student student=studentCatalog.getMap().get(ssn);
		ArrayList<Section> attends=student.getAttends();
		ArrayList<Section> newAttends=new ArrayList<Section>();
		int size=attends.size();
		for(int i = 0; i <size; i++){
				if(attends.get(i).getSectionNo()!=sectionNo){
					newAttends.add(attends.get(i));
				}
		}
		student.setAttends(newAttends);
		ArrayList<Section> endAttends=student.getAttends();
		List<Map<String, String>> result=new ArrayList<Map<String, String>>();

		for(int i = 0; i < endAttends.size(); i++)
		{
			Map<String, String> map=new HashMap<String, String>();
			map.put("sectionNo", String.valueOf( endAttends.get(i).getSectionNo()));
			map.put("name",  endAttends.get(i).getCourse().getName());
			String capacity= endAttends.get(i).getEnrolledStudents().size()+"/"+String.valueOf( endAttends.get(i).getCapacity());
			map.put("capacity", capacity);
			map.put("room",  endAttends.get(i).getRoom());
			map.put("time", endAttends.get(i).getTimeOfDay());
			map.put("day",  endAttends.get(i).getDayOfWeek());
			map.put("teacher",  endAttends.get(i).getProfessor().getName()+"("+attends.get(i).getProfessor().getTitle()+")");
			map.put("credits", String.valueOf(endAttends.get(i).getCourse().getCredits()));
			result.add(map);
		}
		return result;
	}
	@Override
	public List<Map<String, String>> showCourse(String ssn){
		Student student=studentCatalog.getMap().get(ssn);
		
		//System.out.println(transcripts.size());
		ArrayList<Section> attends=student.getAttends();
		
		int size=attends.size();
		
		List<Map<String, String>> result=new ArrayList<Map<String, String>>();
		
		for(int i = 0; i < size; i++)
		{
			Map<String, String> map=new HashMap<String, String>();
			map.put("sectionNo", String.valueOf(attends.get(i).getSectionNo()));
			map.put("name", attends.get(i).getCourse().getName());
			String capacity=attends.get(i).getEnrolledStudents().size()+"/"+String.valueOf(attends.get(i).getCapacity());
			map.put("capacity", capacity);
			map.put("room", attends.get(i).getRoom());
			map.put("time", attends.get(i).getTimeOfDay());
			map.put("day", attends.get(i).getDayOfWeek());
			map.put("teacher", attends.get(i).getProfessor().getName()+"("+attends.get(i).getProfessor().getTitle()+")");
			map.put("credits", String.valueOf(attends.get(i).getCourse().getCredits()));
			result.add(map);
			
		}
		return result;
	}
	@Override
	public List<Map<String, String>> querySectionAll() 
	{
		List<Section> list=sectionCatalog.getSectionCatalog();
		
		int size=list.size();
		
		List<Map<String, String>> result=new ArrayList<Map<String, String>>();
		
		for(int i = 0; i < size; i++)
		{
			if(!list.get(i).getProfessor().getName().equals("admin")){
			Map<String, String> map=new HashMap<String, String>();
			 map.put("sectionNo", String.valueOf(list.get(i).getSectionNo()));
			 map.put("name", list.get(i).getCourse().getName());
			 String capacity=list.get(i).getEnrolledStudents().size()+"/"+String.valueOf(list.get(i).getCapacity());
			 map.put("capacity", capacity);
			 map.put("room", list.get(i).getRoom());
			 map.put("time", list.get(i).getTimeOfDay());
			 map.put("day", list.get(i).getDayOfWeek());
			 
			 map.put("teacher", list.get(i).getProfessor().getName()+"("+list.get(i).getProfessor().getTitle()+")");
			 
			 map.put("credits", String.valueOf(list.get(i).getCourse().getCredits()));
			 result.add(map);
		}
		}
		return result;
	}

	@Override
	public List<Map<String, String>> queryProfessorSectionAll() {
		// TODO Auto-generated method stub
List<Section> list=sectionCatalog.getSectionCatalog();
		
		int size=list.size();
		
		List<Map<String, String>> result=new ArrayList<Map<String, String>>();
		
		for(int i = 0; i < size; i++)
		{
			if(list.get(i).getProfessor().getName().equals("admin")){
			Map<String, String> map=new HashMap<String, String>();
			 map.put("sectionNo", String.valueOf(list.get(i).getSectionNo()));
			 map.put("name", list.get(i).getCourse().getName());
			 String capacity=list.get(i).getEnrolledStudents().size()+"/"+String.valueOf(list.get(i).getCapacity());
			 map.put("capacity", capacity);
			 map.put("room", list.get(i).getRoom());
			 map.put("time", list.get(i).getTimeOfDay());
			 map.put("day", list.get(i).getDayOfWeek());
			 
			 map.put("teacher", list.get(i).getProfessor().getName()+"("+list.get(i).getProfessor().getTitle()+")");
			 
			 map.put("credits", String.valueOf(list.get(i).getCourse().getCredits()));
			 result.add(map);
		}
		}
		return result;
	}
}
