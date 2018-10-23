package com.mhl.bizs;
import com.mhl.model.*;
import com.mhl.mappers.*;
import java.util.*;

import javax.annotation.Resource;

//import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class HouseBiz implements IHouseBiz{
	@Resource
	private HouseMapper hm;
	
	private static final Logger log=LoggerFactory.getLogger(HouseBiz.class);
	
	@Override
	public boolean save(House bean) {
		if(bean.getId()!=null) {
			return hm.update(bean);
		}else {
			return hm.insert(bean);
		}
		
	}
	@Override
	public boolean dele(int id) {
		boolean f=false;
		try {
			f=hm.delete(id);
		}catch(Exception e){
			log.error(e.getMessage());
		}
		return f;
	
	}
	
	@Override
	public House seleone(int id) {
		return hm.selectOne(id);
	}
	@Override
	public List<House> sele(Map<String,Object> map) {
		
		return hm.select(map);
	}
	@Override
	public boolean enable(int id, int status) {
		House house= new House();
		house.setId(id);
		house.setStatus(status);
		return this.hm.enable(house);
	}
	@Override
	public boolean updateimg(House house) {
		return hm.updateimg(house);
	}
	@Override
	public List<House> sele2(Map<String,Object> map) {
		return hm.select2(map);
	}
	@Override
	public List<Charts> selebykind() {
		return this.hm.selectbykind();
	}
}
