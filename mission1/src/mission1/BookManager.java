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
	public static Comparator<Book> idComparator = new Comparator<Book>() {
		@Override
		public int compare(Book b1, Book b2) {
			return (b1.getId() > b2.getId() ) ? 1 : (b1.getId() < b2.getId()) ? -1 : 0 ;
		}
	};
	
	// 이진탐색 메소드
	public boolean search_bs(Integer srcId) {
	
		// id 순으로 books 정렬
		Collections.sort(books, idComparator);
		
		// srcId 기준으로 검색 후 idx 반환
		int search_result = Collections.binarySearch(books, new Book(srcId), idComparator);
		
		if (search_result < 0){
            System.out.println("검색된 도서가 없습니다.");
            return false;
		}
		else {
			System.out.println("검색 결과:");
			Book bookFound = books.get(search_result); 
			System.out.println("Book{id: '"+bookFound.getId()+"', 제목: '"+bookFound.getTitle()+"', "
					+ "저자: '"+bookFound.getAuthor()+"', 출판연도: "+bookFound.getYear()+"}");
			return true;
		}
	}
	
	
	// 도서 추가
	public void addBook(Integer id, String title, String author, int year) {
		for(Book b: books) {
			if(id.equals( b.getId())) {
				System.out.println("해당 ID("+id+") 는 이미 존재합니다.");
				return;
			}
		}
		Book book = new Book(id, title, author, year);
		books.add(book);
		return;
	}
	
	// 도서 검색 -> 이진탐색과 성능 비교 필요
	public boolean searchBook(Integer id) {		
		for(Book b:books) {
			if(b.getId().equals(id)) {
				System.out.println("검색 결과:");
				System.out.println("Book{id: '"+b.getId()+"', 제목: '"+b.getTitle()+"', 저자: '"
						+b.getAuthor()+"', 출판연도: "+b.getYear()+"}");
				return true;
			}
		}
		System.out.println("검색된 도서가 없습니다.");
		return false;
	}

	// 도서 삭제 
	public void removeBook(Integer id) {
		for(Book b: books) {
			if(b.getId().equals(id)) {
				books.remove(b);
				System.out.println("Book{id: '"+b.getId()+"', 제목: '"+b.getTitle()+"', 저자: '"
						+b.getAuthor()+"', 출판연도: "+b.getYear()+"}도서를 삭제했습니다.");
				return;
			}
		}
		System.out.println("해당 ID("+id+")의 도서를 찾을 수 없습니다.");
		return;
	}
}