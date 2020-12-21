package controllers;

import entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import service.BookService;

@Controller
@RequestMapping("/library")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/home")
    public String home(Model model, @PageableDefault(value = 5) Pageable pageInfo ){
        Page<Book> books = bookService.findAll(pageInfo);

        model.addAttribute("books",books);
        return "list";
    }

    @GetMapping("/{id}")
    public String showInformation(@PathVariable Integer id,Model model){
        Book book = bookService.findOne(id);
        model.addAttribute("book",book);
        return "borrow";
    }

    @GetMapping("/borrow/{id}")
    public String borrow(@PathVariable Integer id){
        try {
            bookService.borrowBook(id);
        }catch (Exception e){
            return "false";
        }

        return "success";
    }
}
