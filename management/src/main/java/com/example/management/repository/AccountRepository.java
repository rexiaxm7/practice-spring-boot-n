package com.example.management.repository;

import org.apache.ibatis.annotations.Mapper;
import com.example.management.domains.model.Account;

@Mapper
public interface AccountRepository {
	public Account findById(String login_id);
}