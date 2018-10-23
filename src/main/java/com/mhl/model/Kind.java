package com.mhl.model;

import java.util.List;

public class Kind{
	
	private List<House> houses;
	
	public List<House> getHouses() {
		return houses;
	}

	public void setHouses(List<House> houses) {
		this.houses = houses;
	}
	private Integer id;
	public void setId(Integer id){
		this.id=id;
	}
	public Integer getId(){
		return this.id;
	}
	private String name;
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return this.name;
	}
	private String icon;
	public void setIcon(String icon){
		this.icon=icon;
	}
	public String getIcon(){
		if (icon!=null) {
			return this.icon;
		}else {
			return "";
		}
		
	}
	private String info;
	public void setInfo(String info){
		this.info=info;
	}
	public String getInfo(){
		return this.info;
	}
}