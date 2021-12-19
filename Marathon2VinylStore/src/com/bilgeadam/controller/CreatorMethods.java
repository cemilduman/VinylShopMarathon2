package com.bilgeadam.controller;

import java.util.HashSet;
import java.util.Set;

import com.bilgeadam.entity.AlbumEntity;
import com.bilgeadam.entity.ArtistEntity;
import com.bilgeadam.entity.DVDEntity;
import com.bilgeadam.entity.GenreEntity;
import com.bilgeadam.entity.PriceEntity;
import com.bilgeadam.entity.ProductEntity;
import com.bilgeadam.entity.UserEntity;
import com.bilgeadam.entity.VinylEntity;

public class CreatorMethods {

	public static ArtistEntity artistEntityCreator(String name, String surname, String description){
		ArtistEntity artist = new ArtistEntity();
		artist.setArtistName(name);
		artist.setArtistSurname(surname);
		artist.setArtistDescription(description);
		return artist;
	}
	
	public static GenreEntity genreEntityCreator(String name, String description) {
		GenreEntity genre = new GenreEntity();
		genre.setGenreName(name);
		genre.setGenreDescription(description);
		return genre;
	}
	
	public static AlbumEntity albumEntityCreator(String name, byte[] coverPhoto) {
		AlbumEntity album = new AlbumEntity();
		album.setAlbumName(name);
		album.setCoverPhoto(coverPhoto);
		return album;
	}
	
	public static ProductEntity productEntityCreator(String medium, boolean isOnSale, int orderQUantity, int stockQuantity) {
		ProductEntity product = new ProductEntity();
		product.setMedium(medium);
		product.setOnSale(isOnSale);
		product.setOrderQuantity(orderQUantity);
		product.setStockQuantity(stockQuantity);
		return product;
	}
	
	
	public static PriceEntity priceEntityCreator(double priceAmount, double discountRate) {
		PriceEntity price = new PriceEntity();
		price.setPrice(priceAmount);
		price.setDiscountRate(discountRate);
		return price;
	}
	
	public static DVDEntity dvdEntityCreator(String quality) {
		DVDEntity dvd = new DVDEntity();
		dvd.setQuality(quality);
		return dvd;
	}
	
	//Hepsini buna göre düzenle
	public static VinylEntity vinylEntityCreator(String speed, String diameter, ProductEntity product) {
		VinylEntity vinyl = new VinylEntity();
		vinyl.setSpeed(speed);
		vinyl.setDiameter(diameter);
		vinyl.setProduct(product);
		return vinyl;
	}
	
	public static UserEntity userEntityCreator(String userName, String userSurname, String userPassword, String userEmail) {
		UserEntity user = new UserEntity();
		user.setUserName(userName);
		user.setUserSurname(userSurname);
		user.setUserPassword(userPassword);
		user.setUserEmail(userEmail);
		return user;
	}
	
	public static Set<AlbumEntity> addAlbumSet(AlbumEntity album){
		Set<AlbumEntity> albums = new HashSet<AlbumEntity>();
		albums.add(album);
		return albums;
	}
	
	public static Set<ProductEntity> addProductSet(ProductEntity product){
		Set<ProductEntity> products = new HashSet<ProductEntity>();
		products.add(product);
		return products;
	}
	public static Set<DVDEntity> addDVDSet(DVDEntity dvd){
		Set<DVDEntity> dvds = new HashSet<DVDEntity>();
		dvds.add(dvd);
		return dvds;
	}
	public static Set<VinylEntity> addVinylsSet(VinylEntity vinyl){
		Set<VinylEntity> vinyls = new HashSet<VinylEntity>();
		vinyls.add(vinyl);
		return vinyls;
	}
	public static Set<PriceEntity> addPricesSet(PriceEntity price){
		Set<PriceEntity> prices = new HashSet<PriceEntity>();
		prices.add(price);
		return prices;
	}
}
