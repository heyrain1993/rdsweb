package com.heyu.rdsweb.dao;

import java.util.List;

import com.heyu.framework.entity.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.heyu.rdsweb.model.SysUser;

@Mapper
public interface SysUserDao {
	/**
	 * 根据主键删除
	 * @param id
	 * @return
	 */
    int deleteByPrimaryKey(String id);

    /**
     * 插入实体类
     * @param record
     * @return
     */
    int insert(SysUser record);

    /**
     * 插入实体类：为空的字段不插入
     * @param record
     * @return
     */
    int insertSelective(SysUser record);

    /**
     * 根据主键查询
     * @param id
     * @return
     */
    SysUser selectByPrimaryKey(String id);

    /**
     * 根据主键更新：为空的字段不更新
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(SysUser record);

    /**
     * 更新实体类
     * @param record
     * @return
     */
    int updateByPrimaryKey(SysUser record);

    /**
     * 查询所有用户
     * @return
     */
	public List<SysUser> findAll();

	/**
	 * 根据用户名查询用户信息
	 * @param username
	 * @return
	 */
	SysUser findByUsername(@Param("username")String username);

	public List<SysUser> findPage(SysUser sysUser);
}