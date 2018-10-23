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
public class KindBiz implements IKindBiz{
	@Resource
	private KindMapper km;
	
	private static final Logger log=LoggerFactory.getLogger(KindBiz.class);
	
	@Override
	public boolean save(Kind bean) {
		
		if(bean.getId()!=null) {
			return km.update(bean);
		}else{
			return km.insert(bean);
		
		}
	}
	@Override
	public boolean dele(int id) {
		boolean f=false;
		try {
			f=km.delete(id);
		}catch(Exception e){
			log.error(e.getMessage());
		}
		return f;
	}
	
	@Override
	public Kind seleone(int id) {
		return km.selectOne(id);
	}
	@Override
	public List<Kind> sele() {
		
		return km.select();
	}
}
