package com.cg.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.cg.entity.Book;


public class BookAuthorDaoImpl implements BookAuthorDao {
	EntityManagerFactory factory;
	
	public BookAuthorDaoImpl() {
		factory = Persistence.createEntityManagerFactory("MyJPA");	
	}

	public void save(Object e) {
		EntityManager mgr = null;
		
		try {
			mgr = factory.createEntityManager();
			EntityTransaction txn = mgr.getTransaction();
			txn.begin();
			mgr.persist(e);
			txn.commit();
		} finally {
			mgr.close();
		}		
	}

	public List<Book> fetchBooks(String author) {
		EntityManager mgr = null; 
		try {
			mgr = factory.createEntityManager();
			Query query = mgr.createQuery("from Book where auth_id = (select auth_id from Author where aname=:an)");
			query.setParameter("an", author);
			List<Book> books = query.getResultList();
			return books;
		} finally {
			mgr.close();
		}
	}

	public String fetchAuthor(String bookName) {
		EntityManager mgr = null;
		try {
			mgr = factory.createEntityManager();
			Query query = mgr.createQuery("select aname from Author where author_id = (select author_id from Book where title=:ti)");
			query.setParameter("ti", bookName);
			String authorName = (String) query.getSingleResult();
			return authorName;
		} finally {
			mgr.close();
		}
	}

	public List<String> fetchBooksByPrice(double minPrice,
			double maxPrice) {
		EntityManager mgr = null;
		try {
			mgr = factory.createEntityManager();
			Query query = mgr.createQuery("select title from Book where price between :min and :max");
			query.setParameter("min", minPrice);
			query.setParameter("max", maxPrice);
			List<String> books = query.getResultList();
		return books;
	}
		finally {
			mgr.close();
		}

}
}
