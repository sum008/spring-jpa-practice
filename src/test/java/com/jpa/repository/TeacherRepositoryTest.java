package com.jpa.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jpa.entity.CourseEntity;
import com.jpa.entity.CourseMaterialEntity;
import com.jpa.entity.TeacherEntity;

@SpringBootTest
class TeacherRepositoryTest {

	@Autowired
	private TeacherRepository repo;
	
	@Autowired
	private CourseMaterialRepository repo1;
	
	
	@Test
	void saveTeacherData() {
		
		CourseEntity course = CourseEntity.builder().credits(6).title("Deep Learning").build();
		CourseEntity course1 = CourseEntity.builder().credits(7).title("Algo Design").build();
		
//		CourseEntity course1 = CourseEntity.builder().credits(5).title("Computer Networks").build();
		
//		TeacherEntity teacher = TeacherEntity.builder().firstName("cs teacher").lastName("last").courseEntity(Set.of(course, course1)).build();
//		repo.save(teacher);
	}
	
	@Test
	void saveTeacherDataWithCourseMaterial() {
		
		CourseEntity course = CourseEntity.builder().credits(6).title("Deep Learning").build();
		CourseEntity course1 = CourseEntity.builder().credits(7).title("Algo Design").build();
		
		CourseMaterialEntity material = CourseMaterialEntity.builder().url("www.deepLearning.com").course(course).build();
		CourseMaterialEntity material1 = CourseMaterialEntity.builder().url("www.algoDesign.com").course(course1).build();
		
		repo1.saveAll(List.of(material, material1));
		
//		CourseEntity course1 = CourseEntity.builder().credits(5).title("Computer Networks").build();
		
//		TeacherEntity teacher = TeacherEntity.builder().firstName("cs teacher").lastName("last").courseEntity(Set.of(course, course1)).build();
//		repo.save(teacher);
	}

}
