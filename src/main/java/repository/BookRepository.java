package repository;

import entities.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BookRepository extends PagingAndSortingRepository<Book, Integer> {
    Page<Book> findAllByNameContainsOrAuthorContains(String name, String Author, Pageable pageInfo);
}
