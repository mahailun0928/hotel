package com.mhl.bizs;

import java.util.List;
import java.util.Map;

import com.mhl.model.Power;

public interface IPowerBiz {
	public boolean save(Power bean);
	public boolean updatexh(Map<String,Integer> map);
	public List<Power> query();
	public List<Power> query2();
	public boolean remove(Integer id);
	public Power find(Integer id);
}
