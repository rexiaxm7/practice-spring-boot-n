package com.example.management.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;



import com.example.management.Entity.TaskEntity;

public interface TaskRepository extends JpaRepository<TaskEntity, String> {
	
	public Page<TaskEntity> findByUserId(int id , Pageable pageable);
}
