package org.fikt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import org.fikt.domain.Course;

@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
public interface PlanOfStudyDao {

	@Select("SELECT DISTINCT c.* FROM course c LEFT JOIN planofstudy p ON p.number = c.number WHERE p.ssn = #{ssn}")
	List<Course> queryPlanOfStudy( String ssn );
	
}
