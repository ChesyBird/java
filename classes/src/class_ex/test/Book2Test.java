package class_ex.test;

import class_ex.book.Book;

public class Book2Test {

	public static void main(String[] args) {
		// 객체 배열 생성
		Book[] books = new Book[3];
		
		books[0] = new Book(101,"이것이 자바다");
		books[1] = new Book(102,"천 개의 파랑");
		books[2] = new Book(103,"말하지 않고 말하기");
		
		System.out.println("배열의 크기: " + books.length + "개");
		
		// 1번인덱스 객체 출력
		System.out.println("책번호: " + books[1].getBookNumber());
		System.out.println("책제목: " + books[1].getBookTitle());
		System.out.println("================================");
		
		// 전체 출력(for문)
		/*for(int i=0; i<books.length; i++) {
			System.out.println("책번호: " + books[i].getBookNumber());
			System.out.println("책제목: " + books[i].getBookTitle());
		}*/
		
		// 향상for문: for(자료형 변수:배열){}
		for(Book book : books) {
			System.out.println("책번호: " + book.getBookNumber());
			System.out.println("책제목: " + book.getBookTitle());
		}

	}

}
