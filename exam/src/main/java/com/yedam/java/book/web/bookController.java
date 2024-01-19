package com.yedam.java.book.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yedam.java.book.service.BookService;
import com.yedam.java.book.service.BookVO;

@Controller
public class bookController {
	
	@Autowired
	BookService bookService;
	
	@GetMapping("bookList")
	public String getBookList(Model model) {
		List<BookVO> list = bookService.getBookAll();
		model.addAttribute("bookList", list);
		return "book/bookList";
	}
		
	@GetMapping("bookInsert")
	public String bookInsertForm(BookVO bookVO, Model model) {
		BookVO findVO = bookService.getBookInfo(bookVO);
		model.addAttribute("bookInfo", findVO);
		return "book/bookInsert";
	}
	
	@PostMapping("bookInsert")
	public String bookInsertProcess(BookVO bookVO) {
		int bookNo = bookService.insertBook(bookVO);

		String path = null;
		if(bookNo > -1) {
			path = "redirect:bookList";
		} else {
			path = "redirect:bookList";
		}
		return path;
	}
	
	@GetMapping("bookRent")
	public String bookRent() {
		return "book/bookRent";
	}
}
