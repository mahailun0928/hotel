package com.mhl.servlet;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mhl.bizs.ITourBiz;
import com.mhl.model.Tour;

@RestController
@RequestMapping("/tour/")
public class TourCtrl {
	@Resource
	private ITourBiz biz;
	
	@RequestMapping("save")
	public boolean save(Tour bean) {
		return this.biz.save(bean);
		
	}
	@RequestMapping("dele")
	public boolean save(Integer id) {
		return this.biz.remove(id);
		
	}
	@RequestMapping("seleone")
	public Tour seleone(Integer id) {
		return this.biz.find(id);
		
	}
	@RequestMapping("sele")
	public List<Tour> sele(HttpServletRequest req) {
		String title=req.getParameter("title");
		String pdate1=req.getParameter("sdate");
		String pdate2=req.getParameter("edate");
		
		
		Map<String,Object> map=new HashMap<String,Object>();
		if(title!=null && !title.equals("")) {
			map.put("title", title);
		}
		if(pdate1!=null && !pdate1.equals("")) {
			try {
				Date d = new SimpleDateFormat("yyyy-MM-dd").parse(pdate1);
				map.put("pdate1", d);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		if(pdate2!=null && !pdate2.equals("")) {
			try {
				Date d2 = new SimpleDateFormat("yyyy-MM-dd").parse(pdate2);
				map.put("pdate2", d2);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		List<Tour> li=this.biz.query(map);
		
		return li;
		
	}
	
}
