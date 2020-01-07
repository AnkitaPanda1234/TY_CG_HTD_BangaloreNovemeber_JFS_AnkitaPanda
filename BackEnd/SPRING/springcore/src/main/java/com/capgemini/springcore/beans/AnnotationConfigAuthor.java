package com.capgemini.springcore.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.capgemini.springcore.config.AuthorBeanConfig;

public class AnnotationConfigAuthor {
	public static void main(String[] args) {
	
	ApplicationContext context=
			new AnnotationConfigApplicationContext( AuthorBeanConfig.class);
	
	Author author=context.getBean(Author.class);
	System.out.println(author.getName());
	
	      Book book=context.getBean(Book.class);
			System.out.println(book.getName());
		
	

}
}