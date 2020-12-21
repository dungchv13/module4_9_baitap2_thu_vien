package service;

import entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import repository.BookRepository;
import service.exception.LessThanZeroException;

public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Page<Book> findAll(Pageable pageInfo) {
        return bookRepository.findAll(pageInfo);
    }

    @Override
    public Page<Book> search(String keyword, Pageable pageInfo) {
        return bookRepository.findAllByNameContainsOrAuthorContains(keyword,keyword,pageInfo);
    }

    @Override
    public Book findOne(Integer id) {
        return bookRepository.findOne(id);
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void borrowBook(Integer id) throws LessThanZeroException {

            Book book = findOne(id);
            if(book.getQuantity() == 0){
                throw new LessThanZeroException();
            }

            book.setQuantity(book.getQuantity() - 1);
            save(book);

    }
}
