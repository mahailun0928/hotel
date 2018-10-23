package com.mhl.bizs;

import com.mhl.model.Company;

public interface ICompanybiz {
	public boolean save(Company bean);
	public boolean saveimg(Company bean);
	public Company query();
}
