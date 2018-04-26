package com.heyu.rdsweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@RequestMapping(value = "index",method = RequestMethod.GET)
	public String index() {
		return "index";
	}
	
	@RequestMapping(value = "/",method = RequestMethod.GET )
	public String login(@RequestParam(value="message",required=false) String message,Model model) {
		model.addAttribute("message", message);
		return "login";
	}
	
	@RequestMapping(value = "error",method = RequestMethod.GET)
	public String error() {
		return "error";
	}
	
}
