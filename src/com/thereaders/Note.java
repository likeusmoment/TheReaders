package com.thereaders;

import java.util.Date;

public class Note {
	int bookIdx;
	String txt;
	int num_page;
	Date datetime;

	public Note(int bookIdx, String txt, int num_page, Date datetime) {
		this.bookIdx = bookIdx;
		this.txt = txt;
		this.num_page = num_page;
		this.datetime = datetime;
	}

	public int getBookIdx() {
		return bookIdx;
	}

	public void setBookIdx(int bookIdx) {
		this.bookIdx = bookIdx;
	}

	public String getTxt() {
		return txt;
	}

	public void setTxt(String txt) {
		this.txt = txt;
	}

	public int getNum_page() {
		return num_page;
	}

	public void setNum_page(int num_page) {
		this.num_page = num_page;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	
}
