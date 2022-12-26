package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "library_books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long serialNo;
    private String name;

    @ManyToOne()
    @JoinColumn(name = "fk_student_id",nullable = false)
    private Student gitaStudent;
}
