package com.heyu.rdsweb.controller.sys;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.heyu.framework.controller.BaseController;
import com.heyu.framework.model.Page;
import com.heyu.rdsweb.model.Role;
import com.heyu.rdsweb.service.sys.RoleService;

@Controller
@RequestMapping(value="/role")
public class RoleController extends BaseController{
	
	@Autowired
	private RoleService roleService;
	
	@RequestMapping()
	public String get(@RequestParam(value="id")String id,Model model) {
		Role role = roleService.findById(id);
		model.addAttribute("role", role);
		return "admin/sys/roleForm";
	}
	
	/**
	 * 根据条件分页查询
	 * @param request 请求
	 * @param response 响应
	 * @param role 实体类
	 * @param model
	 * @return
	 */
	@RequestMapping(value="list",method=RequestMethod.POST)
	public String list(HttpServletRequest request,HttpServletResponse response,Role role,Model model){
		Page<Role> page = new Page<Role>(request);
		Page<Role> result = roleService.findPage(page,role);
		model.addAttribute("page", result);
		return "admin/sys/roleList";
	}
	
	/**
	 * 根据条件查询所有
	 * @param role 实体类
	 * @return
	 */
	@RequestMapping(value = "findAll",method=RequestMethod.POST)
	@ResponseBody
	public List<Role> findAll(Role role){
		List<Role> lists = roleService.findList(role);
		return lists;
	}
	
	/**
	 * 根据id查询实体类
	 * @param id 
	 * @param model
	 * @return
	 */
	@RequestMapping(value="form",method=RequestMethod.POST)
	public String form(@RequestParam("id")String id,Model model) {
		Role role = new Role();

		model.addAttribute("role",role);
		return "admin/sys/roleForm";
	}
	
	/**
	 * 保存-使用validate校验
	 * @param role
	 * @return
	 */
	@RequestMapping(value="save",method=RequestMethod.POST)
	public String save(Role role) {

		roleService.save(role);
		return "redirect:/role/list";
	}
	
	/**
	 * 删除实体类
	 * @param role
	 * @return
	 */
	@RequestMapping(value="delete",method=RequestMethod.POST)
	public String delete(Role role) {
		roleService.delete(role);
		return "redirect:/role/list";
	}
	
}
