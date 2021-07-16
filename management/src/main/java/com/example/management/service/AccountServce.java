package com.example.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.management.details.AccountDetails;
import com.example.management.domains.model.Account;
import com.example.management.repository.AccountRepository;

@Service
public class AccountServce implements UserDetailsService {
	@Autowired
	private AccountRepository accountRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account account = accountRepository.findById(username);
		if (account == null) {
			throw new UsernameNotFoundException(username + " is not found");
		}
		return new AccountDetails(account);
	}

}
