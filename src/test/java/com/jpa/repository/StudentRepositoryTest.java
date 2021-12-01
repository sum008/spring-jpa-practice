package com.jpa.repository;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.TypedSort;

import com.jpa.entity.StudentEntity;
import com.jpa.repository.StudentRepository;

@SpringBootTest
class StudentRepositoryTest {
	@Autowired
	StudentRepository repo;

//	@Test
//	void saveStudents() {
//		
//			GuardianEntity gEntity = GuardianEntity.builder().name("parent").email("parent@gmail.com").mobileNo("1234567890").build();
//		
//			StudentEntity entity =  StudentEntity.builder().firstName("sumit").lastName("kumar").emailId("sumitTest@gmail.com").studentId(5L).guardianEntity(gEntity).build();
//			repo.save(entity);
////			entity =  StudentEntity.builder().firstName("aman").lastName("kumar").emailId("test123@gmail.com").guardianName("ram").studentId(3L).build();
////			repo.save(entity);
////			entity =  StudentEntity.builder().firstName("rr").lastName("kumar").emailId("gg@gmail.com").guardianName("test").studentId(2L).build();
////			repo.save(entity);
//		
//		
//	}
	
//	@Test
//	void showStudents() {
//		TypedSort<StudentEntity> entity = Sort.sort(StudentEntity.class);
//		Sort sort = entity.by(StudentEntity::getStudentId).ascending();
////		Sort sort = Sort.by("studentId").ascending();
//		List<StudentEntity> se=repo.findAll(sort);
//		System.out.println("################################################################################################");
//		se.forEach(val->System.out.println(val.toString()));
//		System.out.println("################################################################################################");
//	}
	
	@Test
	void findStudentsByEmail() {
		List<StudentEntity> se=repo.findByEmailId("test@gmail.com");
		System.out.println(se);
	}
	
	@Test
	void findStudentsByEmailAndFname() {
		List<StudentEntity> se=repo.findByEmailIdAndFirstName("test@gmail.com", "sumit");
		System.out.println(se);
	}
	
	@Test
	@DisplayName("printStudentByEmailUsingQuery")
	void printStudentByEmailUsingQuery() {
		StudentEntity se=repo.getStudentByEmailAddress("test@gmail.com");
		System.out.println(se);
	}
	
	@Test
	@DisplayName("printFirstNameByEmailUsingQuery")
	void printFirstNameByEmailUsingQuery() {
		String se=repo.getFirstNameByEmailAddress("test@gmail.com");
		System.out.println(se);
	}
	
	@Test
	@DisplayName("printStudentByStudentId")
	void printStudentByStudentId() {
		StudentEntity entity = repo.getStudentByStudentId(5L);
		System.out.println(entity);
	}
	
	@Test
	@DisplayName("printStudentByStudentFirstName")
	void printStudentByStudentFirstName() {
		List<StudentEntity> entity = repo.getStudentByStudentFirstName("sumit");
		System.out.println(entity);
	}
	
	@Test
	@DisplayName("updateGuardianPhoneUsingStudentFirstName")
	void updateGuardianPhoneUsingStudentFirstName() {
		repo.updateGuardianPhoneUsingStudentFirstName("sumit", "9999999999");
	}

}
