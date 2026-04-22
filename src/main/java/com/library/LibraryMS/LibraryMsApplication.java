package com.library.LibraryMS;

import com.library.LibraryMS.entity.Author;
import com.library.LibraryMS.entity.Book;
import com.library.LibraryMS.entity.Category;
import com.library.LibraryMS.entity.Publisher;
import com.library.LibraryMS.service.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LibraryMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryMsApplication.class, args);


	}

	@Bean
	public CommandLineRunner initialize(BookService bookService){
		return args -> {
//			Book book1 = new Book("isbn1","bookName1","bookDescription1");
//			Author author1= new Author("authorName1","AuthorDescription1");
//			Category category1=new Category("categoryName1");
//			Publisher publisher1=new Publisher("publisherName1");
//			book1.addAuthor(author1);
//			book1.addCategory(category1);
//			book1.addPublisher(publisher1);
//			bookService.createBook(book1);
//
//			Book book2 = new Book("isbn2","bookName2","bookDescription2");
//			Author author2= new Author("authorName2","AuthorDescription2");
//			Category category2=new Category("categoryName2");
//			Publisher publisher2=new Publisher("publisherName2");
//			book2.addAuthor(author2);
//			book2.addCategory(category2);
//			book2.addPublisher(publisher2);
//			bookService.createBook(book2);
//
//			Book book3 = new Book("isbn3","bookName3","bookDescription3");
//			Author author3= new Author("authorName3","AuthorDescription3");
//			Category category3=new Category("categoryName3");
//			Publisher publisher3=new Publisher("publisherName3");
//			book3.addAuthor(author3);
//			book3.addCategory(category3);
//			book3.addPublisher(publisher3);
//			bookService.createBook(book3);


			Book book1 = new Book("978-1591846352","The Obstacle is the Way",
					"Overcoming obstacles, Stoic philosophy, resilience, success mindset");
			Author author1= new Author("Ryan Holiday","Stoicism, self-discipline, modern philosophy writing");
			Category category1=new Category("Self-help / Philosophy");
			Publisher publisher1=new Publisher("Portfolio");
			book1.addAuthor(author1);
			book1.addCategory(category1);
			book1.addPublisher(publisher1);
			bookService.createBook(book1);

			Book book2 = new Book("978-0743269513","The 7 Habits of Highly Effective People",
					"Personal effectiveness, habits, leadership, productivity, character ethics");
			Author author2= new Author("Stephen R. Covey","leadership, personal development, principle-centered thinking");
			Category category2=new Category("Self-help / Personal Development");
			Publisher publisher2=new Publisher("Free Press");
			book2.addAuthor(author2);
			book2.addCategory(category2);
			book2.addPublisher(publisher2);
			bookService.createBook(book2);


			Book book3 = new Book("978-0062515674","The Monk Who Sold His Ferrari",
					"Life purpose, mindfulness, success, inner peace, self-discovery");
			Author author3= new Author("Robin Sharma","leadership, personal growth, motivation");
			Category category3=new Category("Self-help / Spirituality");
			Publisher publisher3=new Publisher("HarperCollins");
			book3.addAuthor(author3);
			book3.addCategory(category3);
			book3.addPublisher(publisher3);
			bookService.createBook(book3);

			Book book4 = new Book("978-0671027032","How to Win Friends and Influence People",
					"Communication skills, relationships, persuasion, influence, social success");
			Author author4= new Author("Dale Carnegie","communication, interpersonal skills, self-improvement");
			Category category4=new Category("Self-help / Communication");
			Publisher publisher4=new Publisher("Simon & Schuster");
			book4.addAuthor(author4);
			book4.addCategory(category4);
			book4.addPublisher(publisher4);
			bookService.createBook(book4);


			Book book5 = new Book("978-0140449136","Crime and Punishment",
					"Guilt, morality, crime, psychological conflict, redemption");
			Author author5= new Author("Fyodor Dostoevsky","psychological fiction, philosophy, existential themes");
			Category category5=new Category("Fiction / Classic Literature");
			Publisher publisher5=new Publisher("Penguin Classics");
			book5.addAuthor(author5);
			book5.addCategory(category5);
			book5.addPublisher(publisher5);
			bookService.createBook(book5);

			Book book6 = new Book("978-1585424337","Think and Grow Rich",
					"Wealth mindset, success principles, goal setting, persistence, personal achievement");
			Author author6= new Author("Napoleon Hill","success philosophy, motivation, personal achievement");
			Category category6=new Category("Self-help / Personal Finance");
			Publisher publisher6=new Publisher("TarcherPerigee");
			book6.addAuthor(author6);
			book6.addCategory(category6);
			book6.addPublisher(publisher6);
			bookService.createBook(book6);


			Book book7 = new Book("978-0785264293","The Traveler’s Gift",
					"Life decisions, success principles, personal responsibility, purpose, mindset");
			Author author7= new Author("Andy Andrews","motivation, leadership, personal development");
			Category category7=new Category("Self-help / Inspirational Fiction");
			Publisher publisher7=new Publisher("Thomas Nelson");
			book7.addAuthor(author7);
			book7.addCategory(category7);
			book7.addPublisher(publisher7);
			bookService.createBook(book7);


			Book book8 = new Book("978-0140177398","Of Mice and Men",
					"Friendship, loneliness, dreams, hardship, human struggle");
			Author author8= new Author("John Steinbeck ","social realism, human conditions, American literature");
			Category category8=new Category("Fiction / Classic Literature");
			Publisher publisher8=new Publisher("Penguin Books");
			book8.addAuthor(author8);
			book8.addCategory(category8);
			book8.addPublisher(publisher8);
			bookService.createBook(book8);


			Book book9 = new Book("978-0671791544","Awaken the Giant Within",
					"Personal power, self-mastery, goal achievement, motivation, mindset");
			Author author9= new Author("Tony Robbins ","motivation, personal development, peak performance");
			Category category9=new Category("Self-help / Personal Development");
			Publisher publisher9=new Publisher("Free Press");
			book9.addAuthor(author9);
			book9.addCategory(category9);
			book9.addPublisher(publisher9);
			bookService.createBook(book9);

			Book book10 = new Book("978-0915818012","Mind Power Into the 21st Century",
					"Mind training, visualization, positive thinking, self-mastery, success");
			Author author10= new Author("John Kehoe ","mind development, personal empowerment, mental training");
			Category category10=new Category("Self-help / Personal Development");
			Publisher publisher10=new Publisher("H.J. Kramer");
			book10.addAuthor(author10);
			book10.addCategory(category10);
			book10.addPublisher(publisher10);
			bookService.createBook(book10);


			Book book11 = new Book("978‑1472294159","Dopamine Nation",
					"Pleasure vs pain balance, addiction mechanisms, dopamine overload, modern compulsions");
			Author author11= new Author("Anna Lembke ","addiction neuroscience, clinical psychology, behavioral science");
			Category category11=new Category("Non‑fiction / Psychology / Self‑help");
			Publisher publisher11=new Publisher("Headline Publishing Group");
			book11.addAuthor(author11);
			book11.addCategory(category11);
			book11.addPublisher(publisher11);
			bookService.createBook(book11);

			Book book12 = new Book("978-0452289963","A New Earth",
					"Consciousness, presence, ego transcendence, spiritual awakening, mindfulness");
			Author author12= new Author("Eckhart Tolle ","spiritual growth, mindfulness, personal transformation");
			Category category12=new Category("Self-help / Spirituality");
			Publisher publisher12=new Publisher("Penguin Group");
			book12.addAuthor(author12);
			book12.addCategory(category12);
			book12.addPublisher(publisher12);
			bookService.createBook(book12);


			Book book13 = new Book("978-0747532699","Harry Potter and the Philosopher's Stone",
					"Magic, friendship, Hogwarts, adventure, coming-of-age");
			Author author13= new Author("J.K. Rowling ","fantasy, storytelling, young adult fiction");
			Category category13=new Category("Fiction / Fantasy");
			Publisher publisher13=new Publisher("Bloomsbury");
			book13.addAuthor(author13);
			book13.addCategory(category13);
			book13.addPublisher(publisher13);
			bookService.createBook(book13);
















		};
	}

}
