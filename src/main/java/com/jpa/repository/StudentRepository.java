package com.jpa.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.jpa.baserepository.BaseRepository;
import com.jpa.entity.StudentEntity;

@org.springframework.stereotype.Repository
//@Component
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
	
	List<StudentEntity> findByEmailId(String email);
	
	List<StudentEntity> findByEmailIdAndFirstName(String email, String fName);
	
	//JPQL query
	@Query("select s from StudentEntity s where s.emailId = ?1")
	StudentEntity getStudentByEmailAddress(String email);
	
	//JPQL query
	@Query("select s.firstName from StudentEntity s where s.emailId = ?1")
	String getFirstNameByEmailAddress(String email);
	
	//Native Query
	@Query(value = "select * from tbl_student where student_id = ?1",nativeQuery = true)
	StudentEntity getStudentByStudentId(Long id);
	
	//Native Query with named parameter
	@Query(value = "select * from tbl_student where first_name = :fName", nativeQuery = true)
	List<StudentEntity> getStudentByStudentFirstName(@Param("fName") String studentFirstName);
	
	//Transaction - ideally should be used in service layer where the methods call repository method to do CRUD operation, but
	//for now, I'm doing it here for learning purpose
	//When we are doing any DB operation like insert, update, delete, the @Transactional will allow the changes to be commited in DB only if the operation is
	//successful, otherwise the operation will be rolled back.
	@Transactional
	@Modifying
	@Query(value="update tbl_student set guardian_mobile =:mobile where first_name =:fName", nativeQuery = true)
	int updateGuardianPhoneUsingStudentFirstName(
			 @Param("fName")  String sFirstName,  @Param("mobile")  String gPhoneNo);

	
}
