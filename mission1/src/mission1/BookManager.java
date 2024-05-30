package mission1;
import java.util.*;

public class BookManager {
public List<Book> books = new ArrayList<>();
	
	public class Book{
	
		private Integer id; //id
		private String title; //제목
		private String author; //저자
		private int year; //출판 연도
		
		public Book (Integer id, String title, String author, int year){
			this.id=id;
			this.title=title;
			this.author=author;
			this.year=year;
		}
		
		public Integer getId() {
			return this.id;
		}
		
		public String getTitle() {
			return this.title;
		}
		
		public String getAuthor() {
			return this.author;
		}
		
		public int getYear() {
			return this.year;
		}	

		public static final Comparator<Book> id_order=new IdComparator();
		
		private static class IdComparator implements Comparator<Book>{
			public int compare(Book b1, Book b2) {
				return (b1.id>b2.id)?1:(b1.id<b2.id)?-1:0;
			}
		}
	}

	public void search_bs(Integer srcid) {
		books x;
		int idx=Arrays.binarySearch(books, new Book(srcid,"","",0), Book.id_order);
		
		if(idx<0){
            System.out.println("검색된 도서가 없습니다.");
		}
		else {
			System.out.println("검색 결과: " + x[idx]);
		}
	}
	
	
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
