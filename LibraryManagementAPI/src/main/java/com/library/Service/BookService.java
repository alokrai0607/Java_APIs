package com.library.Service;

import java.util.List;

import com.library.Model.Book;

public interface BookService {

	List<Book> getAllBooks();

	Book getBookById(Long id);

	Book createBook(Book book);

	Book updateBook(Long id, Book book);

	boolean deleteBook(Long id);

	double calculateTotalCharge(Long id);
}

