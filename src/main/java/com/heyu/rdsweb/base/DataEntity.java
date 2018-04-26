package com.heyu.rdsweb.base;

import java.util.Date;

import com.heyu.rdsweb.model.SysUser;


public class DataEntity extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7644629932559984448L;

	protected String remark;
	
	//@JoinColumn(name = "update_by")
	protected SysUser createBy;
	
	protected Date createDate;
	
	//@JoinColumn(name = "update_by")
	protected SysUser updateBy;
	
	protected Date updateDate;
	
	protected boolean delFlag;

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public SysUser getCreateBy() {
		return createBy;
	}

	public void setCreateBy(SysUser createBy) {
		this.createBy = createBy;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public SysUser getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(SysUser updateBy) {
		this.updateBy = updateBy;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public boolean getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(boolean delFlag) {
		this.delFlag = delFlag;
	}
	
	public DataEntity() {
		super();
	}
}
