package com.example.management.mappers;

import org.apache.ibatis.annotations.Mapper;

import com.example.management.domains.model.User;

@Mapper
public interface UserMapper {
	void add(User user);

	User findById(User user);

	void update(User user);
}
