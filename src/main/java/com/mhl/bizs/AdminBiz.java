package com.mhl.bizs;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mhl.mappers.AdminMapper;
import com.mhl.mappers.RoleMapper;
import com.mhl.model.Admin;
import com.mhl.model.Role;
@Service
public class AdminBiz implements IAdminBiz {
	@Resource
	private AdminMapper mapper;
	@Resource
	private RoleMapper dao;
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public boolean save(Admin bean,List<Integer> pids) {
		boolean flag=true;
		if(bean.getId()!=null) {
			if(mapper.update(bean)) {
				if(dao.dele(bean.getId())) {
					for(int p : pids) {
						Role role=new Role(bean.getId(),p);
						if(!dao.insert(role)) {
							flag=false;
							break;
						}
					}
				}
			}
		}else {
			if(mapper.insert(bean)) {
				for (int p : pids) {
					Role role=new Role(bean.getId(),p);
					if(!dao.insert(role)){
						flag=true;
						break;
					}
				}
			}
		}
		return flag;
	}

	@Override
	public boolean remove(int id) {
		return this.mapper.dele(id);
	}

	@Override
	public List<Admin> query() {
		return this.mapper.sele();
	}

	@Override
	public Admin find(Admin bean) {
		return this.mapper.seleone(bean);
	}

	@Override
	public Admin get(int id) {
		return mapper.selebyid(id);
	}

	@Override
	public boolean changepwd(Admin admin) {
		
		return mapper.updatepwd(admin);
	}

}
