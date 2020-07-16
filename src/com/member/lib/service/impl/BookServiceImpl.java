package com.member.lib.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.member.lib.dao.BookDAO;
import com.member.lib.dao.Impl.BookDAOImpl;
import com.member.lib.service.BookService;


public class BookServiceImpl implements BookService {
	private BookDAO bookDAO = new BookDAOImpl();
	@Override
	public Map<String, Object> insertBook(Map<String, Object> Book) {
		int result = bookDAO.insertBook(Book);
		Map<String,Object> rMap = new HashMap<>();
		rMap.put("msg",(result==1)?"도서입력 성공~":"도서입력 실패");
		rMap.put("cnt",result);
		return rMap;
	}

	@Override
	public Map<String, Object> updateBook(Map<String, Object> Book) {
		int result = bookDAO.updateBook(Book);
		Map<String,Object> rMap = new HashMap<>();
		rMap.put("msg",(result==1)?"도서수정 성공~":"도서수정 실패");
		rMap.put("cnt",result);
		// TODO Auto-generated method stub
		return rMap;
	}


	@Override
	public Map<String, Object> deleteBook(int bNum) {
		int result = bookDAO.deleteBook(bNum);
		Map<String,Object> rMap = new HashMap<>();
		rMap.put("msg",(result==1)?"도서삭제 성공~":"도서삭제 실패");
		rMap.put("cnt",result);
		// TODO Auto-generated method stub
		return rMap;
	}

	@Override
	public List<Map<String, Object>> selectBookList(Map<String, Object> Book) {
		return bookDAO.selectBookList(Book);
	}

	@Override
	public Map<String, Object> selectBook(int bNum) {
		return bookDAO.selectBook(bNum);
	}
	public static void main(String[] args) {
		BookService BookService = new BookServiceImpl();
		Map<String,Object> book =  new HashMap<>();
		book.put("b_title", "오징어의 정석");
		book.put("b_author", "오선생");
		book.put("b_desc", "오징어 전문서적");
		book.put("b_num",22);
		
//		Map<String,Object> rMap = BookService.insertBook(book);
//		System.out.println(rMap); //생성
		
//	    List<Map<String,Object>> bookList = BookService.selectBookList(book);		
//		for(Map<String,Object>bok:bookList) {
//			System.out.println(bok);
//		} //전체도서
		
//		Map<String,Object> rMap = memberService.deleteMember(33);
//		System.out.println(rMap); //삭제
		
		Map<String,Object> rMap = BookService.updateBook(book);
		System.out.println(rMap); //업데이트
		

//		System.out.println(BookService.selectBook(22)); //하나만 찾기
		
		
		
		
	}
}
