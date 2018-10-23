package com.mhl.bizs;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mhl.mappers.HpriceMapper;
import com.mhl.model.Hprice;
@Service
public class Hpricebiz implements IHpeicebiz {
	@Resource
	private HpriceMapper mapper;
	@Override
	public List<Hprice> query() {
		return this.mapper.sele();
	}

	@Override
	public Hprice find(int id) {
		
		return this.mapper.seleone(id);
	}

	@Override
	public boolean save(Hprice bean) {
		if(bean.getId()>0) {
			return this.mapper.update(bean);
		}else {
			return this.mapper.insert(bean);
		}
		
	}

	@Override
	public boolean remove(int id) {
		return this.mapper.dele(id);
	}

	@Override
	public Hprice query2(Map<String, Object> map) {
		return mapper.sele2(map);
	}

}
