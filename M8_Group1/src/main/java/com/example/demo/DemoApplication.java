package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        
        /*
         * 
         * get
http://localhost:9091/api/v1/movies/all
get
http://localhost:9091/api/v1/movies/1
post
http://localhost:9091/api/v1/movies
{
  "title": "Titanic",
  "director": "James Cameron",
  "year": 1997,
  "genre": "Romance"
}
delete
http://localhost:9091/api/v1/movies/6
         */
    }
}