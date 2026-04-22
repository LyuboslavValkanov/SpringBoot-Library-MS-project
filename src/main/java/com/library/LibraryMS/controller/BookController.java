package com.library.LibraryMS.controller;

import com.library.LibraryMS.entity.Book;
import com.library.LibraryMS.service.AuthorService;
import com.library.LibraryMS.service.BookService;
import com.library.LibraryMS.service.CategoryService;
import com.library.LibraryMS.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;



@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private PublisherService publisherService;

    @Autowired
    private CategoryService categoryService;


@GetMapping("/books")
    public String findAllBooks(Model model){
        List<Book> books =bookService.getAllBooks();
        model.addAttribute("books",books);
        return "books";
    }

 //details-button
    @GetMapping("/book/{id}")
  public String findBook( @PathVariable Long id,Model model){
    Book book= bookService.getBookById(id);
    model.addAttribute("book",book);
    return "book-detail";
  }
//delete-button
  @GetMapping("/remove-book/{id}")
    public String removeBook(@PathVariable Long id, Model model){
    bookService.removeBook(id);
    model.addAttribute("books",bookService.getAllBooks());
    return "books";
  }


  //need 2 Controller methods for update
    // @GetMapping("/update-book/{id}") change then submit -> post method
    //@PostMapping("save-update/{id}")
    //update-book - only you change the values after submit button ->the form will be submitted
  // and transferred to save-update{id}
  @GetMapping("/update-book/{id}")
  //display the changes and then submit with post method
    public String updateBook(@PathVariable Long id ,Model model){
    Book book = bookService.getBookById(id);
    model.addAttribute("categories",categoryService.getAllCategories());
      model.addAttribute("authors",authorService.getAllAuthors());
      model.addAttribute("publishers",publisherService.getAllPublishers());
      model.addAttribute("book",book);
      return "update-book";
  }

@PostMapping("save-update/{id}")
  public String updateBook( @PathVariable Long id , Book book, BindingResult result , Model model){
    if (result.hasErrors()){
        return "update-book";
    }

    Book existingBook = bookService.getBookById(id);
    existingBook.setIsbn(book.getIsbn());
    existingBook.setName(book.getName());
    existingBook.setDescription(book.getDescription());


    existingBook.setAuthors(book.getAuthors());
    existingBook.setCategories(book.getCategories());
    existingBook.setPublishers(book.getPublishers());

    bookService.updateBook(existingBook);
    model.addAttribute("books" ,bookService.getAllBooks());
    return "redirect:/books";
  }


    @GetMapping("/add-book")
    //identical to updateBook with 2 Mapping -Controller
    public String addBook(Book book,Model model){

        model.addAttribute("categories",categoryService.getAllCategories());
        model.addAttribute("authors",authorService.getAllAuthors());
        model.addAttribute("publishers",publisherService.getAllPublishers());
        return "add-book";
    }

    @PostMapping("/save-book")
    public String saveBook(Book book,BindingResult result,Model model){
    if (result.hasErrors()){
        return "add-book";
    }
    bookService.createBook(book);
    model.addAttribute("books",bookService.getAllBooks());
    return "redirect:/books";
    }


}
