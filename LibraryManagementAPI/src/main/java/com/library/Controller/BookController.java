package com.library.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.library.Model.Book;
import com.library.Service.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService bookService;

	@PostMapping("/books")
	public Book createBook(@RequestBody Book book) {
		return bookService.createBook(book);
	}

	@GetMapping("/{id}")
	public Book getBookById(@PathVariable Long id) {
		return bookService.getBookById(id);

	}

	@GetMapping("/books")
	public List<Book> getAllBooks() {
		return bookService.getAllBooks();
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
		Book existingBook = bookService.getBookById(id);

		if (existingBook == null) {
			return new ResponseEntity<>("Book Not Found", HttpStatus.NOT_FOUND);
		}

		// Update the fields you want to modify
		existingBook.setTitle(updatedBook.getTitle());
		existingBook.setAuthor(updatedBook.getAuthor());
		existingBook.setIssuanceDate(updatedBook.getIssuanceDate());
		existingBook.setReturnDate(updatedBook.getReturnDate());

		// Save the updated book
		Book updatedBookResult = bookService.updateBook(id, existingBook);

		if (updatedBookResult != null) {
			return new ResponseEntity<>(updatedBookResult, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Failed to update book", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteBook(@PathVariable Long id) {
		try {
			boolean isDeleted = bookService.deleteBook(id);

			if (isDeleted) {
				return new ResponseEntity<>("Book deleted successfully", HttpStatus.OK);
			} else {
				return new ResponseEntity<>("Book not found", HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>("Error deleting book: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// this method is not working properly i don't know why it is not working .
	@GetMapping("/{id}/calculate-charge")
	public double calculateTotalCharge(@PathVariable Long id) {
		return bookService.calculateTotalCharge(id);
	}
}
