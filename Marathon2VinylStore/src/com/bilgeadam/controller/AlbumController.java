package com.bilgeadam.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.TypedQuery;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;


import com.bilgeadam.entity.AlbumEntity;
import com.bilgeadam.util.IDatabaseCrud;
import com.bilgeadam.util.HibernateUtil;

public class AlbumController implements IDatabaseCrud<AlbumEntity>{

	private static Logger logger = LogManager.getLogger(AlbumController.class);
	private static final Session session = HibernateUtil.getSessionfactory().openSession();
	

	@Override
	public void create(AlbumEntity entity) {
		try {
			
			session.getTransaction().begin();
			session.persist(entity);
			session.getTransaction().commit();
			
			logger.info("Ekleme tamamdır." + AlbumController.class);
		} catch (Exception e) {
			logger.error("Something wrong happened" + AlbumController.class );
			e.printStackTrace();
		}
	}

	@Override
	public void update(AlbumEntity entity) {
		try {
			AlbumEntity albumEntity = find(entity.getId());
			if(albumEntity != null) {
				
				if(entity.getName()!=null) {
					albumEntity.setName(entity.getName());
				}
				if(entity.getPrice() != 0) {
					albumEntity.setPrice(entity.getPrice());
				}
				if(entity.getCoverPhoto() != null) {
					albumEntity.setCoverPhoto(entity.getCoverPhoto());
				}
				if(entity.getDiscountRate() != 0) {
					albumEntity.setDiscountRate(entity.getDiscountRate());
				}
				if(entity.getStorageType() != null) {
					albumEntity.setStorageType(entity.getStorageType());
				}
				if(entity.getArtist() != null) {
					albumEntity.setArtist(entity.getArtist());
				}
				if(entity.getGenre() != null) {
					albumEntity.setGenre(entity.getGenre());
				}
				
				session.getTransaction().begin();
				session.merge(albumEntity);
				session.getTransaction().commit();
				logger.info("Update: Updated " + AlbumController.class);
			}
		} catch (Exception e) {
			logger.error("Something wrong happened" + AlbumController.class );
			e.printStackTrace();
		}
		
	}

	public void listOfLatestTenAlbums(){
		String hql = "Select alb from AlbumEntity as alb order by alb.id desc";
		TypedQuery<AlbumEntity> typedQuery = session.createQuery(hql, AlbumEntity.class);
		typedQuery.setMaxResults(10);
		
		ArrayList<AlbumEntity>  rowList = (ArrayList<AlbumEntity>) typedQuery.getResultList();
		for (AlbumEntity temp : rowList) {
			System.out.println(temp);
		}
	}
	
	public void discountedAlbums() {
		String hql = "Select alb from AlbumEntity as alb where alb.discountRate != 0 order by alb.id";
		TypedQuery<AlbumEntity> typedQuery = session.createQuery(hql, AlbumEntity.class);
		typedQuery.setMaxResults(15);
		
		ArrayList<AlbumEntity>  rowList = (ArrayList<AlbumEntity>) typedQuery.getResultList();
		for (AlbumEntity temp : rowList) {
			System.out.println(temp);
		}
	}
	
	public void albumsByGenre(String genre) {
		String hql = "Select alb from AlbumEntity as alb where alb.genre = (select gen.genreId from GenreEntity as gen where gen.name=:key) ";
		TypedQuery<AlbumEntity> typedQuery = session.createQuery(hql, AlbumEntity.class);
		typedQuery.setParameter("key", genre);
		
		ArrayList<AlbumEntity>  rowList = (ArrayList<AlbumEntity>) typedQuery.getResultList();
		for (AlbumEntity temp : rowList) {
			System.out.println(temp);
		}
	}
	
	public void albumsByArtist(String artist) {
		String hql = "Select alb from AlbumEntity as alb alb where alb.artist = (select art.artistId from ArtistEntity as art where art.name=:key)  ";
		TypedQuery<AlbumEntity> typedQuery = session.createQuery(hql, AlbumEntity.class);
		typedQuery.setParameter("key", artist);
		
		ArrayList<AlbumEntity>  rowList = (ArrayList<AlbumEntity>) typedQuery.getResultList();
		for (AlbumEntity temp : rowList) {
			System.out.println(temp);
		}
	}
	
	public void mostFrequentlyOrdered() {

	}
	
	@Override
	public void delete(AlbumEntity entity) {
		// TODO Auto-generated method stub
		
	}

	public void delete(long id) {
		try {
			AlbumEntity albumEntity = find(id);
			if(albumEntity != null) {
				session.getTransaction().begin();
				session.remove(albumEntity);
				session.getTransaction().commit();
				logger.info("Deleted succesfully" + AlbumController.class);
			}
		} catch (Exception e) {
			logger.error("Something wrong happened" + AlbumController.class );
			e.printStackTrace();
		}
		
	}

	@Override
	public ArrayList<AlbumEntity> list() {
		
		String hql = "Select alb from AlbumEntity as alb where alb.id >=:key"; 
		
		
		TypedQuery<AlbumEntity> query = session.createQuery(hql, AlbumEntity.class);
		query.setParameter("key", 1L);
		
		ArrayList<AlbumEntity> list = (ArrayList<AlbumEntity>) query.getResultList();
		logger.info("Listing operation is succeeded." + AlbumController.class);
		return list;
	}

	@Override
	public AlbumEntity singleResult(long id) {
		// TODO Auto-generated method stub
		return IDatabaseCrud.super.singleResult(id);
	}

	@Override
	public AlbumEntity find(long id) {
		AlbumEntity studentEntity;
		try {
			studentEntity = session.find(AlbumEntity.class, id);
			if(studentEntity != null) {
				logger.info(studentEntity + " is found" + AlbumController.class);
				return studentEntity;
			}else {
				logger.warn("Not found" + AlbumController.class);
				return null;
			}
		} catch (Exception e) {
			logger.error("Something wrong happened" + AlbumController.class );
			e.printStackTrace();
		}
		return null;
	}
	
}
