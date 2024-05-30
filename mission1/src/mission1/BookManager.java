package mission1;
import java.util.*;

public class BookManager {
	
	// books 배열 선언
	public List<Book> books;
	
	// books 초기화
	public BookManager() {
		books = new ArrayList<Book>();
	}
	
	// 새로운 Comparator 정의
	public static Comparator<Book> id_comp = new Comparator<Book>() {
		@Override
		public int compare(Book b1, Book b2) {
			return (b1.getId() > b2.getId() ) ? 1 : (b1.getId() < b2.getId()) ? -1 : 0 ;
		}
	};
	
	// 이진탐색 메소드
	public void search_bs(Integer srcid) {
	
		// id 순으로 books 정렬
		Collections.sort(books, id_comp);
		
		// srcid 기준으로 검색 후 idx 반환
		int search_result = Collections.binarySearch(books, new Book(srcid), id_comp);
		
		if (search_result<0){
            System.out.println("검색된 도서가 없습니다.");
		}
		else {
			System.out.println("검색 결과: " + this.books.get(search_result));
		}
	}
	
	
	// 도서 추가
	public void addBook(Integer id, String title, String author, int year) {
		for(Book b: books) {
			if(id==b.getId()) {
				System.out.println("해당 ID("+id+") 는 이미 존재합니다.");
			}
		}
		
		Book book = new Book(id, title, author, year);
		books.add(book);
		System.out.println("Book{id: '"+id+"', 제목: '"+title+"', 저자: '"+author+"', 출판년도: '"+year+"}도서가 추가되었습니다.");
	
		
		return;
	}
	
	// 도서 검색 -> 불필요하지 않나요??
	public int searchBook() {
		System.out.println("검색 결과:");
		if(books.size()==0) {
			System.out.println("검색된 도서가 없습니다.");
			return 0;
		}
		
		for(Book b:books) {
			System.out.println("Book{id: '"+b.getId()+"', 제목: '"+b.getTitle()+"', 저자: '"+b.getAuthor()+"', 출판년도: '"+b.getYear()+"}도서가 추가되었습니다.");
		}
		return books.size();
	}

	// 도서 삭제 
	public void removeBook(Integer id) {
		for(Book b: books) {
			if(b.getId()==id) {
				books.remove((int) id);
				System.out.println("Book{id: '"+b.getId()+"', 제목: '"+b.getTitle()+"', 저자: '"+b.getAuthor()+"', 출판년도: '"+b.getYear()+"}도서를 삭제했습니다.");
				return;
			}
			
		}
		System.out.println("해당 ID("+id+")의 도서를 찾을 수 없습니다.");
		return;
	}

}
