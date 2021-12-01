package com.jpa.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jpa.entity.CourseEntity;
import com.jpa.entity.CourseMaterialEntity;
import com.jpa.repository.CourseMaterialRepository;

@SpringBootTest
class CourseMaterialRepositoryTest {
	
	@Autowired
	private CourseMaterialRepository repo;

	@Test
	void addCourseMaterial() {
		
		CourseEntity course = CourseEntity.builder().credits(6).title("Java").build();
		//CourseEntity course1 = CourseEntity.builder().credits(7).title("Algo Design").build();
		
		CourseMaterialEntity material = CourseMaterialEntity.builder()
				.url("www.deepLearning.com")
				.course(course)
				.build();
		//CourseMaterialEntity material1 = CourseMaterialEntity.builder().url("www.algoDesign.com").course(course1).build();
		repo.save(material);
//		repo.saveAll(List.of(material, material1));
	}
	
	@Test
	void fetchtypeTestByGettingCourseMaterial() {
		List<CourseMaterialEntity> material = repo.findAll();
		System.out.println(material);
	}

}
