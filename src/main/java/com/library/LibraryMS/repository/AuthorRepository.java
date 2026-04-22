package com.library.LibraryMS.repository;

import com.library.LibraryMS.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository  extends JpaRepository<Author,Long> {
}
