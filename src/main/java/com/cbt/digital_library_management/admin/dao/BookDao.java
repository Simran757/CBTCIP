package com.cbt.digital_library_management.admin.dao;

import java.util.List;

import com.cbt.digital_library_management.dto.Books;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;

public class BookDao {
	@PersistenceContext
	EntityManager em = Persistence.createEntityManagerFactory("library-project").createEntityManager();
	EntityTransaction et = em.getTransaction();
	public Books saveBooksDao(Books book){
		try {
			et.begin();
			
			em.persist(book);
			et.commit();
			return book;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	/*
	 * 
	 * getAllbookDetails
	 * 
	 */
	public List<Books> getAllBookDetailsDao() {
		String HQL="FROM Books";
		return em.createQuery(HQL).getResultList();
	}

	/*
	 * delete method
	 */
	public boolean deleteBookByIdDao(int id) {

		Books book = em.find(Books.class, id);
		if (book != null) {
			et.begin();
			em.remove(book);
			et.commit();
			return true;
		} else {
			return false;
		}
	}
	
	/*
	 * update book
	 */
	public Books updateBookByIdDao(Books book) {
		
		Books book2=fetchBookByIdDao(book.getId());
		
		if(book2!=null) {
			book2.setName(book.getName());
			
			
			book2.setPrice(book.getPrice());
			
			if(book.getImage()!=null) {
			   book2.setImage(book.getImage());
			}
			
			et.begin();
			em.merge(book2);
			et.commit();
			return book2;
		}else {
			return null;
		}
		
	}
/**
 * 
 * 
 * @param id
 * @return book
 * fetch book by id 
 */
	public Books fetchBookByIdDao(int id) {
		
		return em.find(Books.class, id);
	}
	
	
	/**
	 * 
	 * 
	verify book by id 
	 */
	public Books verifyBookByAdminDao(Books book) {
		et.begin();
		em.merge(book);
		et.commit();
		return book;
	}
	
	
}
