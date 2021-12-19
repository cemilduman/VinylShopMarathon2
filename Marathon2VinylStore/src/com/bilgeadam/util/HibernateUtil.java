package com.bilgeadam.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bilgeadam.entity.AlbumEntity;
import com.bilgeadam.entity.ArtistEntity;
import com.bilgeadam.entity.GenreEntity;




public class HibernateUtil {

	public static SessionFactory getSessionfactory() {
		return sessionFactory;
	}
	
	private static final SessionFactory sessionFactory = sessionFactoryHibernate();
	
	private static SessionFactory sessionFactoryHibernate() {
		try {
			
			Configuration configuration = new Configuration();
			configuration.addAnnotatedClass(AlbumEntity.class);
			configuration.addAnnotatedClass(GenreEntity.class);
			configuration.addAnnotatedClass(ArtistEntity.class);
			
			SessionFactory factory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();
			return factory;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
