package com.example.management.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.management.Entity.UserEntity;
import com.example.management.domains.model.User;
import com.example.management.form.UserAddForm;
import com.example.management.form.UserUpdateForm;
import com.example.management.mappers.UserMapper;
import com.example.management.repository.UserRepository;

@Service
public class UserService {

	
	private final UserMapper UserMapper;

	@Autowired
	UserRepository userRepository;

	@Autowired
	PasswordEncoder passwordEncoder;
	
	public UserService(UserMapper userMapper) {
		this.UserMapper = userMapper;
		// TODO Auto-generated constructor stub
	}

	public Page<UserEntity> findList(Pageable pageable) {
		return userRepository.findAll(pageable);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void addTest(UserAddForm userAddForm) {
		addUser(userAddForm);
	}

	private void addUser(UserAddForm userAddForm) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date expiration_date = null;
		Date registration_date = null;
		try {
			expiration_date = dateFormat.parse(userAddForm.getExpiration_date());
			registration_date = dateFormat.parse(userAddForm.getRegistration_date());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		User user = new User(userAddForm.getLogin_id(), userAddForm.getName(),passwordEncoder.encode(userAddForm.getPassword()) , userAddForm.getRole(), registration_date,expiration_date);
		UserMapper.add(user);
	}

	public User findOne(String userId) {
		User user = new User(Integer.parseInt(userId));
		return UserMapper.findById(user);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void updateUser(UserUpdateForm updateForm) {
		User user = new User(Integer.parseInt(updateForm.getId()), updateForm.getLogin_id(), updateForm.getName());
		UserMapper.update(user);
	}

}
