package com.bilgeadam.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.TypedQuery;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;


import com.bilgeadam.entity.ArtistEntity;
import com.bilgeadam.util.IDatabaseCrud;
import com.bilgeadam.util.HibernateUtil;

public class ArtistController implements IDatabaseCrud<ArtistEntity>{

	private static Logger logger = LogManager.getLogger(ArtistController.class);
	private static final Session session = HibernateUtil.getSessionfactory().openSession();
	

	@Override
	public void create(ArtistEntity entity) {
		try {
			
			session.getTransaction().begin();
			session.persist(entity);
			session.getTransaction().commit();
			
			logger.info("Ekleme tamamdır." + ArtistController.class);
		} catch (Exception e) {
			logger.error("Something wrong happened" + ArtistController.class );
			e.printStackTrace();
		}
	}

	@Override
	public void update(ArtistEntity entity) {
		try {
			ArtistEntity artistEntity = find(entity.getId());
			if(artistEntity != null) {
				
				if(entity.getName()!=null) {
					artistEntity.setName(entity.getName());
				}

				if(entity.getSurname() != null) {
					artistEntity.setSurname(entity.getSurname());
				}
				if(entity.getAlbums() != null) {
					artistEntity.setAlbums(entity.getAlbums());
				}
				
				session.getTransaction().begin();
				session.merge(artistEntity);
				session.getTransaction().commit();
				logger.info("Update: Updated " + ArtistController.class);
			}
		} catch (Exception e) {
			logger.error("Something wrong happened" + ArtistController.class );
			e.printStackTrace();
		}
		
	}


	
	
	@Override
	public void delete(ArtistEntity entity) {
		// TODO Auto-generated method stub
		
	}

	public void delete(long id) {
		try {
			ArtistEntity artistEntity = find(id);
			if(artistEntity != null) {
				session.getTransaction().begin();
				session.remove(artistEntity);
				session.getTransaction().commit();
				logger.info("Deleted succesfully" + ArtistController.class);
			}
		} catch (Exception e) {
			logger.error("Something wrong happened" + ArtistController.class );
			e.printStackTrace();
		}
		
	}

	@Override
	public ArrayList<ArtistEntity> list() {
		
		String hql = "Select str from StudentEntity as str where str.id >=:key"; 
		
		
		TypedQuery<ArtistEntity> query = session.createQuery(hql, ArtistEntity.class);
		query.setParameter("key", 1L);
		
		ArrayList<ArtistEntity> list = (ArrayList<ArtistEntity>) query.getResultList();
		logger.info("Listing operation is succeeded." + ArtistController.class);
		return list;
	}
	
	@Override
	public ArtistEntity singleResult(long id) {
		// TODO Auto-generated method stub
		return IDatabaseCrud.super.singleResult(id);
	}

	@Override
	public ArtistEntity find(long id) {
		ArtistEntity studentEntity;
		try {
			studentEntity = session.find(ArtistEntity.class, id);
			if(studentEntity != null) {
				logger.info(studentEntity + " is found" + ArtistController.class);
				return studentEntity;
			}else {
				logger.warn("Not found" + ArtistController.class);
				return null;
			}
		} catch (Exception e) {
			logger.error("Something wrong happened" + ArtistController.class );
			e.printStackTrace();
		}
		return null;
	}
	
}
