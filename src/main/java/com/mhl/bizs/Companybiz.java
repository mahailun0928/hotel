package com.mhl.bizs;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mhl.mappers.CompanyMapper;
import com.mhl.model.Company;
@Service
public class Companybiz implements ICompanybiz {
	@Resource
	private CompanyMapper mapper;
	@Override
	public boolean save(Company bean) {
		return this.mapper.update(bean);
	}

	@Override
	public boolean saveimg(Company bean) {
		return this.mapper.updateimg(bean);
	}

	@Override
	public Company query() {
		return this.mapper.seleone();
	}

}
