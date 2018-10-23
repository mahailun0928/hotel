package com.mhl.bizs;

import java.util.List;
import java.util.Map;

import com.mhl.model.Hprice;

public interface IHpeicebiz {
	public List<Hprice> query();
	public Hprice find(int id);
	public boolean save(Hprice bean);
	public boolean remove(int id);
	public Hprice query2(Map<String,Object> map);
}
