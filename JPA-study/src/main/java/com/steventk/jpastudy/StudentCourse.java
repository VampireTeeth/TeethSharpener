package com.steventk.jpastudy;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "STUDENT_COURSE")
@AssociationOverrides({
	@AssociationOverride(name = "pk.student", joinColumns = @JoinColumn(name = "STUDENT_ID")),
	@AssociationOverride(name = "pk.course", joinColumns = @JoinColumn(name = "COURSE_ID"))
})
public class StudentCourse {

	private StudentCoursePK pk = new StudentCoursePK();

	public StudentCourse(){
	}
	
	public StudentCourse(Student s, Course c) {
		pk.setStudent(s);
		pk.setCourse(c);
	}

	@EmbeddedId
	public StudentCoursePK getPk() {
		return pk;
	}

	public void setPk(StudentCoursePK pk) {
		this.pk = pk;
	}

	@Transient
	public Student getStudent() {
		return pk.getStudent();
	}
	
	public void setStudent(Student student) {
		pk.setStudent(student);
	}
	
	@Transient
	public Course getCourse() {
		return pk.getCourse();
	}
	
	public void setCourse(Course course) {
		pk.setCourse(course);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pk == null) ? 0 : pk.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentCourse other = (StudentCourse) obj;
		if (pk == null) {
			if (other.pk != null)
				return false;
		} else if (!pk.equals(other.pk))
			return false;
		return true;
	}

	
}
