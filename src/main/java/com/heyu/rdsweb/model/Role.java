package com.heyu.rdsweb.model;

import javax.validation.constraints.NotBlank;

import com.heyu.framework.entity.DataEntity;

public class Role extends DataEntity<Role>{

	private static final long serialVersionUID = -591304995917958116L;
	
	@NotBlank
	private String roleName;
	
}
