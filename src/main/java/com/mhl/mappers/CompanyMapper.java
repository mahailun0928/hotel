package com.mhl.mappers;

import org.apache.ibatis.annotations.Mapper;

import com.mhl.model.Company;
@Mapper
public interface CompanyMapper {
	public Company seleone();
	public boolean update(Company bean);
	public boolean updateimg(Company bean);
}
