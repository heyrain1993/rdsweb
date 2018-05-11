package com.heyu.rdsweb.service.sys;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.heyu.framework.entity.Page;
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

	
	public void addUser(SysUser user) {
		user.setId(UUID.randomUUID().toString());
		sysUserDao.insert(user);
		//return sysUserDao.findByUsername(username);
	}

	public List<SysUser> findPage(SysUser sysUser){

		Page<SysUser> page = new Page<>();
		page.setPageSize(1);
		sysUser.setPage(page);
		return sysUserDao.findPage(sysUser);
	}
}
