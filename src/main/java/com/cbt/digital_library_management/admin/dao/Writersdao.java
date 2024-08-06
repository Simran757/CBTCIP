package com.cbt.digital_library_management.admin.dao;

import java.util.List;

import com.cbt.digital_library_management.dto.Writers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

public class Writersdao {
	@PersistenceContext
	EntityManager em =Persistence.createEntityManagerFactory("library-project").createEntityManager();
	EntityTransaction et=em.getTransaction();
	public Writers saveWriterDao(Writers writers) {
		try {
			et.begin();
			em.persist(writers);
			et.commit();
			return writers;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	public Writers fetchWriterByEmailDao(String email) {
		Query query=em.createQuery("SELECT a FROM Writers a where a.email=?1");
		query.setParameter(1, email);
		
		try {
			System.out.println("writer caught");
			return (Writers)query.getSingleResult();
		} catch (Exception e) {
			System.out.println("didn't");
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	public List<Writers> getAllWritersDao(){
		String hql="From Writers";
		return em.createQuery(hql).getResultList();
		
	}
	public int updateStatusToYesDao(String email) {
		Query query=em.createNativeQuery("update writers set verify =?1 where email=?2");
		query.setParameter(1, "yes");
		query.setParameter(2, email);
		et.begin();
		
		int a= query.executeUpdate();
		et.commit();
		return a;
	}
	
	public int updateStatusToNoDao(String email) {
		Query query=em.createNativeQuery("update writers set verify =?1 where email=?2");
		query.setParameter(1, "no");
		query.setParameter(2, email);
		et.begin();
		
		int a= query.executeUpdate();
		et.commit();
		return a;
	}
}
