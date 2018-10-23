package com.mhl.model;
public class Tour{
	private Integer id;
	public void setId(Integer id){
		this.id=id;
	}
	public Integer getId(){
		return this.id;
	}
	private String title;
	public void setTitle(String title){
		this.title=title;
	}
	public String getTitle(){
		return this.title;
	}
	private String pdate;
	public void setPdate(String pdate){
		this.pdate=pdate;
	}
	public String getPdate(){
		return this.pdate;
	}
	private String content;
	public void setContent(String content){
		this.content=content;
	}
	public String getContent(){
		return this.content;
	}
}