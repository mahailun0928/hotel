package com.mhl.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.mhl.model.Charts;
import com.mhl.model.Record;
@Mapper
public interface RecordMapper {
	public boolean insert(Record bean);
	public boolean update(Record bean);
	public boolean dele(Record bean);
	public List<Record> sele(Map<String,Object> map);
	public Record seleone(int id);
	public List<Charts> selectPersons(String year);
}
