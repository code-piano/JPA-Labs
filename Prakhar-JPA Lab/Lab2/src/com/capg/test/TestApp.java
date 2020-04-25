package com.capg.test;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.capg.entities.Author;
import com.capg.entities.Book;

public class TestApp {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("Assignment2");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
				Author auth=new Author(101, "Ps");
		Author auth1=new Author(102,"Dr. Kapoor");
		Book b=new Book(104,"Alis",122,"A",4800);
		
		entityManager.getTransaction().begin();
		entityManager.persist(auth);
		entityManager.persist(auth1);
		entityManager.persist(b);
		entityManager.getTransaction().commit();
		System.out.println("Data has been Saved");
		Query namedquery=entityManager.createNamedQuery("getbook");
		List<Author> author=namedquery.getResultList();
		for(Author aut:author)
		{
			System.out.println(aut);
			System.out.println("Executed Result");
		}
		entityManagerFactory.close();
		

		
	}

}
