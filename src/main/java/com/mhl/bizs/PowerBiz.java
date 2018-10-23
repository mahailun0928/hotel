package com.mhl.bizs;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mhl.mappers.PowerMapper;
import com.mhl.model.Power;
@Service
public class PowerBiz implements IPowerBiz {
	@Resource
	private PowerMapper mapper;
	
	@Override
	public boolean save(Power bean) {
		if(bean.getId()!=null) {
			return mapper.update(bean);
		}else {
			return mapper.insert(bean);
		}
	}

	@Override
	public List<Power> query() {
		return mapper.sele();
	}

	@Override
	public List<Power> query2() {
		return mapper.sele2();
	}

	@Override
	public boolean remove(Integer id) {
		return mapper.dele(id);
	}

	@Override
	public Power find(Integer id) {
		return mapper.seleone(id);
	}

	@Override
	public boolean updatexh(Map<String, Integer> map) {
		return mapper.updatexh(map);
	}

}
