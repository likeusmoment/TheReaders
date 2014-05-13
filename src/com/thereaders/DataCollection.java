package com.thereaders;

public class DataCollection {
	private Author author;
	private Book book;
	private Note note;
	private Publisher publisher;
	
	public DataCollection(Book book) {
		this.book = book;
	}

	public DataCollection(Author author) {
		this.author = author;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Note getNote() {
		return note;
	}

	public void setNote(Note note) {
		this.note = note;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
}
