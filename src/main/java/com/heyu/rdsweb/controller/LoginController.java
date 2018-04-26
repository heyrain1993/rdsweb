package com.heyu.rdsweb.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.heyu.rdsweb.model.SysUser;

@Controller
public class LoginController {

	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public String login(HttpServletRequest request,SysUser user,Model model,RedirectAttributes redirectAttributes) {
		System.out.println("快速登录使用");
		if(user == null || StringUtils.isEmpty(user.getUsername()) || StringUtils.isEmpty(user.getPassword())) {
			redirectAttributes.addAttribute("message", "用户名或密码不能为空");
			return "redirect:/";
		}
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(),user.getPassword());
		try {
			
			subject.login(token);
			System.out.println("index");
			return "index";
		} catch (AuthenticationException  e) {
			token.clear();
			redirectAttributes.addAttribute("message", "用户名或密码不存在");
			System.out.println("\"redirect:/\"");
			return "redirect:/";
		}
	}
}
