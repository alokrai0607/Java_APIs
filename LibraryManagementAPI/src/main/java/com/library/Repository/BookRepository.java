package com.library.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.Model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
	// Add custom queries if needed
}

