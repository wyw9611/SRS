package org.fikt.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.fikt.domain.Professor;
import org.fikt.domain.Section;
import org.fikt.domain.Student;
import org.fikt.domain.TranscriptEntity;
import org.fikt.mapper.SectionDao;
import org.fikt.pojo.ProfessorCatalog;
import org.fikt.pojo.SectionCatalog;
import org.fikt.pojo.StudentCatalog;
import org.fikt.pojo.TranscriptCatalog;
import org.fikt.service.SelectSectionService;
import org.fikt.specification.Specification;
@Service("selectSectionService")
public class SelectSectionServiceImpl implements SelectSectionService {
	
	@Autowired
	@Qualifier("selectionSectionSpecification")
	private Specification<Section> selectionSectionSpecification;
	
	@Autowired
	private SectionCatalog sectionCatalog;
	
	@Autowired
	private StudentCatalog studentCatalog;
	
	@Autowired
	private ProfessorCatalog professorCatalog;
	
	@Autowired
	private SectionDao sectionDao;
	
	@Override
	public String selectSection(String ssn, int sectionNo) {
		Section section=sectionCatalog.getMap().get(String.valueOf(sectionNo));
		Student student=studentCatalog.getMap().get(ssn);
		
		String result=selectionSectionSpecification.validate(student,section);
		if(result == null)
		{
			sectionCatalog.sectionAddEnrolledStudent(student,section);
			studentCatalog.studentAddAttends(student,section);
			//TranscriptEntity entity=new TranscriptEntity(-1,student,section);
			//transcript.getMap().get(ssn).add(entity);
			result="选课成功！";
		}else{			
			return result;
		}
		return result; 
	}
	
	@Override
	public ArrayList<Student> queryEnrolledStudents(String sectionNo) 
	{
		Section section=sectionCatalog.getMap().get(sectionNo);
		int size=section.getEnrolledStudents().size();
		ArrayList<Student> list=new ArrayList<Student>();
		for(int i=0;i<size;i++){
			Student s=new Student(section.getEnrolledStudents().get(i).getSsn(),section.getEnrolledStudents().get(i).getName(),"",
					section.getEnrolledStudents().get(i).getDegree(),section.getEnrolledStudents().get(i).getMajor());
			list.add(s);
		}
		return list;
	}

	@Override
	public void selectProfessorSection(String ssn, int sectionNo) {
		// TODO Auto-generated method stub
		sectionDao.updateSection(ssn, sectionNo);
		
	}
	
}
