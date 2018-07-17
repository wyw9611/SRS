package org.fikt.service;

import org.fikt.domain.Professor;
import org.fikt.domain.Student;

public interface LoginService {
	/**
	 * 学生登陆
	 * @param ssn
	 * @param password
	 * @return
	 */
	Student studentLogin(String ssn, String password);
	Professor professorLogin(String ssn, String password);
}
