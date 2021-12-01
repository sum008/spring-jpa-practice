package com.jpa.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.jpa.entity.CourseEntity;
import com.jpa.entity.CourseMaterialEntity;
import com.jpa.entity.StudentEntity;
import com.jpa.entity.TeacherEntity;

@SpringBootTest
class CourseRepositoryTest {

	@Autowired
	CourseRepository repo;
	
	@Autowired
	CourseMaterialRepository courseMaterialRepo;
	
	@Test
	void showAllCourses() {
		List<CourseEntity> ce = repo.findAll();
		System.out.println(ce);
	}
	
	@Test
	void saveCourseWithTeacherData() {
		TeacherEntity teacher = TeacherEntity.builder().firstName("lallu").lastName("sharma").build();
		
		CourseEntity entity = CourseEntity.builder().title(".net").credits(5).teacherEntity(teacher).build();
		CourseEntity entity1 = CourseEntity.builder().title("python").credits(6).teacherEntity(teacher).build();
		
		repo.saveAll(List.of(entity,entity1));
	}
	
	@Test
	void findAllRecordWithPagination() {
		Pageable paged = PageRequest.of(0, 50); //first parameter= page index from which you want to get the record, 2nd param= not. of records per page
												//so each index will contain records defined in 2nd param, so nextIndex = curInd+2ndParam
		System.out.println("#######################################");
		Page<CourseEntity> ent=repo.findAll(paged);
		System.out.println("----------------------------------------");
		System.out.println("Total elements: "+ent.getTotalElements());
		System.out.println("Total pages: "+ent.getTotalPages());
		ent.forEach(System.out::println);
		System.out.println("#######################################");
	}
	
	@Test
	void findAllWithPagedAndSorted() {
		Pageable paged = PageRequest.of(0, 5, Sort.by("title"));
		
		System.out.println("#######################################");
		Page<CourseEntity> ent=repo.findAll(paged);
		System.out.println("----------------------------------------");
		System.out.println("Total elements: "+ent.getTotalElements());
		System.out.println("Total pages: "+ent.getTotalPages());
		ent.forEach(System.out::println);
		System.out.println("#######################################");
	}
	
	@Test
	void findAllSortedRecords() {
		Sort s=Sort.by("courseId").ascending();
		System.out.println("---------------------------------------------------------------");
		repo.findAll(s).forEach(System.out::println);
		System.out.println("---------------------------------------------------------------");
	}
	
	
	@Test void findBySort() {
		Sort s=Sort.by("credits").ascending();
		System.out.println("---------------------------------------------------------------");
		repo.findBy(s).forEach(System.out::println);
		System.out.println("---------------------------------------------------------------");

	}
	
	@Test
	void findByCourseId() {
		Pageable page = PageRequest.of(0, 5, Sort.by("courseId"));
		System.out.println("---------------------------------------------------------------");
		repo.findByTitleContaining("A", page).forEach(System.out::println);
		System.out.println("---------------------------------------------------------------");
	}
	
	//ManyToMany
	@Test
	void addCourseAndStudent() {
		StudentEntity student = StudentEntity.builder().firstName("raja").lastName("rangila").emailId("raja@rangila.com").build();
		StudentEntity student1 = StudentEntity.builder().firstName("sumit").lastName("kumar").emailId("sumit@gmail.com").build();
		
		TeacherEntity teacher = TeacherEntity.builder().firstName("bablu1").lastName("panwadi1").build();
		
		Set<StudentEntity> s=Set.of(student,student1);
		
		CourseEntity course = CourseEntity.builder().credits(8).title("Spring JPA").studentEntity(s).teacherEntity(teacher).build();
		
		repo.save(course);
	}
	//ManyToMany
	@Test
	void addCourseAndStudentV2() {
		StudentEntity student = StudentEntity.builder().firstName("tt").lastName("yy").emailId("tt@yy.com").build();
		StudentEntity student1 = StudentEntity.builder().firstName("kk").lastName("jj").emailId("kk@jj.com").build();
		
		TeacherEntity teacher = TeacherEntity.builder().firstName("vv").lastName("nn").build();
		
		Set<StudentEntity> s=Set.of(student,student1);
		
		CourseEntity course = CourseEntity.builder().credits(8).title("pygame").studentEntity(s).teacherEntity(teacher).build();
		
		CourseEntity course1 = CourseEntity.builder().credits(10).title("c++").studentEntity(s).teacherEntity(teacher).build();
		
		repo.saveAll(List.of(course, course1));
	}
	
	@Test
	void saveAllDataTogether() {
		StudentEntity student = StudentEntity.builder().firstName("aa").lastName("aa").emailId("aa@aa.com").build();
		StudentEntity student1 = StudentEntity.builder().firstName("bb").lastName("bb").emailId("bb@bb.com").build();
		
		TeacherEntity teacher = TeacherEntity.builder().firstName("cc").lastName("cc").build();
		
		Set<StudentEntity> s=Set.of(student,student1);
		
		CourseEntity course = CourseEntity.builder().credits(8).title("hadoop").studentEntity(s).teacherEntity(teacher).build();
		
		CourseEntity course1 = CourseEntity.builder().credits(10).title("scala").studentEntity(s).teacherEntity(teacher).build();
		
		CourseMaterialEntity mat = CourseMaterialEntity.builder().url("materialA.com").course(course).build();
		
		CourseMaterialEntity mat1 = CourseMaterialEntity.builder().url("materialB.com").course(course1).build();
		
		courseMaterialRepo.saveAll(List.of(mat,mat1));
	}
	
	
	
	
	

}
