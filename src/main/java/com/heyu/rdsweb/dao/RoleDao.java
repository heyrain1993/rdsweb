package com.heyu.rdsweb.dao;

import org.apache.ibatis.annotations.Mapper;

import com.heyu.framework.dao.CurdDao;
import com.heyu.rdsweb.model.Role;

@Mapper
public interface RoleDao extends CurdDao<Role>{
}
