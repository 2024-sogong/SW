package mission1;



public class Book {

		
		private Integer id; //id
		private String title; //제목
		private String author; //저자
		private int year; //출판 연도
		
		// Book 생성자
		public Book (Integer id, String title, String author, int year){
			this.id=id;
			this.title=title;
			this.author=author;
			this.year=year;
		}
		
		// 이진탐색 시 사용하기 위해 오버로딩
		public Book (Integer id){
			this.id=id;
		}
		
		// Id 얻기
		public Integer getId() {
			return this.id;
		}
		
		
		// Title 얻기
		public String getTitle() {
			return this.title;
		}
		
		//Author 얻기
		public String getAuthor() {
			return this.author;
		}
		
		// 연도 얻기
		public int getYear() {
			return this.year;
		}	


}


