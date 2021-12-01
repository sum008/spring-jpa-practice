package com.jpa.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(exclude = "courseEntity")
@Builder
@Table(name="tbl_teacher")
public class TeacherEntity {

	@Id
	@SequenceGenerator(name = "teacherId_sequence",sequenceName = "teacherId_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teacherId_sequence")
	private Long teacherId;
	private String firstName;
	private String lastName;
	
	/*
	 * below is the one to many relation, one teacher can teach many courses, so the
	 * Course table will contain teacher_id column which will refer to a particular
	 * teacher it will pass the current teacher_id to all the courses which teacher
	 * is teaching, thats why we have used Set/List here (one teacher_id -> many
	 * courses)
	 * 
	 * this is not the right way of doing relations, always try to use manyToOne
	 * relation as it is more easy to read and understand
	 */
//	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//	@JoinColumn(referencedColumnName = "teacherId",name = "teacher_id")
//	private Set<CourseEntity> courseEntity;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
