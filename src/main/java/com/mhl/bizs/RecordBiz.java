package com.mhl.bizs;

//import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Propagation;
//import org.springframework.transaction.annotation.Transactional;

import com.mhl.mappers.RecordMapper;
import com.mhl.model.Charts;
import com.mhl.model.Record;
@Service
public class RecordBiz implements IRecordBiz{
	@Resource
	private RecordMapper mapper;
	@Override
	public boolean remove(int id,String da) {
		Record rec=new Record();
		if(id>0) {
			Record bean=mapper.seleone(id);
			Float price=bean.getPrice();
//			数据库里的入住日期,并转成数字
			String rtime=bean.getRtime();
			String a1=rtime.substring(0,10);
			String[] a2=a1.split("-");
			String a3="";
			for (String s : a2) {
				a3=a3+s;
			}
			int a4=Integer.parseInt(a3);
//			前端传过来的离店日期
			String b1=da.substring(0,10);
			String[] b2=b1.split("-");
			String b3="";
			for (String s : b2) {
				b3=b3+s;
			}
			int b4=Integer.parseInt(b3);
			float total=(b4-a4)*price;
			rec.setId(id);
			rec.setLtime(da);
			rec.setTotal(total);
			return mapper.dele(rec);
		}else {
			return false;
		}
		
	}

	@Override
	public Record find(int id) {
		return mapper.seleone(id);
	}

	@Override
	public List<Record> query(Map<String, Object> map) {
		return mapper.sele(map);
	}

	@Override
	public boolean save(Record bean) {
		if(bean.getId()!=null) {
			return mapper.update(bean);
		}else {
			return mapper.insert(bean);
		}
	}

	@Override
	public List<Charts> selebymonth(String year) {
		return this.mapper.selectPersons(year);
	}

}
