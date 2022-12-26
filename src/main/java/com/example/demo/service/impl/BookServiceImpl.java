package com.example.demo.service.impl;

import com.example.demo.dto.BookDto;
import com.example.demo.entity.Book;
import com.example.demo.entity.Student;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;
    private StudentRepository studentRepository;

    public BookServiceImpl(BookRepository bookRepository, StudentRepository studentRepository) {
        this.bookRepository = bookRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public BookDto createBook(long studentId,BookDto bookDto) {
        Student student = studentRepository.findById(studentId).get();
        Book book=mapToEntity(bookDto);
        book.setGitaStudent(student);
        Book save = bookRepository.save(book);
        return mapToDto(save);
    }

    @Override
    public List<BookDto> findAllBookByStudentId(long studentId) {
        List<Book> byStudentId = bookRepository.findByGitaStudentRollNo(studentId);
        List<BookDto> collect = byStudentId.stream().map(book -> mapToDto(book)).collect(Collectors.toList());
        return collect;
    }

    private BookDto mapToDto(Book save) {
        BookDto dto=new BookDto();
        dto.setSerialNo(save.getSerialNo());
        dto.setName(save.getName());
        return dto;
    }

    private Book mapToEntity(BookDto bookDto) {
        Book book=new Book();
        book.setName(bookDto.getName());
        return book;
    }
}
