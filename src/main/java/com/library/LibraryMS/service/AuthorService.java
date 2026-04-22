package com.library.LibraryMS.service;

import com.library.LibraryMS.entity.Author;
import com.library.LibraryMS.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;


    public List<Author> getAllAuthors(){
        return authorRepository.findAll(Sort.by("id").ascending());
    }

    public Author getAuthorById(Long id){
        Author author = authorRepository.findById(id).orElseThrow(()->new RuntimeException("Author with this Id cannot be found !"));
        return author;

    }

    public void createAuthor(Author author){
        authorRepository.save(author);
    }

    public void deleteAuthor(Long id){
        Author author = authorRepository.findById(id).orElseThrow(()->new RuntimeException("Author with this Id cannot be found !"));

        authorRepository.deleteById(author.getId());
    }

    public void updateAuthor(Author author){
        authorRepository.save(author);
    }
}
