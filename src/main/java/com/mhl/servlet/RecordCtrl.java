package com.mhl.servlet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mhl.bizs.IRecordBiz;
import com.mhl.model.Charts;
import com.mhl.model.Record;
//import com.mhl.model.Reserve;

@RestController
@RequestMapping("/record/")
public class RecordCtrl {
	@Resource
	private IRecordBiz biz;
	
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
	
	
	@RequestMapping("sele")
	public Map<String,Object> sele(HttpServletRequest request){
		String p=request.getParameter("page");
		String r=request.getParameter("rows");
		String custom=request.getParameter("custom");
		String phone=request.getParameter("phone");
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
		
		if(rdate!=null && !"".equals(rdate)) {
			map.put("rtime",rdate);
		}
		if(ldate!=null && !"".equals(ldate)) {
			map.put("ltime",ldate);
		}
		PageHelper.startPage(page,rows);
		List<Record> list=biz.query(map);
		Page pg=(Page) list;
		int pages=pg.getPages();
		Map<String,Object> rs=new HashMap<String,Object>();
		rs.put("list", list);
		rs.put("pages",pages);
		return rs;
	}
	
	@RequestMapping("seleone")
	public Record seleone(int id){
		return biz.find(id);
	}
	
	@RequestMapping("dele")
	public boolean dele(@RequestParam("id")int id,@RequestParam("da") String da){
		
		return biz.remove(id,da);
	}
	@RequestMapping("save")
	public boolean save(Record bean){
		return biz.save(bean);
	}
	
}
