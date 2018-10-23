package com.mhl.servlet;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mhl.bizs.IAdminBiz;
import com.mhl.model.Admin;
import com.mhl.uploadfile.MD5;

@RestController
@RequestMapping("/admin/")
public class AdminCtrl {
	@Resource
	private IAdminBiz biz;
	
	
	@RequestMapping("changepwd")
	public boolean changepwd(@RequestParam("id") Integer id,@RequestParam("pwd1") String pwd1,@RequestParam("pwd2") String pwd2){
		String mypwd = null;
		Admin admin=new Admin();
		if(id>0) {
			Admin bean=this.biz.get(id);
			mypwd=bean.getPassword();
			admin.setId(id);
			
		}
		 
		
		MD5 md5=new MD5();
		String ypwd = null;
		String npwd= null;
		if(pwd1!=null && !pwd1.equals("")) {
			ypwd=md5.md5crypt(pwd1);
		}
		if(pwd2!=null && !pwd2.equals("")) {
			npwd=md5.md5crypt(pwd2);
			admin.setPassword(npwd);
		}
		if(mypwd.equals(ypwd)) {
			return biz.changepwd(admin);
		}else {
			return false;
		}
		
	}
	@RequestMapping("sele")
	public List<Admin> sele(){
		return this.biz.query();
	}
	@RequestMapping("selebyid")
	public Admin selebyid(int id){
		return this.biz.get(id);
	}
	@RequestMapping(value="login",method=RequestMethod.POST)
	public Admin seleone(String username,String password){
		Admin bean=new Admin();
		bean.setUsername(username);
		MD5 md5=new MD5();
		bean.setPassword(md5.md5crypt(password));
		return this.biz.find(bean);
	}
	@RequestMapping("save")
	public boolean save(HttpServletRequest request){
		String id=request.getParameter("id");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String status=request.getParameter("status");
		String ids=request.getParameter("pids");
		Admin bean=new Admin();
		bean.setUsername(username);
		MD5 md5=new MD5();		
		bean.setPassword(md5.md5crypt(password));
		bean.setStatus(Integer.parseInt(status));
		
		List<Integer> list=new ArrayList<Integer>();
		if(ids!=null && ids.length()>0) {
			String ps[]=ids.split(",");
			for (String s : ps) {
				list.add(Integer.parseInt(s));
			}
		}
		if(id!=null && !id.equals("")) {
			bean.setId(Integer.parseInt(id));
		}
		return this.biz.save(bean, list);
	}
	@RequestMapping("dele/{id}")
	public boolean dele(@PathVariable("id") int id){
		return this.biz.remove(id);
	}
	
}
