package com.bilgeadam.dto;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Hibernate;
import org.hibernate.Session;

import com.bilgeadam.controller.AlbumController;
import com.bilgeadam.controller.ArtistController;
import com.bilgeadam.controller.GenreController;
import com.bilgeadam.dto.StorageMedium.Quality;
import com.bilgeadam.dto.StorageMedium.Size;
import com.bilgeadam.dto.StorageMedium.Speed;
import com.bilgeadam.entity.AlbumEntity;
import com.bilgeadam.entity.ArtistEntity;
import com.bilgeadam.entity.GenreEntity;
import com.bilgeadam.util.HibernateUtil;

public class Trial {

	public static void main(String[] args) throws IOException {
		StorageMedium medium = new StorageMedium();
		
		AlbumEntity albumEntity = new AlbumEntity();
		byte[] cover1 = Files.readAllBytes(Paths.get("1.jpg"));
		byte[] cover2 = Files.readAllBytes(Paths.get("2.jpg"));
		byte[] cover3 = Files.readAllBytes(Paths.get("3.jpg"));
		byte[] cover4 = Files.readAllBytes(Paths.get("4.jpg"));
		byte[] cover5 = Files.readAllBytes(Paths.get("5.jpg"));
		byte[] cover6 = Files.readAllBytes(Paths.get("6.jpg"));
		byte[] cover7 = Files.readAllBytes(Paths.get("7.jpg"));
		byte[] cover8 = Files.readAllBytes(Paths.get("8.jpg"));
		byte[] cover9 = Files.readAllBytes(Paths.get("9.jpg"));
		byte[] cover10 = Files.readAllBytes(Paths.get("10.jpg"));
		
//		albumEntity.setStorageType(medium.getDVD(Quality.UHD));
//		albumEntity.setName("biseyler");
//		albumEntity.setDiscountRate(0.05);
//		albumEntity.setPrice(5);
//		albumEntity.setCoverPhoto(cover1);
		
		albumEntity.setId(6);
		albumEntity.setStorageType(medium.getVinyl(Speed.FAST, Size.SMALL));
		albumEntity.setCoverPhoto(cover6);
		
		
//		ArtistEntity artistEntity = new ArtistEntity();
//		artistEntity.setName("James");
//		artistEntity.setSurname("Hetfield");
//		artistEntity.setDescription("Good singer");
//		artistEntity.setAlbums(List.of(albumEntity));
//		albumEntity.setArtist(artistEntity);
//		
//		GenreEntity genreEntity = new GenreEntity();
//		genreEntity.setName("Thrash Metal");
//		genreEntity.setDescription("Heavy and unique");
//		genreEntity.setAlbums(List.of(albumEntity));
//		albumEntity.setGenre(genreEntity);
		
		
		Session session = HibernateUtil.getSessionfactory().openSession();
//		ArtistController aCon = new ArtistController();
//		aCon.create(artistEntity);
//		
//		GenreController gCon = new GenreController();
//		gCon.create(genreEntity);
		
		AlbumController controller = new AlbumController();
		
		controller.update(albumEntity);
//		controller.listOfLatestTenAlbums();
	
//		session.getTransaction().begin();
//		session.persist(genreEntity);
//		session.getTransaction().commit();
//		System.out.println("Creation succeded");
//		
//		session.getTransaction().begin();
//		session.persist(artistEntity);
//		session.getTransaction().commit();
//		System.out.println("Creation succeded");
		
		String hql = "Select at from AlbumEntity as at where at.id = 1L"; 
		
		
		TypedQuery<AlbumEntity> query = session.createQuery(hql, AlbumEntity.class);
		
		ArrayList<AlbumEntity> list = (ArrayList<AlbumEntity>) query.getResultList();
		
		for (AlbumEntity albumEntity2 : list) {
		System.out.println(albumEntity2);
		}
		
	}

}
