package com.example.demo.controller;

import com.example.demo.dto.BookDto;
import com.example.demo.dto.StudentDto;
import com.example.demo.service.BookService;
import com.example.demo.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class BookController {
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @PostMapping("/{studentId}/books")
    public ResponseEntity<BookDto> createBookByStudentId(@RequestBody BookDto bookDto,
                                                         @PathVariable long studentId){
        return new ResponseEntity<>(bookService.createBook(studentId,bookDto),HttpStatus.CREATED);
    }
    @GetMapping("/{studentId}/books")
    public List<BookDto> findAllBooksByStudentId(@PathVariable long studentId){
        return bookService.findAllBookByStudentId(studentId);
    }
}
