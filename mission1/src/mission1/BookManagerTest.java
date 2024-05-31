package mission1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BookManagerTest {

	private BookManager bookManager;
	
	@BeforeEach
	void setUp() {
		bookManager = new BookManager();
	}

	@Test
	void testAddBook() {
		bookManager.addBook(1, "자바 기초", "Jane", 2021);
		bookManager.addBook(1, "자바 기초", "Jane", 2021); // 추가 불가
		bookManager.searchBook(1);
		assertEquals(1, bookManager.books.size());		
	}
	
	@Test
	void testSearchBook() {
		bookManager.addBook(1, "자바 기초", "Jane", 2021);
		bookManager.addBook(2, "소프트웨어 공학", "Tom", 2014);
		bookManager.addBook(3, "분산 컴퓨팅", "Yoon", 2024);
		assertEquals(true, bookManager.searchBook(1));
		assertEquals(true, bookManager.searchBook(2));
		assertEquals(true, bookManager.searchBook(3));
		assertEquals(false, bookManager.searchBook(4)); // 검색 결과 없음
	}

	@Test
	void testRemoveBook() {
		bookManager.addBook(1, "자바 기초", "Jane", 2021);
		bookManager.addBook(2, "소프트웨어 공학", "Tom", 2014);
		bookManager.removeBook(Integer.valueOf(1));
		bookManager.removeBook(Integer.valueOf(1)); // 삭제 불가
		bookManager.searchBook(1); // 삭제한 Book이므로 검색 결과 없음
		assertEquals(1, bookManager.books.size());
	}
	
}