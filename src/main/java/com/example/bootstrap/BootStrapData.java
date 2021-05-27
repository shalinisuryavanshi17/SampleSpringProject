package com.example.bootstrap;

import com.example.domain.Author;
import com.example.domain.Book;
import com.example.domain.Publisher;
import com.example.repositories.AuthorRepository;
import com.example.repositories.BookRepository;
import com.example.repositories.PublisherRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository=publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // creating authors and book
        Publisher publisher = new Publisher();
        publisher.setName("SSH publication");
        publisher.setAddress("ks nagar");
        publisher.setCity("hyderabad");
        publisher.setState("telangana");
        publisher.setZip("5000006");
        publisherRepository.save(publisher);

        Author author1 = new Author();
        author1.setFirstName("shalini");
        author1.setLastName("suryavanshi");
        Book book1 = new Book("my programming journey", "1234567");
        book1.getAuthors().add(author1); // adding author to books
        author1.getBooks().add(book1);// adding books to author
        book1.setPublisher(publisher);
        publisher.getBooks().add(book1);
        
        // save author in authorrepo
        authorRepository.save(author1);
        // save books to bookrepo
        bookRepository.save(book1);
        publisherRepository.save(publisher);
        Author author2 = new Author();
        author2.setFirstName("sample");
        author2.setLastName("suryavanshi");
        Book book2 = new Book("my sample journey", "75745667");
        book1.getAuthors().add(author2); // adding author to books
        author1.getBooks().add(book2);// adding books to author
        authorRepository.save(author2);
        bookRepository.save(book2);
        book2.setPublisher(publisher);
        publisher.getBooks().add(book2);
        publisherRepository.save(publisher);    

        System.out.println("started in bootstrap");
        System.out.println("number of books in bookrepo is " + bookRepository.count());
        System.out.println("number of books in publisher is "+publisher.getBooks().size());

    }

}