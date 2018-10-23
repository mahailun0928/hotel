package com.mhl.servlet;

import java.io.File;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mhl.bizs.ICompanybiz;
import com.mhl.model.Company;
import com.mhl.uploadfile.Uploadfile;

@RestController
@RequestMapping("/company/")
public class CompanyCtrl {
	@Resource
	private ICompanybiz biz;
	
	@RequestMapping("saveimg")
	public boolean saveimg(@RequestParam("files[]") MultipartFile files[],HttpServletRequest req) {
		String path=req.getSession().getServletContext().getRealPath("/images");
		File f=new File(path);
		if(!f.exists()) {
			f.mkdir();
		}
		Company bean=new Company();
		bean.setId(1);
		System.out.println(files.length);
		for(int i=0;i<files.length;i++) {
			MultipartFile file=files[i];
			if(file!=null && file.getSize()>0) {
				String name=Uploadfile.uplodaer(file, path);
				if(name!=null) {
					switch (i) {
					case 0:
						bean.setPica(name);
						break;
					case 1:
						bean.setPicb(name);
						break;
					case 2:
						bean.setPicc(name);
						break;
					case 3:
						bean.setPicd(name);
						break;
					case 4:
						bean.setPice(name);
						break;
					case 5:
						bean.setPicf(name);
						break;
					
					}
				}
			}
		}
		return this.biz.saveimg(bean);
	}
	@RequestMapping("sele")
	public Company sele() {
		return this.biz.query();
	}
	@RequestMapping("save")
	public boolean save(Company bean) {
		return this.biz.save(bean);
	}
}
