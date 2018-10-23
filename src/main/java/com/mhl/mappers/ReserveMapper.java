package com.mhl.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.mhl.model.Charts;
import com.mhl.model.Reserve;

@Mapper
public interface ReserveMapper {
	public boolean insert(Reserve bean);
	public boolean update(Reserve bean);
	public boolean dele(int id);
	public List<Reserve> sele(Map<String,Object> map);
	public Reserve seleone(int id);
	public List<Charts> selectPersons(String year);
}
