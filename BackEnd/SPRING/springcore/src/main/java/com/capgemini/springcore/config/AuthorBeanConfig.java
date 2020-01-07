package com.capgemini.springcore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.capgemini.springcore.beans.Author;
import com.capgemini.springcore.beans.Book;
@Configuration
public class AuthorBeanConfig {
	@Bean("Author")
	public Author getAuthor()
	{
		Author author=new Author();
		author.setName("james Gashloin");
		return author;
	}
	@Bean
	public Book getBook()
	{
		Book book=new Book();
		book.setAuthor(getAuthor());
		
		book.setName("JAvA");
		return book;
	}

}
