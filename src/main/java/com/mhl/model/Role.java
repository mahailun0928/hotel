package com.mhl.model;

public class Role {
	
	
	public Role() {
		
	}
	public Role(int aid, int pid) {
		super();
		this.aid = aid;
		this.pid = pid;
	}
	private int aid;
	private int pid;
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	
}
