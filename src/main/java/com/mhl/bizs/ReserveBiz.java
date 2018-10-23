package com.mhl.bizs;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mhl.mappers.RecordMapper;
import com.mhl.mappers.ReserveMapper;
import com.mhl.model.Charts;
import com.mhl.model.Record;
import com.mhl.model.Reserve;
@Service
public class ReserveBiz implements IReserveBiz {
	@Resource
	private ReserveMapper mapper;
	@Resource
	private RecordMapper dao;
	@Override
	public List<Reserve> query(Map<String,Object> map) {
		return mapper.sele(map);
	}

	@Override
	public Reserve find(int id) {
		return mapper.seleone(id);
	}

	@Override
	public boolean save(Reserve bean) {
		if(bean.getId()!=null) {
			return mapper.update(bean);
		}else {
			return mapper.insert(bean);
		}
	}

	@Override
	public boolean remove(int id) {
		return mapper.dele(id);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public boolean change(int id) {
		Reserve res=mapper.seleone(id);
		if(res!=null){
			if(mapper.dele(id)) {
				Record bean=new Record();
				bean.setCustom(res.getCustom());
				bean.setHid((res.getHid()));
				bean.setLtime((res.getLdate()));
				bean.setPhone(res.getPhone());
				bean.setPersons(res.getPersons());
				bean.setPrice(res.getPrice());
				bean.setTotal(res.getTotal());
				bean.setWxnick(res.getWxnick());
				if(dao.insert(bean)) {
					return true;
				}
				
			}
		}
		return false;
	}

	@Override
	public List<Charts> selebymonth(String year) {
		return this.mapper.selectPersons(year);
	}

}
