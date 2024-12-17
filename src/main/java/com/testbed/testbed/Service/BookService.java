package com.testbed.testbed.Service;

import com.testbed.testbed.domain.Book;
import com.testbed.testbed.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

//    @Cacheable(cacheNames = "books", key = "#id")
    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @CachePut(cacheNames = "books", key = "#book.id")
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @CacheEvict(cacheNames = "books",key = "#id")
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    @CachePut(cacheNames = "books", key = "#id")
    public Book updateBook(Long id, Book bookDetails) {
        Book existingBook = bookRepository.findById(id).orElse(null);
        if (existingBook != null) {
            existingBook.setTitle(bookDetails.getTitle())
                    .setAuthor(bookDetails.getAuthor())
                    .setIsbn(bookDetails.getIsbn())
                    .setPrice(bookDetails.getPrice())
                    .setId(id); // This is where the chain-style setter is used
            return bookRepository.save(existingBook);
        } else {
            return null; // Return null or throw a custom exception
        }
    }
}
