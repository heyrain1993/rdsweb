package com.heyu.rdsweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heyu.rdsweb.dao.SysUserDao;
import com.heyu.rdsweb.model.SysUser;

@Service
public class SysUserService {

	@Autowired
	private SysUserDao sysUserDao;
	
	public List<SysUser> findAll() {
		return sysUserDao.findAll();
	}

	public SysUser findByUsername(String username) {
		
		return sysUserDao.findByUsername(username);
	}

}
