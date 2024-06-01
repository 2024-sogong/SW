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
	
	
	void testBinarySearchBook() {
		System.out.println("\n< Binary Search >");
		bookManager.addBook(1, "자바 기초", "Jane", 2021);
		bookManager.addBook(2, "소프트웨어 공학", "Tom", 2014);
		assertEquals(true, bookManager.search_bs(1));
		assertEquals(true, bookManager.search_bs(2));
		assertEquals(false, bookManager.search_bs(3)); // 검색 결과 없음
	}
	
	
	//성능 비교
	@Test
	void searchPerformanceTest(Integer id) {
		
	Integer i;
	for(i=1;i<=20;i++) {
		bookManager.addBook(i,"자바 기초","Jane",2021);
	}
		//searchBook 실행시간 측정
		long beforeTime_1 = System.currentTimeMillis(); //코드 실행 전 시간   
		bookManager.searchBook(id);	        
		long afterTime_1 = System.currentTimeMillis(); // 코드 실행 후 시간
		long diffTime_1 = (afterTime_1 - beforeTime_1)/1000; //시간 차 계산
		System.out.println("searchBook 실행 시간 : "+diffTime_1+"초");
		
		//search_bs 실행시간 측정
		long beforeTime_2 = System.currentTimeMillis(); //코드 실행 전 시간   
		bookManager.search_bs(id);	        
		long afterTime_2 = System.currentTimeMillis(); // 코드 실행 후 시간
		long diffTime_2 = (afterTime_2 - beforeTime_2)/1000; //시간 차 계산
		System.out.println("search_bs 실행 시간 : "+diffTime_2+"초");
		
		if(diffTime_1<diffTime_2) {
			System.out.println("searchBook이 "+(diffTime_2-diffTime_1)+"초 더 빠릅니다.");
		}
		else {
			System.out.println("search_bs가 "+(diffTime_1-diffTime_2)+"초 더 빠릅니다.");
		}
	}
}