package com.mhl.bizs;
import com.mhl.mappers.TourMapper;
import com.mhl.model.*;
import java.util.*;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
@Service
public class TourBiz implements ITourBiz{
	@Resource
	private TourMapper mapper;

	@Override
	public boolean save(Tour bean) {
		if(bean.getId()!=null){
			return this.mapper.update(bean);
		}else{
			return this.mapper.insert(bean);
		}
	}

	@Override
	public boolean remove(Integer id) {
		return this.mapper.delete(id);
	}

	@Override
	public Tour find(Integer id) {
		return this.mapper.selectone(id);
	}

	@Override
	public List<Tour> query(Map<String,Object> map) {
		return this.mapper.select(map);
	}
}
