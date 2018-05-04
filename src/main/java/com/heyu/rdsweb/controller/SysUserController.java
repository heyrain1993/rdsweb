package com.heyu.rdsweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.heyu.framework.exception.CommonException;
import com.heyu.framework.exception.PageException;
import com.heyu.rdsweb.model.SysUser;
import com.heyu.rdsweb.service.SysUserService;

@Controller
public class SysUserController {

	@Autowired
	private SysUserService sysUserService;
	
	@RequestMapping(value = "users",method = RequestMethod.GET)
	@ResponseBody
	public List<SysUser> findAllUser() {
		return sysUserService.findAll();
	}
	
	
	@RequestMapping(value = "error",method = RequestMethod.GET)
	public String error() {
		return "error";
	}
	
	@RequestMapping(value = "testjson",method = RequestMethod.GET)
	public String testJson() throws CommonException {
		
		throw new CommonException(1,"错误");
		
	}
	
	@RequestMapping(value = "testpage",method = RequestMethod.GET)
	public String testpage() throws PageException {
		try {
			
		} catch (Exception e) {
			throw new PageException();
		}
		throw new PageException();
	}
}
