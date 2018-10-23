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
import com.mhl.bizs.IReserveBiz;
import com.mhl.model.Charts;
import com.mhl.model.Reserve;

@RestController
@RequestMapping("/reserve/")
public class ReserveCtrl {
	@Resource
	private IReserveBiz biz;
	
	@RequestMapping("selebymonth")
	public Map<String,Object> selebymonth(@RequestParam("yid1") String yid1,@RequestParam("yid2") String yid2) {
		Map<String,Object> map=new HashMap<String,Object>();
		
		if(yid1!=null && !yid1.equals("")) {
			List<Charts> list1=biz.selebymonth(yid1);
			map.put("li1", list1);
		}
		if(yid2!=null && !yid2.equals("")) {
			List<Charts> list2=biz.selebymonth(yid2);
			map.put("li2", list2);
		}
		
		return map;
	}
	
	@RequestMapping("change")
	public boolean change(int id) {
		return biz.change(id);
	}
	
	@RequestMapping("sele")
	public Map<String,Object> sele(HttpServletRequest request){
		String p=request.getParameter("page");
		String r=request.getParameter("rows");
		String custom=request.getParameter("custom");
		String phone=request.getParameter("phone");
		String kid=request.getParameter("kid");
		String rdate=request.getParameter("rdate");
		String ldate=request.getParameter("ldate");
		int page=1,rows=10;
		
		Map<String,Object> map=new HashMap<String,Object>();
		if(p!=null && !"".equals(p)) {
			page=Integer.parseInt(p);
		}
		if(r!=null && !"".equals(r)) {
			rows=Integer.parseInt(r);
		}
		if(custom!=null && !"".equals(custom)) {
			map.put("custom",custom);
		}
		if(phone!=null && !"".equals(phone)) {
			map.put("phone",phone);
		}
		if(kid!=null && !"".equals(kid)) {
			map.put("kid",Integer.parseInt(kid));
		}
		if(rdate!=null && !"".equals(rdate)) {
			map.put("rdate",rdate);
		}
		if(ldate!=null && !"".equals(ldate)) {
			map.put("ldate",ldate);
		}
		PageHelper.startPage(page,rows);
		List<Reserve> list=biz.query(map);
		Page pg=(Page) list;
		int pages=pg.getPages();
		Map<String,Object> rs=new HashMap<String,Object>();
		rs.put("list", list);
		rs.put("pages",pages);
		return rs;
	}
	@RequestMapping("seleone")
	public Reserve seleone(int id){
		return biz.find(id);
	}
	
	@RequestMapping("dele/{id}")
	public boolean dele(@PathVariable("id") int id){
		return biz.remove(id);
	}
	@RequestMapping("save")
	public boolean save(Reserve bean){
		return biz.save(bean);
	}
}
