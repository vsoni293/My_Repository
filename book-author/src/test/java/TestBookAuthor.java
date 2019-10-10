import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.cg.dao.BookAuthorDao;
import com.cg.dao.BookAuthorDaoImpl;
import com.cg.entity.Author;
import com.cg.entity.Book;

public class TestBookAuthor {
	
	BookAuthorDao dao;
	EntityManager mgr;
	
	@Before
	public void setup() {
		dao = new BookAuthorDaoImpl();
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("MyJPA");
		mgr = factory.createEntityManager();
	}

	@After
	public void tearDown() {
		mgr.close();
		dao = null;
	}
	
	@Test
	public void testSave() {
		
		Author a1 = new Author();
		a1.setId(3);
		a1.setName("Kennedy");
		
		Book b1 = new Book();
		b1.setSerial(1);
		b1.setTitle("Alice Returns In Tanzania ");
		b1.setISBN("AITR");
		b1.setPrice(150);
		b1.setAuthor(a1);
		
		Book b2 = new Book();
		b2.setSerial(2);
		b2.setTitle("Dark Knight Rises");
		b2.setISBN("DKR");
		b2.setPrice(250);
		b1.setAuthor(a1);
		
		a1.getBooks().add(b1);
		a1.getBooks().add(b2);
		
		dao.save(a1);
	}
	
	@Test
	public void testFetchBooks() {
		List<Book> books = new ArrayList<Book>();
		books = dao.fetchBooks("Kennedy");
		for(Book book : books) {
			System.out.println(books);
			//System.out.println(book);
		}
		
		
	}

}
