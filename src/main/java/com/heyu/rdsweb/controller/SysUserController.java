package com.heyu.rdsweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.heyu.rdsweb.model.SysUser;
import com.heyu.rdsweb.service.SysUserService;

@Controller
public class SysUserController {

	@Autowired
	private SysUserService sysUserService;
	
	@RequestMapping(value = "users")
	@ResponseBody
	public List<SysUser> findAllUser() {
		return sysUserService.findAll();
	}
	
	@RequestMapping(value = "index")
	public String login() {
		return "index";
	}
	
}
