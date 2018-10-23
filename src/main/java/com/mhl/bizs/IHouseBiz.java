package com.mhl.bizs;
import com.mhl.model.*;
import java.util.List;
import java.util.Map;

public interface IHouseBiz{
	public boolean save(House house);
	public boolean updateimg(House house);
	public boolean dele(int id);
	public boolean enable(int id,int status);
	public House seleone(int id);
	public List<House> sele(Map<String,Object> map);
	public List<House> sele2(Map<String,Object> map);

	public List<Charts> selebykind();
}