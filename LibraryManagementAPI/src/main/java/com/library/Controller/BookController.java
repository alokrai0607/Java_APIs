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
	public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
		return bookService.updateBook(id, book);
	}

	@DeleteMapping("/{id}")
	public void deleteBook(@PathVariable Long id) {
		bookService.deleteBook(id);
		System.out.println("Deleted Successfully");
	}
	
	
//	@DeleteMapping("/{id}")
//	public ResponseEntity<String> deleteBook(@PathVariable Long id) {
//	    boolean isDeleted = bookService.deleteBook(id);
//	    if (isDeleted) {
//	        return ResponseEntity.ok("Book with ID " + id + " deleted successfully.");
//	    } else {
//	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book with ID " + id + " Not deleted ");
//	    }
//	}

  // this method is not working properly i don't know why it is not working .
	@GetMapping("/{id}/calculate-charge")
	public double calculateTotalCharge(@PathVariable Long id) {
		return bookService.calculateTotalCharge(id);
	}
}
