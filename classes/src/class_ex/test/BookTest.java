package class_ex.test;

import class_ex.book.Book;

public class BookTest {

	public static void main(String[] args) {
		//객체(인스턴스) 생성
		Book book1 = new Book();
		
		Book book2 = new Book(102, "천개의 파랑");

		// 패키지이름.클래스이름 -> 클래스의 실제이름
		// class_ex.book.Book@4e50df2e
		System.out.println(book1);
		
		// book1.bookNumber = 101;
		// book1.bookTitle = "이것이 자바다.";
		
		book1.setBookNumber(101);
		book1.setBookTitle("이것이 자바다");
		
		System.out.println("번호 : " + book1.getBookNumber());
		System.out.println("제목 : " + book1.getBookTitle());
		System.out.println("번호 : " + book2.getBookNumber());
		System.out.println("제목 : " + book2.getBookTitle());
	}

}
