package com.library.Model;

import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String title;

	private String author;

	@DateTimeFormat
	private LocalDate issuanceDate;

	@DateTimeFormat
	private LocalDate returnDate;

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(Long id, String title, String author, LocalDate issuanceDate, LocalDate returnDate) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.issuanceDate = issuanceDate;
		this.returnDate = returnDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public LocalDate getIssuanceDate() {
		return issuanceDate;
	}

	public void setIssuanceDate(LocalDate issuanceDate) {
		this.issuanceDate = issuanceDate;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", issuanceDate=" + issuanceDate
				+ ", returnDate=" + returnDate + "]";
	}

}
