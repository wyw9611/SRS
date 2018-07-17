package org.fikt.service;

import java.util.List;

import org.fikt.domain.Professor;

public interface ProfessorService {
	
	/**
	 * 添加教师
	 * @param professor
	 * @return
	 */
	boolean addProfessor(Professor professor);
	/**
	 * 查询教师
	 * @return
	 */
	List<Professor> queryProfessor();
	/**
	 * 删除教师
	 * @param ssn
	 * @return
	 */
	boolean deleteProfessor(String ssn);
	/**
	 * 修改教师资料
	 * @param professor
	 * @return
	 */
	boolean updateProfessor(Professor professor);
	

}
