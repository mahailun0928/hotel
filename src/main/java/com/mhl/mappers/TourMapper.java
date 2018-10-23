package com.mhl.mappers;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.mhl.model.*;
@Mapper
public interface TourMapper{
	public boolean insert(Tour bean);
	public Tour selectone(Integer id);
	public boolean delete(Integer id);
	public List<Tour> select(Map<String,Object> map);
	public boolean update(Tour bean);
}