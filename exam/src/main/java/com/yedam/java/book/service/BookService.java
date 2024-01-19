package com.yedam.java.book.service;

import java.util.List;
import java.util.Map;

public interface BookService {
	
	public List<BookVO> getBookAll();
	
	public BookVO getBookInfo(BookVO bookVO);
	
	public int insertBook(BookVO bookVO);
	
	public Map<String, Object> updateBook(BookVO bookVO);
	
	public boolean deleteBook(int bookVO);
}
