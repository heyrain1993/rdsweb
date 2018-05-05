package com.heyu.rdsweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	@RequestMapping(value = "userList",method = RequestMethod.GET)
	public String findAllUser(Model model) {
		List<SysUser> users = sysUserService.findAll();
		model.addAttribute("users", users);
		return "admin/genCode/tableList";
	}
	
	@RequestMapping(value = "userForm",method = RequestMethod.GET)
	public String addUser() {
		/*List<SysUser> users = sysUserService.findAll();
		model.addAttribute("users", users);*/
		return "admin/genCode/tableForm";
	}
	
	@RequestMapping(value = "user",method = RequestMethod.POST)
	public String addUser(SysUser user) {
		sysUserService.addUser(user);
		/*List<SysUser> users = sysUserService.findAll();
		model.addAttribute("users", users);*/
		return "redirect:userList";
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
