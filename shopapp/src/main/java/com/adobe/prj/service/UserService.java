package com.adobe.prj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.adobe.prj.dao.UserDao;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;

	public UserDetailsService userDetailsService() {
		return new UserDetailsService() {
			@Override
			public UserDetails loadUserByUsername(String username) {
				return userDao.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
			}
		};
	}
}
