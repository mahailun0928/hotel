package com.mhl.mappers;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.mhl.model.*;
@Mapper
public interface HouseMapper{
	public boolean insert(House bean);
	public House selectOne(int id);
	public boolean delete(int id);
	public boolean enable(House house);
	public boolean updateimg(House house);
	public List<House> select(Map<String,Object> map);
	public List<Charts> selectbykind();
	public boolean update(House bean);
	public List<House> select2(Map<String,Object> map);
}