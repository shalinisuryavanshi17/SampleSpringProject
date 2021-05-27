package com.example.repositories;

import com.example.domain.Book;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long>
{
    
}