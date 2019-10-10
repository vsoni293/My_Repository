package com.cg.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "author")
public class Author {
	@Id	
	private int auth_id;
	
	@Column(name = "aname", length = 30)
	private String name;
	
	@OneToMany(mappedBy = "author", cascade = CascadeType.ALL
			,fetch = FetchType.EAGER)
	Set<Book> books = new HashSet<Book>();
	
	public Set<Book> getBooks() {
		return books;
	}
	public void setBooks(Set<Book> books) {
		this.books = books;
	}
	public int getId() {
		return auth_id;
	}
	public void setId(int id) {
		this.auth_id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
