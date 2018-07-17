package org.fikt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.fikt.domain.Professor;
import org.fikt.domain.Student;
import org.fikt.mapper.ProfessorDao;
import org.fikt.mapper.StudentDao;
import org.fikt.service.LoginService;

@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
@Service("loginService")
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private StudentDao studentDao;
	@Autowired
	private ProfessorDao professorDao;

	
	@Override
	public Student studentLogin(String ssn, String password) {
		Student stu=studentDao.selectBySsnAndPassword(ssn, password);
		return stu;
	}
	@Override
	public Professor professorLogin(String ssn, String password) {
		// TODO Auto-generated method stub111
		System.out.println(ssn);
		Professor pro=professorDao.selectBySsnAndPassword1(ssn, password);
		System.out.println(pro);
		return pro;
	}

}
