package com.example.management.details;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.management.domains.model.Account;

public class AccountDetails implements UserDetails {

	private Account account;

	public AccountDetails(Account account) {
		this.account = account;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return AuthorityUtils.createAuthorityList(account.getRole());
	}

	@Override
	public String getPassword() {
		return account.getPassword();
	}

	@Override
	public String getUsername() {
		return account.getLogin_id();
	}

	@Override
	// アカウントが有効期限内であるか
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	// アカウントがロックされていないか
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	// 資格情報が有効期限内であるか
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	// 有効なアカウントであるか
	public boolean isEnabled() {
		return true;
	}

}