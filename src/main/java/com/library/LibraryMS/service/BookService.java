package com.library.LibraryMS.service;

import com.library.LibraryMS.entity.Book;
import com.library.LibraryMS.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;


    public List<Book> getAllBooks(){
        return bookRepository.findAll(Sort.by("id").ascending());
    }

    public Book getBookById(Long id){
        Book book = bookRepository.findById(id).orElseThrow(()->new RuntimeException("Book with this Id cannot be found !"));
        return book;
    }


    public void createBook(Book book){
        bookRepository.save(book);
    }

    public void removeBook(Long id){
        Book book = bookRepository.findById(id).orElseThrow(()->new RuntimeException("Book with this Id cannot be found !"));

        bookRepository.deleteById(book.getId());

    }

    public void updateBook (Book book){
        bookRepository.save(book);


    }


}
