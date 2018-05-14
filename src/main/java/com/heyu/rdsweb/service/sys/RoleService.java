package com.heyu.rdsweb.service.sys;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heyu.framework.entity.Page;
import com.heyu.framework.service.BaseService;
import com.heyu.framework.utils.ValidatorUtil;
import com.heyu.rdsweb.dao.RoleDao;
import com.heyu.rdsweb.model.Role;

@Service
public class RoleService extends BaseService{
	@Autowired
	protected RoleDao roleDao;

	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public Role findById(String id) {
		return this.roleDao.findById(id);
	}

	/**
	 * 查询实体类
	 * @param role
	 * @return
	 */
	public Role find(Role role) {
		return this.roleDao.find(role);
	}

	/**
	 * 查询实体-不分页
	 * @param role
	 * @return
	 */
	public List<Role> findList(Role role){
		return this.roleDao.findAllList(role);
	}

	/**
	 * 查询实体-分页
	 * 根据page中的pageNo和pageSize获取记录以及总记录数等
	 * 再将实体记录设置进page，并返回page
	 * @param page
	 * @param role
	 * @return
	 */
	public Page<Role> findPage(Page<Role> page, Role role){
		role.setPage(page);
		List<Role> list = this.roleDao.findList(role);
		page.setList(list);
		return page;
	}

	/**
	 * 保存实体-判断是否是新纪录(新纪录：调用preInsert；旧记录：调用preUpdate)
	 * @param role
	 * @return
	 */
	public int save(Role role) {
		if(role.isNewRecord()){
			role.preInsert();
			ValidatorUtil.validateEntity(role);
			return this.roleDao.insert(role);

		}else{
			role.preUpdate();
			ValidatorUtil.validateEntity(role);
			return this.roleDao.update(role);
		}
	}

	/**
	 * 删除实体
	 * @param role
	 * @return
	 */
	public int delete(Role role) {
		return this.roleDao.delete(role);
	}

	/**
	 * 根据ids批量删除实体
	 * @param ids
	 * @return
	 */
	public boolean deleteBatch(String[] ids) {
		if (ids == null || ids.length == 0){
			return false;
		}
		if (this.roleDao.deleteBatch(ids) == 0){
			return false;
		}
		return true;
	}
}
