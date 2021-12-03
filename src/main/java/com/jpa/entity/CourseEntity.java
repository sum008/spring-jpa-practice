package com.jpa.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "TBL_COURSE")
public class CourseEntity {
	
	@Id
	@SequenceGenerator(name = "course_sequence",sequenceName = "course_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "course_sequence")
	private Long courseId;
	private String title;
	private Integer credits;
	
	@OneToOne(mappedBy = "course")
	private CourseMaterialEntity courseMaterialEntity;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "teacher_id",referencedColumnName = "teacherId")
	private TeacherEntity teacherEntity;
	
	
	/*
	 * below @JoinTable(...) annotation will create a new table with the name defined in annotation
	 * param with ->name<-, the joinColumns will take an array of @JoinColumn annno.
	 * and the annotation will take in name which signifies the foreign key (and
	 * primary key of current table, here it will be "course_id") the
	 * inverseJoinColumn will also take array of @JoinColumn, but here the name will
	 * define the foreign key of the table which this (current) table is making
	 * relation (here it will be student_id as course is making relation with
	 * student) so, @JoinTable will create a table with 2 columns 
	 * 1. course_id (foreign key -> primary key of course table) 
	 * 2. student_id (foreign key -> primary key of student table)
	 */
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "student_course_map", 
	joinColumns = @JoinColumn(name="course_id",referencedColumnName = "courseId"),
	inverseJoinColumns = @JoinColumn(name="studentId", referencedColumnName = "student_id"))
	private Set<StudentEntity> studentEntity;
}
