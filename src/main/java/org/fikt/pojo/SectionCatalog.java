package org.fikt.pojo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.fikt.domain.Section;
import org.fikt.domain.Student;
import org.fikt.mapper.SectionDao;
import org.fikt.mapper.TranscriptDao;

@Component
@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
public class SectionCatalog{
	
	private List<Section> sectionCatalog;
	private Map<String,Section> map;
	
	public SectionCatalog(ArrayList<Section> sectionCatalog, HashMap<String,Section> map) {
		super();
		sectionCatalog = new ArrayList<Section>();
		map = new HashMap<String, Section>();
	}
	
	public SectionCatalog() {
		super();
		sectionCatalog = new ArrayList<Section>();
		map = new HashMap<String, Section>();
	}
	
	@Autowired
	private SectionDao sectionDao;
	
	@Autowired
	private TranscriptDao transcriptDao;
	
	@PostConstruct
	public void init()
	{
		this.sectionCatalog = load();
		
		int size = sectionCatalog.size();
		
		for(int i = 0; i < size; i++)
		{
			this.map.put(String.valueOf(sectionCatalog.get(i).getSectionNo()), sectionCatalog.get(i));
		}
	}
	/**
	 * 加载数据
	 * @return
	 */
	private ArrayList<Section> load() 
	{
		return sectionDao.load();
	}

	@PreDestroy
	public void preDestroy(){
			
	}
	/**
	 * 课程中增加选课学生
	 * @param student
	 * @param section
	 */
	public void sectionAddEnrolledStudent(Student student, Section section) 
	{
		
		map.get( String.valueOf(section.getSectionNo()) ).getEnrolledStudents().add(student);
		
		transcriptDao.add(student.getSsn(), section.getSectionNo());
		
	}
	public List<Section> getSectionCatalog() {
		return sectionCatalog;
	}

	public void setSectionCatalog(ArrayList<Section> sectionCatalog) {
		this.sectionCatalog = sectionCatalog;
	}

	public Map<String, Section> getMap() {
		return map;
	}

	public void setMap(HashMap<String, Section> map) {
		this.map = map;
	}
	
	/**
	 * 删除选课
	 * @param number
	 * @return
	 */
	public boolean deleteSection(String ssn, int sectionNo) {
		
		try{
			
			for(Section section:sectionCatalog)
			{
				for(Student student:section.getEnrolledStudents()){
				if( section.getSectionNo()==sectionNo && student.getSsn().equals(ssn))
				{
					sectionCatalog.remove(section);
					break;
				}
			}
		}
			
			sectionDao.deleteSectionBySsnAndSN(ssn, sectionNo);
			
		}catch( Exception e){
			
			System.out.println(e);
			return false;
			
		}
		return true;
	}

	public boolean deleteSection(String number) {
		// TODO Auto-generated method stub
try{
			
			for(Section section:sectionCatalog)
			{
				if( section.getCourse().getNumber().equals(number) )
				{
					sectionCatalog.remove(section);
					break;
				}
			}
			
			sectionDao.deleteSectionByNumber(number);
			
		}catch( Exception e){
			
			System.out.println(e);
			return false;
			
		}
		return true;
	}

	
public boolean addSection(Section section,String course_number) {
		
		sectionCatalog.add(section);
		map.put( String.valueOf(section.getSectionNo()), section);
		try{
//			sectionDao.insertSection(section);
			String dayOfWeek=section.getDayOfWeek();
			System.out.println(dayOfWeek);
			String timeOfDay=section.getTimeOfDay();
			String room=section.getRoom();
			int capacity=section.getCapacity();
			sectionDao.insertSection(dayOfWeek,timeOfDay,room,capacity,course_number);
			System.out.println(capacity);
			System.out.println(course_number);

		}catch( Exception e){
			System.out.println(e);
			return false;
		}
		return true;
	}
	
	
}
