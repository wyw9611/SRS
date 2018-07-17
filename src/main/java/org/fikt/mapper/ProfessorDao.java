package org.fikt.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import org.fikt.dao.ProfessorDynaSqlProvider;
import org.fikt.domain.Professor;

@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
public interface ProfessorDao {
	/**
	 * 负责对professor表进行操作
	 * @return
	 */
	@Select("select * from professor ")
	@Results({
		@Result(id=true,column="ssn",property="ssn"),
		@Result(column="name",property="name"),
		@Result(column="title",property="title"),
		@Result(column="department",property="department")
	})
	ArrayList<Professor> load();

	//根据用户名密码查询老师1111
	
		@Select("select * from professor where ssn=#{ssn} and password=#{password}")
		@Results({
			@Result(id=true,column="ssn" ,property="ssn"),
			@Result(column="password" ,property="password")		
		})
		Professor selectBySsnAndPassword1(@Param("ssn") String ssn, @Param("password") String password);

	
	@Select("select * from professor where ssn=#{ssn}")
	@Results({
		@Result(id=true,column="ssn",property="ssn"),
		@Result(column="name",property="name"),
		@Result(column="title",property="title"),
		@Result(column="department",property="department")
	})
	Professor selectProfessorBySsn(@Param("ssn") String ssn);

	@Delete("delete from professor where ssn=#{ssn}")
	void deleteProfessor(@Param("ssn") String ssn);
	
	@Insert("insert into professor (ssn,department,title,name) values(#{ssn},#{department},#{title},#{name})")
	void insertProfessor(Professor professor);
	@UpdateProvider(type=ProfessorDynaSqlProvider.class,method="update")
	void updateProfessor(Professor professor);

}
