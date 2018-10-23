package com.mhl.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.mhl.model.Power;

@Mapper
public interface PowerMapper {
	public boolean dele(Integer id);
	public boolean insert(Power bean);
	public boolean update(Power bean);
	public boolean updatexh(Map<String,Integer> map);
	public Power seleone(Integer id);
	public List<Power> sele();
	public List<Power> sele2();
	
}
