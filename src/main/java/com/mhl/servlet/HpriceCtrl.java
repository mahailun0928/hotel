package com.mhl.servlet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mhl.bizs.IHpeicebiz;
import com.mhl.model.Hprice;

@RestController
@RequestMapping("/price/")
public class HpriceCtrl {
	@Resource
	private IHpeicebiz biz;
	
	@RequestMapping("sele2")
	public Hprice sele2(int kid,String sdate,String edate) {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("kid", kid);
		map.put("sdate",sdate);
		map.put("edate",edate);
		return biz.query2(map);
	}
	
	
	@RequestMapping("save")
	public boolean save(Hprice bean) {
		return biz.save(bean);
	}
	@RequestMapping("dele/{id}")
	public boolean dele(@PathVariable("id") int id) {
		return biz.remove(id);
	}
	@RequestMapping("seleone")
	public Hprice seleone(int id) {
		return biz.find(id);
	}
	@RequestMapping("sele")
	public Map<String,Object> sele(HttpServletRequest request) {
		int page=1;
		int row=5;
		String p=request.getParameter("page");
		String r=request.getParameter("row");
		if(p!=null && !p.equals("")){
			page=Integer.parseInt(p);
		}
		if(r!=null && !r.equals("")){
			row=Integer.parseInt(r);
		}
		PageHelper.startPage(page,row);
		List<Hprice> li=biz.query();
		Page pg= (Page) li;
		int pages=pg.getPages();
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("li",li);
		map.put("pages", pages);
		map.put("page",page);
		return map;
	}
	
}
