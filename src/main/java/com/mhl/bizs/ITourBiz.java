package com.mhl.bizs;
import com.mhl.model.*;

import java.util.List;
import java.util.Map;

public interface ITourBiz{
	public boolean save(Tour tour);
	public boolean remove(Integer id);
	public Tour find(Integer id);
	public List<Tour> query(Map<String,Object> map);
}