package com.example.demo;

public class Book {
    private int id;
    private String title;
    private String author;

    // Constructor
    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    // Getters (needed for JSON)
    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
}