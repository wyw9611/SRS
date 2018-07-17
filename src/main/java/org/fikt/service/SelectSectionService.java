package org.fikt.service;

import java.util.ArrayList;

import org.fikt.domain.Student;

public interface SelectSectionService {

	String selectSection(String ssn, int sectionNo);

	ArrayList<Student> queryEnrolledStudents(String sectionNo);

	void selectProfessorSection(String ssn, int sectionNo);
	

}
