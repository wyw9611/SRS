package org.fikt.mapper;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

import org.apache.ibatis.mapping.FetchType;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import org.fikt.domain.Section;
@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
public interface SectionDao {
	@Select("select * from section where professor_sn = #{ssn}")
	@Results({
	/*	@Result(id=true,column="sectionNo",property="sectionNo"),
		@Result(column="dayOfWeek",property="dayOfWeek"),
		@Result(column="timeOfDay",property="timeOfDay"),
		@Result(column="room",property="room"),
		@Result(column="capacity",property="capacity"),*/
		@Result(column="course_number",property="course",
		one=@One(select="org.fikt.mapper.CourseDao.selectCourseByNum",
				fetchType=FetchType.LAZY))
	})
	ArrayList<Section> selectByProfessorSsn(String ssn);
	
	@Select("select * from section")
	@Results({
		@Result(id=true,column="sectionNo",property="sectionNo"),
		@Result(column="course_number",property="course",
		one=@One(select="org.fikt.mapper.CourseDao.selectCourseByNum",
				fetchType=FetchType.EAGER)),
		@Result(column="professor_sn",property="professor",
		one=@One(select="org.fikt.mapper.ProfessorDao.selectProfessorBySsn",
				fetchType=FetchType.EAGER)),
		@Result(column="sectionNo",property="enrolledStudents",
		many=@Many(select="org.fikt.mapper.StudentDao.selectStudentBySectionNo",
				fetchType=FetchType.LAZY))
	})
	ArrayList<Section> load();
	
	@Select("select * from section where sectionNo in (select sectionNo from transcriptentity where student_ssn=#{ssn})")
	@Results({
		@Result(id=true,column="sectionNo",property="sectionNo"),
		@Result(column="course_number",property="course",
		one=@One(select="org.fikt.mapper.CourseDao.selectCourseByNum",
				fetchType=FetchType.EAGER)),
		@Result(column="professor_sn",property="professor",
		one=@One(select="org.fikt.mapper.ProfessorDao.selectProfessorBySsn",
				fetchType=FetchType.EAGER)),
		@Result(column="sectionNo",property="enrolledStudents",
		many=@Many(select="org.fikt.mapper.StudentDao.selectStudentBySectionNo",
				fetchType=FetchType.LAZY))
	})
	ArrayList<Section> selectByStudentSn(String ssn);
	
	@Select("select * from section where sectionNo =#{sectionNo}")
	@Results({
		@Result(id=true,column="sectionNo",property="sectionNo"),
		@Result(column="course_number",property="course",
		one=@One(select="org.fikt.mapper.CourseDao.selectCourseByNum",
				fetchType=FetchType.EAGER)),
		@Result(column="professor_sn",property="professor",
		one=@One(select="org.fikt.mapper.ProfessorDao.selectProfessorBySsn",
				fetchType=FetchType.EAGER)),
		@Result(column="sectionNo",property="enrolledStudents",
		many=@Many(select="org.fikt.mapper.StudentDao.selectStudentBySectionNo",
				fetchType=FetchType.LAZY))
	})
	Section selectBySectionNo(int sectionNo);
	
	@Delete("delete from section where student_ssn=#{student_ssn} and sectionNo=#{sectionNo}")
	void deleteSectionBySsnAndSN(@Param("student_ssn") String ssn, @Param("sectionNo")Integer sectionNo);
	
	@Insert("insert into section (dayOfWeek,timeOfDay,room,capacity,course_number) values(#{dayOfWeek},#{timeOfDay},#{room},#{capacity},#{course_number})")
	void insertSection(@Param("dayOfWeek") String dayOfWeek,@Param("timeOfDay") String timeOfDay,@Param("room") String room,@Param("capacity") int capacity,@Param("course_number") String course_number);

	@Delete("delete from section where course_number=#{number}")
	void deleteSectionByNumber(String number);
	
	@Update("update section set professor_sn=#{ssn} where sectionNo=#{sectionNo}")
	void updateSection(@Param("ssn") String professor_sn,@Param("sectionNo")int sectionNo);

}
