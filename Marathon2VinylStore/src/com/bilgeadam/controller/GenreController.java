package com.bilgeadam.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.TypedQuery;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;


import com.bilgeadam.entity.GenreEntity; 
import com.bilgeadam.util.IDatabaseCrud;
import com.bilgeadam.util.HibernateUtil;

public class GenreController implements IDatabaseCrud<GenreEntity>{

	private static Logger logger = LogManager.getLogger(GenreController.class);
	private static final Session session = HibernateUtil.getSessionfactory().openSession();
	

	@Override
	public void create(GenreEntity entity) {
		try {
			
			session.getTransaction().begin();
			session.persist(entity);
			session.getTransaction().commit();
			
			logger.info("Ekleme tamamdır." + GenreController.class);
		} catch (Exception e) {
			logger.error("Something wrong happened" + GenreController.class );
			e.printStackTrace();
		}
	}

	@Override
	public void update(GenreEntity entity) {
		try {
			GenreEntity genreEntity = find(entity.getId());
			if(genreEntity != null) {
				
				if(entity.getName()!=null) {
					genreEntity.setName(entity.getName());
				}
				
				if(genreEntity.getDescription() != null) {
					genreEntity.setDescription(entity.getDescription());
				}
				if(genreEntity.getAlbums() != null) {
					genreEntity.setAlbums(entity.getAlbums());
				}
				
				session.getTransaction().begin();
				session.merge(genreEntity);
				session.getTransaction().commit();
				logger.info("Update: Updated " + GenreController.class);
			}
		} catch (Exception e) {
			logger.error("Something wrong happened" + GenreController.class );
			e.printStackTrace();
		}
		
	}


	
	
	@Override
	public void delete(GenreEntity entity) {
		// TODO Auto-generated method stub
		
	}

	public void delete(long id) {
		try {
			GenreEntity genreEntity = find(id);
			if(genreEntity != null) {
				session.getTransaction().begin();
				session.remove(genreEntity);
				session.getTransaction().commit();
				logger.info("Deleted succesfully" + GenreController.class);
			}
		} catch (Exception e) {
			logger.error("Something wrong happened" + GenreController.class );
			e.printStackTrace();
		}
		
	}

	@Override
	public ArrayList<GenreEntity> list() {
		
		String hql = "Select str from StudentEntity as str where str.id >=:key"; 
		
		
		TypedQuery<GenreEntity> query = session.createQuery(hql, GenreEntity.class);
		query.setParameter("key", 1L);
		
		ArrayList<GenreEntity> list = (ArrayList<GenreEntity>) query.getResultList();
		logger.info("Listing operation is succeeded." + GenreController.class);
		return list;
	}

	@Override
	public GenreEntity singleResult(long id) {
		// TODO Auto-generated method stub
		return IDatabaseCrud.super.singleResult(id);
	}

	@Override
	public GenreEntity find(long id) {
		GenreEntity studentEntity;
		try {
			studentEntity = session.find(GenreEntity.class, id);
			if(studentEntity != null) {
				logger.info(studentEntity + " is found" + GenreController.class);
				return studentEntity;
			}else {
				logger.warn("Not found" + GenreController.class);
				return null;
			}
		} catch (Exception e) {
			logger.error("Something wrong happened" + GenreController.class );
			e.printStackTrace();
		}
		return null;
	}
	
}
