package com.thereaders;

public class Book {
	int idx;
	int authorIdx;
	int publisherIdx;
	String name;
	int num_page;

	public Book(int idx, int authorIdx, int publisherIdx, String name,
			int num_page) {
		this.idx = idx;
		this.authorIdx = authorIdx;
		this.publisherIdx = publisherIdx;
		this.name = name;
		this.num_page = num_page;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public int getAuthorIdx() {
		return authorIdx;
	}

	public void setAuthorIdx(int authorIdx) {
		this.authorIdx = authorIdx;
	}

	public int getPublisherIdx() {
		return publisherIdx;
	}

	public void setPublisherIdx(int publisherIdx) {
		this.publisherIdx = publisherIdx;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNum_page() {
		return num_page;
	}

	public void setNum_page(int num_page) {
		this.num_page = num_page;
	}

}
