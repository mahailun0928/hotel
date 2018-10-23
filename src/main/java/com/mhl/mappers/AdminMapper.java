package com.mhl.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mhl.model.Admin;

@Mapper
public interface AdminMapper {
	public boolean dele(Integer id);
	public boolean insert(Admin bean);
	public boolean update(Admin bean);
	public Admin selebyid(int id);
	public List<Admin> sele();
	public Admin seleone(Admin bean);
	public boolean updatepwd(Admin admin);
	
}
