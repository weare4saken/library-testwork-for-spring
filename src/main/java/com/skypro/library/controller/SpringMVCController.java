package com.skypro.library.controller;

import com.skypro.library.dao.BookDAO;
import com.skypro.library.entity.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/skypro")
public class SpringMVCController {

    @RequestMapping("/web")
    public String getInfo(Model model) {

//        model.addAttribute("books", bookDAO.getBooks());

//        model.addAttribute("book_name", book.getBookName());
//        model.addAttribute("book_author", book.getBookAuthor());
//        model.addAttribute("release_year", book.getReleaseYear());
//        model.addAttribute("isbn", book.getIsbn());

        return "dashboard";
    }
}
