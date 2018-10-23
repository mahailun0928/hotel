package com.mhl.mappers;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mhl.model.*;
@Mapper
public interface KindMapper{
	public boolean insert(Kind bean);
	public Kind selectOne(int id);
	public boolean delete(int id);
	public List<Kind> select();
	public List<Kind> select2();
	public boolean update(Kind bean);
}