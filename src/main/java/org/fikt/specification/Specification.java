package org.fikt.specification;

import org.fikt.domain.Section;
import org.fikt.domain.Student;

public interface Specification<T> {
	String validate(Student student, Section section);
}
