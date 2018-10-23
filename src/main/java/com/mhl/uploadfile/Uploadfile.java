package com.mhl.uploadfile;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class Uploadfile {
	public static String uplodaer(MultipartFile file,String path){
//		获取原始文件名称
		String oname=file.getOriginalFilename();
//		截取原始文件扩展名
		String ext=oname.substring(oname.indexOf("."));
//		利用系统毫秒数加上扩展名重新命名
		String name="";
		for(int i=1;i<1000;i++) {
			name=System.currentTimeMillis()+i+ext;
		}
//		构建目标文件，利用传过来的绝对地址路径
		File dest=new File(path+"\\"+name);
		try {
//			将内存中的文件保存成磁盘文件
			file.transferTo(dest);
			return name;
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
