package com.library.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.Model.Book;
import com.library.Repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	private static final double DAILY_CHARGE = 10.00;

	@Override
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	@Override
	public Book getBookById(Long id) {
		return bookRepository.findById(id).orElse(null);
	}

	public Book createBook(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public Book updateBook(Long id, Book book) {
		if (bookRepository.existsById(id)) {
			book.setId(id);
			return bookRepository.save(book);
		}
		return null;
	}

	@Override
	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
		System.out.println(id + "no content deleted Sucessfully");
	}

	@Override
	public double calculateTotalCharge(Long id) {
		Book book = getBookById(id);
		if (book != null && book.getReturnDate() != null && book.getReturnDate().isBefore(LocalDate.now())) {
			long overdueDays = ChronoUnit.DAYS.between(book.getReturnDate(), LocalDate.now());
			overdueDays = Math.max(0, overdueDays);
			return overdueDays * DAILY_CHARGE;
		}
		return 0;
	}

}
