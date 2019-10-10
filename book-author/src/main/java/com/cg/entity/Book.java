package com.cg.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="book")
public class Book {
	@Id
	private int serial;
	@Column(length = 30)
	private String ISBN;
	@Column(length = 30)
	private String title;
	private double price;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="auth_id")
	private Author author;
	
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	
	
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getSerial() {
		return serial;
	}
	public void setSerial(int serial) {
		this.serial = serial;
	}
	@Override
	public String toString() {
		return "Book [serial=" + serial + ", ISBN=" + ISBN + ", title=" + title + ", price=" + price + "]";
	}
	

}
