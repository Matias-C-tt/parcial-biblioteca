package main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entidades.Autor;

public class Biblioteca {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BibliotecaPU");
		EntityManager em = emf.createEntityManager();

		try {
			em.getTransaction().begin();

			Autor autor = new Autor("Pepito","Pepe","Escritor, amante de novelas");
			em.persist(autor);
			
			em.flush();
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}

		em.close();
		emf.close();
	}
}
