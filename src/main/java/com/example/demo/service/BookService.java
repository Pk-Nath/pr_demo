package com.example.demo.service;

import com.example.demo.dto.BookDto;

import java.util.List;

public interface BookService {
    BookDto createBook(long studentId,BookDto bookDto);
    List<BookDto> findAllBookByStudentId(long studentId);
}
