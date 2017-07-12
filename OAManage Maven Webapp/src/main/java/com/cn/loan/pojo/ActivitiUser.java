package com.cn.loan.pojo;

import org.activiti.engine.impl.persistence.entity.UserEntity;

public class ActivitiUser extends UserEntity{
	
	private String groupName;
	private String groupId;
	
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
}
