package com.jpa.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "course")
@Table(name = "TBL_COURSE_MATERIAL")
public class CourseMaterialEntity {

	@Id
	@SequenceGenerator(name = "course_material_sequence",sequenceName = "course_material_sequence",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_material_sequence")
	private Long courseMaterialId;
	private String url;
	
	//providing below details in CourseMaterial because CourseMaterial depends on Course, so before inserting CourseMaterial the code will insert Course
	//but if we provide same config in Course class, then that will mean that Course depends upon CourseMaterial, which does not sounds correct.
	//CourseMaterial will only exists if and only if the Course exists
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "course_id", referencedColumnName = "courseId")
	private CourseEntity course;
}
