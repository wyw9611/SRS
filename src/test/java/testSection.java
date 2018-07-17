import java.util.ArrayList;

import org.fikt.domain.Course;
import org.fikt.domain.Professor;
import org.fikt.domain.Section;
import org.fikt.domain.Student;
import org.fikt.service.SelectSectionService;
import org.fikt.specification.SelectionSectionSpecification;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class testSection {
	@Autowired
	private SelectSectionService selectSectionService;
	
	
	@Test
    public void testChooseSection(){
        Professor professor1=new Professor("徐莹","0001","教授","管理学院");
        Professor professor2=new Professor("杨美","123789","教授","管理学院");
        Course course1=new Course("001","高数",5,null);
        Course course2=new Course("002","线代",5,null);
        ArrayList<Course> courses=new ArrayList<>();
        ArrayList<Course> planOfStudy=new ArrayList<>();
        courses.add(course1);
        courses.add(course2);
        Course course3=new Course("003","概率论",5,courses);
        planOfStudy.addAll(courses);
        //planOfStudy.add(course3);

        Section section1=new Section(1,"周二","1.2节","B301",120,course1,professor1);
        Section section2=new Section(2,"周二","1.2节","B301",120,course2,professor1);
        Section section3=new Section(3,"周一","1.2节","B201",120,course3,professor2);
        ArrayList<Section> attends=new ArrayList<>();
        attends.add(section1);
        attends.add(section2);
        //attends.add(section21);//测试OneSection
        Student student=new Student("1","刘欣","123456","2015级","电子商务");
        student.setPlanOfStudy(planOfStudy);//测试planOfStudy
        student.setAttends(attends);

        Section sectionTest1=new Section(1,"周一","1.2节","B201",120,course1,professor1);
        Section sectionTest2=new Section(2,"周三","1.2节","B201",120,course2,professor1);
        Section sectionTest3=new Section(3,"周三","1.2节","B201",120,course3,professor2);
        SelectionSectionSpecification ss=new SelectionSectionSpecification();
        System.out.println(ss.validate(student, sectionTest1));
        System.out.println(ss.validate(student, sectionTest2));
        System.out.println(ss.validate(student, sectionTest3));
    }
}
