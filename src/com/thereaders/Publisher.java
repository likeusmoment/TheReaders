package com.thereaders;

public class Publisher {
	private int idx;
	private String name;
	
	public Publisher(int idx, String name) {
		this.idx = idx;
		this.name = name;
	}
	
	public int getIdx() {
		return idx;
	}
	
	public void setIdx(int idx) {
		this.idx = idx;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
}
