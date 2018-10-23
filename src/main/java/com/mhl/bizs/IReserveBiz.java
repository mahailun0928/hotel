package com.mhl.bizs;

import java.util.List;
import java.util.Map;

import com.mhl.model.Charts;
//import com.mhl.model.Hprice;
import com.mhl.model.Reserve;

public interface IReserveBiz {
	public boolean remove(int id);
	public Reserve find(int id);
	public List<Reserve> query(Map<String,Object> map);
	public boolean save(Reserve bean);
	public boolean change(int id);
	public List<Charts> selebymonth(String year);
	
}
