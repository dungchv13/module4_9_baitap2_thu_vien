package service;

import entities.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import service.exception.LessThanZeroException;

public interface BookService {

    Page<Book> findAll(Pageable pageInfo);

    Page<Book> search(String keyword, Pageable pageInfo);

    Book findOne(Integer id);

    Book save(Book book);

    void borrowBook(Integer id) throws LessThanZeroException;
}
