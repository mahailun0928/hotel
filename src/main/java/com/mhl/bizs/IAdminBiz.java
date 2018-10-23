package com.mhl.bizs;

import java.util.List;

import com.mhl.model.Admin;

public interface IAdminBiz {
	public boolean save(Admin bean,List<Integer> pids);
	public boolean remove(int id);
	public List<Admin> query();
	public Admin find(Admin bean);
	public Admin get(int id);
	public boolean changepwd(Admin admin);
}
