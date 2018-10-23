package com.mhl.servlet;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mhl.bizs.IKindBiz;
import com.mhl.model.Kind;

@RestController
@RequestMapping("/kind/")
public class KindCtrl {
	@Resource
	private IKindBiz kb;
	
	private static final Logger log=LoggerFactory.getLogger(KindCtrl.class);
	
	@RequestMapping("sele")
	public List<Kind> sele(){
//		log.info("-----------查询全部客房类别-------------");
		return kb.sele();
	}
	
	@RequestMapping("seleone/{id}")
	public Kind seleone(@PathVariable("id") int id){
		return kb.seleone(id);
	}
	
	
	@RequestMapping("dele/{id}")
	public boolean dele(@PathVariable("id") int id){
		return kb.dele(id);
	}
	
	
	@RequestMapping(value="save",method=RequestMethod.POST)
	public boolean save(Kind bean){
		return kb.save(bean);
	}
	
}
