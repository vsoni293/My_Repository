package com.cg.dao;

import java.util.List;

import com.cg.entity.Author;
import com.cg.entity.Book;

public interface BookAuthorDao {
	
	void save(Object e);
	
	List<Book> fetchBooks(String author);
	
	String fetchAuthor(String bookName);
	
	List<String> fetchBooksByPrice(double minPrice, 
			double maxPrice);

}
