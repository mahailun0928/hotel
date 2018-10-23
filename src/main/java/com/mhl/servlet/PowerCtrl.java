package com.mhl.servlet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mhl.bizs.IPowerBiz;
import com.mhl.bizs.PowerBiz;
import com.mhl.model.Power;

@RestController
@RequestMapping("/power/")
public class PowerCtrl {
	@Resource
	private IPowerBiz biz;
	
	@RequestMapping("sele")
	public List<Power> sele(){
		return this.biz.query();
	}
	@RequestMapping("sele2")
	public List<Power> sele2(){
		return this.biz.query2();
	}
	@RequestMapping("save")
	public boolean save(Power bean){
		return this.biz.save(bean);
	}
	@RequestMapping("upxh")
	public boolean upxh(int id,int flag,int xh){
		Map<String,Integer> map=new HashMap<String,Integer>();
		map.put("id",id);
		map.put("flag",flag);
		map.put("xh", xh);
		return this.biz.updatexh(map);
	}
	@RequestMapping("seleone/{id}")
	public Power seleone(@PathVariable("id") Integer id){
		return this.biz.find(id);
	}
	@RequestMapping("dele/{id}")
	public boolean dele(@PathVariable("id") int id){
		return this.biz.remove(id);
	}
}
