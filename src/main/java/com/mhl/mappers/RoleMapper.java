package com.mhl.mappers;

import org.apache.ibatis.annotations.Mapper;

import com.mhl.model.Role;

@Mapper
public interface RoleMapper {
	public boolean insert(Role bean);
	public boolean dele(int aid);
}
