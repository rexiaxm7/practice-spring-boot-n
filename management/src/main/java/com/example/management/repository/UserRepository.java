package com.example.management.repository;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.management.Entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String>{
	public Page<UserEntity> findAll(Pageable pageable);
}