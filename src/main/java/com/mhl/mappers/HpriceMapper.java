package com.mhl.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.mhl.model.Hprice;
@Mapper
public interface HpriceMapper {
	public boolean insert(Hprice bean);
	public boolean update(Hprice bean);
	public boolean dele(int id);
	public List<Hprice> sele();
	public Hprice seleone(int id);
	public Hprice sele2(Map<String,Object> map);
}
