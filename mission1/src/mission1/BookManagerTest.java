package mission1;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BookManagerTest {

	private BookManager bookManager;
	String[] authorArray = {"Amy", "Bob", "Charlie", "Dale", "Emily"};
	String[] titleArray = {"자바 기초", "소프트웨어공학", "자료구조", "알고리즘", "운영체제"};
	
	@BeforeEach
	void setUp() {
		// books 에 5권 추가
		bookManager = new BookManager();
		System.out.println("\n< Initiate Books >");
		for (int i=0; i<authorArray.length ; i++) {
			bookManager.addBook(i+1, titleArray[i], authorArray[i], 2000+i);
		}
		
		
	}
		
	@Order(1)
	@Test
	void testAddBook() {
		System.out.println("\n< AddBook Test >");
		bookManager.addBook(1, titleArray[1], authorArray[1], 2000+1); // 이미 존재
		bookManager.addBook(3, titleArray[3], authorArray[3], 2000+3); // 이미 존재
		bookManager.addBook(6, "컴퓨터구조", "Frank", 2000+6);
	}		
	
	@Order(2)
	@Test
	void testSearchBook() {
		System.out.println("\n< Search Test >");
		assertEquals(true, bookManager.searchBook(1));
		assertEquals(true, bookManager.searchBook(2));
		assertEquals(true, bookManager.searchBook(3));
		assertEquals(false, bookManager.searchBook(6)); // 결과 없음
	}

	@Order(3)
	@Test
	void testRemoveBook() {
		System.out.println("\n< Remove Test>");
		bookManager.removeBook(1);
		bookManager.removeBook(2);
		bookManager.searchBook(1); // 삭제한 Book이므로 검색 결과 없음
		bookManager.searchBook(2); // 삭제한 Book이므로 검색 결과 없음
		assertEquals(3, bookManager.books.size());
	}
	
	@Order(4)
	@Test
	void testBinarySearchBook() {
		System.out.println("\n< Binary Search Test >");
		assertEquals(true, bookManager.search_bs(1));
		assertEquals(true, bookManager.search_bs(2));
		assertEquals(false, bookManager.search_bs(6)); // 검색 결과 없음
	}
	
	
	//성능 비교
	@Order(5)
	@Test
	void searchPerformanceTest() {
		System.out.println("\n< SearchPerformance Test >");
		System.out.println("Books에 10,000개 추가");
		for (int i=5; i<100000 ; i++) {
			bookManager.addBook(i+1, titleArray[0], authorArray[0], 2000+0);
		}
		
		int id = 9000; // 검색하는 id 
		//searchBook 실행시간 측정
		long beforeTime_1 = System.currentTimeMillis(); //코드 실행 전 시간 
		bookManager.searchBook(id);	        
		long afterTime_1 = System.currentTimeMillis(); // 코드 실행 후 시간
		long diffTime_1 = (afterTime_1 - beforeTime_1); //시간 차 계산
		
		//search_bs 실행시간 측정
		long beforeTime_2 = System.currentTimeMillis(); //코드 실행 전 시간
		bookManager.search_bs(id);	        
		long afterTime_2 = System.currentTimeMillis(); // 코드 실행 후 시간
		long diffTime_2 = (afterTime_2 - beforeTime_2); //시간 차 계산
		
		System.out.println("searchBook 실행 시간 : "+diffTime_1+"ms");
		System.out.println("search_bs 실행 시간 : "+diffTime_2+"ms");
		
		if(diffTime_1<diffTime_2) {
			System.out.println("searchBook이 "+(diffTime_2-diffTime_1)+"ms 더 빠릅니다.");
		}
		else {
			System.out.println("search_bs가 "+(diffTime_1-diffTime_2)+"ms 더 빠릅니다.");
		}
	}
}