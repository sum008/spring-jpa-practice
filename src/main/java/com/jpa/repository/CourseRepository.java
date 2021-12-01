package com.jpa.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.entity.CourseEntity;

public interface CourseRepository extends JpaRepository<CourseEntity, Long>{
	
	List<CourseEntity> findBy(Sort sort);
	
	List<CourseEntity> findByTitleContaining(String title, Pageable pageable);

}
