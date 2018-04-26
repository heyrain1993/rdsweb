package com.heyu.rdsweb.base;

import java.io.Serializable;

import org.springframework.util.StringUtils;

public class BaseEntity implements Serializable{
	
	/**
	 * 设置实体类可序列化
	 */
	private static final long serialVersionUID = 1L;
	
	protected String id;

	private boolean isNewRecord = false;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isNewRecord() {
		return isNewRecord || StringUtils.isEmpty(getId());
	}

	public void setNewRecord(boolean isNewRecord) {
		this.isNewRecord = isNewRecord;
	}
	
	public BaseEntity() {
		
	}
}
