package org.fikt.service;

import java.util.List;
import java.util.Map;

import org.fikt.domain.Section;

public interface SectionService {

	List<Map<String, String>> querySection();
	Object deleteSectionBySsnAndSn(String ssn, int sectionNo);
	List<Map<String, String>> showCourse(String ssn);
	boolean addSection(Section section,String course_number);

	boolean deleteSection(String number);
	List<Map<String, String>> querySectionAll();
	List<Map<String, String>> queryProfessorSectionAll();
}
