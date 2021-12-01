package com.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.entity.TeacherEntity;

public interface TeacherRepository extends JpaRepository<TeacherEntity, Long>{

}
