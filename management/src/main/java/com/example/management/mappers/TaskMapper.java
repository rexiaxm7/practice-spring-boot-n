package com.example.management.mappers;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.management.domains.model.Task;


@Mapper
public interface  TaskMapper {
	 List<Task> all();
	 Task findById(Task task);
	 Page<Task> findPage(@Param("pageable") Pageable pageable);
	 void add(Task task);
	 void testInsert();
	 void testInsert2();
	 void addName(Task task);
	 void addNum(Task task);
	 void done(Task task);
	 void delete(Task task);
	 void update(Task task);
}
