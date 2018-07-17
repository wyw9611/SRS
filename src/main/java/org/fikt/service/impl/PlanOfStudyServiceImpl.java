package org.fikt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import org.fikt.domain.Course;
import org.fikt.mapper.PlanOfStudyDao;
import org.fikt.service.PlanOfStudyService;

@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
@Service("planOfStudyService")
public class PlanOfStudyServiceImpl implements PlanOfStudyService {

	@Autowired
	private PlanOfStudyDao planOfStudyDao;
	
	@Override
	public List<Course> queryPlanOfStudy(String ssn) {
		return planOfStudyDao.queryPlanOfStudy(ssn);
	}

}
