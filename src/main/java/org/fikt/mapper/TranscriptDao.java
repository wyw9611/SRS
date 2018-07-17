package org.fikt.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import org.fikt.domain.TranscriptEntity;

public interface TranscriptDao {
	@Select("select * from transcriptentity")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="grade",property="grade"),
		@Result(column="student_ssn",property="student",
		one=@One(select="org.fikt.mapper.StudentDao.selectBySsn",
				fetchType=FetchType.EAGER)),
		@Result(column="sectionNo",property="section",
		one=@One(select="org.fikt.mapper.SectionDao.selectBySectionNo",
		fetchType=FetchType.EAGER))
	})
	ArrayList<TranscriptEntity> load();
	
	@Insert("insert into transcriptentity (sectionNo,student_ssn) values (#{sectionNo},#{ssn})")
	void add(@Param("ssn") String ssn, @Param("sectionNo") int sectionNo);
	@Select("select * from transcriptentity where student_ssn=#{ssn}")
	ArrayList<TranscriptEntity> selectBySsn(@Param("ssn") String ssn);
	

}
