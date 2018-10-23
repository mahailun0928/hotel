package com.mhl.servlet;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mhl.bizs.IHouseBiz;
import com.mhl.model.Charts;
import com.mhl.model.House;
import com.mhl.uploadfile.Uploadfile;

@RestController
@RequestMapping("/house/")
public class HouseCtrl {

	@Resource
	private IHouseBiz hb;
	
	private static final Logger log=LoggerFactory.getLogger(HouseCtrl.class);
	@RequestMapping("sele2")
	public List<House> sele2(int kid,String rdate,String ldate){
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("kid", kid);
		map.put("rdate",rdate);
		map.put("ldate",ldate);
		return hb.sele2(map);
	}
	@RequestMapping("selebykind")
	public List<Charts> selebykind(){
		return this.hb.selebykind();
	}
	
	@RequestMapping("sele")
	public Map<String,Object> sele(HttpServletRequest request){
		log.info("-----------查询全部客房信息-------------");
		int page=1;
		int row=4;
		String p=request.getParameter("page");
		String r=request.getParameter("row");
		String b=request.getParameter("beds");
		String k=request.getParameter("kid");
		Map<String,Object> map=new HashMap<String,Object>();
		if(b!=null && !b.equals("")) {
			map.put("beds",Integer.parseInt(b));
		}
		if(k!=null && !k.equals("")) {
			map.put("kid",Integer.parseInt(k));
		}
		if(p!=null && !p.equals("")) {
			page=Integer.parseInt(p);
		}
		if(r!=null && !r.equals("")) {
			row=Integer.parseInt(r);
		}
		PageHelper.startPage(page,row);
		
		List<House> list=hb.sele(map);
		Page pg=(Page) list;
		int pages=pg.getPages();
		Map<String,Object> end=new HashMap<String,Object>();
		end.put("list", list);
		end.put("page", page);
		end.put("pages", pages);		
		return end;
	}
	@RequestMapping("uploads")
	public boolean uploads(MultipartFile pica,MultipartFile picb,MultipartFile picc,MultipartFile picd,HttpServletRequest request) {
//		获取图片存储的绝对路径，并传给uploadfile类
		String path=request.getSession().getServletContext().getRealPath("/images");
//		获取客房id号，用id号来修改上传图片
		String hid=request.getParameter("id");
		House bean=new House();
		bean.setId(Integer.parseInt(hid));
		if(pica!=null && pica.getSize()>0) {
			String pa=Uploadfile.uplodaer(pica, path);
			if(pa!=null && !pa.equals("")) {
				bean.setPica(pa);
			}
		}
		if(picb!=null && picb.getSize()>0) {
			String pa=Uploadfile.uplodaer(picb, path);
			if(pa!=null && !pa.equals("")) {
				bean.setPicb(pa);
			}
		}
		if(picc!=null && picc.getSize()>0) {
			String pa=Uploadfile.uplodaer(picc, path);
			if(pa!=null && !pa.equals("")) {
				bean.setPicc(pa);
			}
		}
		if(picd!=null && picd.getSize()>0) {
			String pa=Uploadfile.uplodaer(picd, path);
			if(pa!=null && !pa.equals("")) {
				bean.setPicd(pa);
			}
		}
		return hb.updateimg(bean);
	}
	
	@RequestMapping("enable/{id}/{status}")
	public boolean enable(@PathVariable("id") int id,@PathVariable("status") int status) {
		return hb.enable(id,status);
	}
	
	@RequestMapping("seleone/{id}")
	public House seleone(@PathVariable("id") int id){
		return hb.seleone(id);
	}

	@RequestMapping("dele/{id}")
	public boolean dele(@PathVariable("id") int id){
		return hb.dele(id);
	}
	
	@RequestMapping("save")
	public House save(House bean) {
		if(hb.save(bean)) {
			return bean;
		}else {
			return null;
		}
		
	}
}
