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
	
	@Test
	void testBinarySearchBook() {
		System.out.println("\n< Binary Search >");
		bookManager.addBook(1, "자바 기초", "Jane", 2021);
		bookManager.addBook(2, "소프트웨어 공학", "Tom", 2014);
		assertEquals(true, bookManager.search_bs(1));
		assertEquals(true, bookManager.search_bs(2));
		assertEquals(false, bookManager.search_bs(3)); // 검색 결과 없음
	}
	
	@Test
	void testPerformTest() {
		System.out.println("검색 성능 비교");
		bookManager.addBook(1, "자바 기초", "Jane", 2021);
		bookManager.addBook(2, "소프트웨어 공학", "Tom", 2014);
		bookManager.addBook(3, "동시 컴퓨팅", "Yoon", 2010);
		bookManager.addBook(4, "운영체제", "Lee", 2011);
		bookManager.addBook(5, "논리회로", "Lee", 2012);
		bookManager.addBook(6, "컴퓨터 구조", "Park", 2013);
		bookManager.addBook(7, "대학수학(1)", "Choi", 2014);
		bookManager.addBook(8, "대학화학(1)", "Kim", 2015);
		bookManager.addBook(9, "대학물리(1)", "Kim", 2016);
		bookManager.addBook(10, "대학수학(2)", "Park", 2017);
		bookManager.addBook(11, "대학화학(2)", "Jeong", 2018);
		bookManager.addBook(12, "대학물리(2)", "Park", 2019);
		bookManager.addBook(13, "객체지향 프로그래밍", "Kim", 2020);
		bookManager.addBook(14, "인터넷 프로그래밍", "Lee", 2021);
		bookManager.addBook(15, "자료구조", "Pae", 2022);
		bookManager.addBook(16, "기초DB", "Kim", 2023);
		bookManager.addBook(17, "응용DB", "Kim", 2015);
		bookManager.addBook(18, "수치해석", "Park", 2019);
		bookManager.addBook(19, "오토마타", "Park", 2015);
		bookManager.addBook(20, "프로그래밍언어", "Song", 2017);
		
		assertEquals(true,bookManager.performTest(10));
		assertEquals(true,bookManager.performTest(15));
		assertEquals(true,bookManager.performTest(20));
	}
	
}