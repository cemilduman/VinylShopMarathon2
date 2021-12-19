package com.bilgeadam.main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.TypedQuery;

import org.hibernate.Session;

import com.bilgeadam.controller.CreatorMethods;
import com.bilgeadam.entity.AlbumEntity;
import com.bilgeadam.entity.ArtistEntity;
import com.bilgeadam.entity.DVDEntity;
import com.bilgeadam.entity.GenreEntity;
import com.bilgeadam.entity.PriceEntity;
import com.bilgeadam.entity.ProductEntity;
import com.bilgeadam.entity.UserEntity;
import com.bilgeadam.entity.VinylEntity;
import com.bilgeadam.model.E_DVDStreamQuality;
import com.bilgeadam.model.E_Vinyl_Diameter;
import com.bilgeadam.model.E_Vinyl_Speed;
import com.bilgeadam.util.HibernateUtil;

public class Main {

	public static void main(String[] args) throws IOException {
		Session session = HibernateUtil.getSessionfactory().openSession();
		byte[] thrillerCover = Files.readAllBytes(Paths.get("Thriller.jpg"));
		byte[] offTheWallCover = Files.readAllBytes(Paths.get("OffTheWall.jpg"));
		
		Set<AlbumEntity> albums = new HashSet<AlbumEntity>();
		Set<ProductEntity> products = new HashSet<ProductEntity>();
		Set<DVDEntity> dvds = new HashSet<DVDEntity>();
		Set<VinylEntity> vinyls = new HashSet<VinylEntity>();
		Set<PriceEntity> prices = new HashSet<PriceEntity>();
		
		ArtistEntity artist = CreatorMethods.artistEntityCreator("Michael", "Jackson", "Number 1 POP Singer in the world");
		
		
		GenreEntity pop = new GenreEntity();
		pop.setGenreName("POP");
		pop.setGenreDescription("Popular sounds for everyone.");
		
		AlbumEntity thriller = new AlbumEntity();
		thriller.setAlbumName("Thriller");
		thriller.setCoverPhoto(thrillerCover);
		thriller.setArtist(artist);
		thriller.setGenre(pop);
		albums.add(thriller);
		
		
		ProductEntity product1 = new ProductEntity();
		product1.setMedium("vinyl");
		product1.setOnSale(true);
		product1.setOrderQuantity(0);
		product1.setStockQuantity(20);
		product1.setAlbum(thriller);
		product1.setArtist(artist);
		product1.setGenre(pop);
		products.add(product1);
		
		
		PriceEntity price1 = new PriceEntity();
		price1.setPrice(15.63);
		price1.setDiscountRate(0);
		price1.setProduct(product1);
		prices.add(price1);
		
		
		VinylEntity vinyl1 = new VinylEntity();
		vinyl1.setDiameter(E_Vinyl_Diameter.MEDIUM.getValue());
		vinyl1.setSpeed(E_Vinyl_Speed.FAST.getValue());
		vinyl1.setProduct(product1);
		vinyls.add(vinyl1);
		
		product1.setDvd(null);
		product1.setPrice(prices);
		product1.setVinyl(vinyls);

		thriller.setProduct(products);
		artist.setAlbum(albums);
		artist.setProduct(products);
		pop.setAlbum(albums);
		pop.setProduct(products);

		
		UserEntity user1 = new UserEntity();

		
//			session.getTransaction().begin();
//			session.persist(pop);
//			session.persist(artist);
//			session.getTransaction().commit();
//		


	
		
		//Genre'ye göre sıralama
		String hql = "Select alb.albumName from AlbumEntity as alb inner join alb.genre as gen where gen.genreName=:key) ";
		TypedQuery<String> typedQuery = session.createQuery(hql, String.class);
		typedQuery.setParameter("key", "POP");
		
		ArrayList<String>  rowList = (ArrayList<String>) typedQuery.getResultList();
		for (String temp : rowList) {
			System.out.println(temp);
		}
		
//		String hql = "select gen.genreName from GenreEntity as gen";
//		TypedQuery<String> tq = session.createQuery(hql,String.class);
//		
//		ArrayList<String> list =  (ArrayList<String>) tq.getResultList();
//		
//		for (String word : list) {
//			System.out.println(word);
//		}
	}

}
