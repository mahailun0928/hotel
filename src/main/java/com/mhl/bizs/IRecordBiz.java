package com.mhl.bizs;

import java.util.List;
import java.util.Map;

import com.mhl.model.Charts;
import com.mhl.model.Record;

public interface IRecordBiz {
	public boolean remove(int id,String date);
	public Record find(int id);
	public List<Record> query(Map<String,Object> map);
	public boolean save(Record bean);
	public List<Charts> selebymonth(String year);
}
