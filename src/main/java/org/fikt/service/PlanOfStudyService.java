package org.fikt.service;

import java.util.List;

import org.fikt.domain.Course;

public interface PlanOfStudyService {

	List<Course> queryPlanOfStudy( String ssn );
	
}
