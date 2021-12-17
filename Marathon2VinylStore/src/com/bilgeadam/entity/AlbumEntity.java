package com.bilgeadam.entity;

import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.bilgeadam.dto.StorageMedium;

@Entity
@Table(name = "albums")
public class AlbumEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "price")
	private double price;
	
	@Lob
	private byte[] coverPhoto;
	
	@Column(name = "discount_rate")
	private double discountRate;
	
	@Column(name = "storage_medium")
	private String storageType;
	
	@ManyToOne
	@JoinColumn(name = "artist_id")
	private ArtistEntity artist;
	
	@ManyToOne
	@JoinColumn(name = "genre_id")
	private GenreEntity genre;



	
	public AlbumEntity() {
		
	}

	
	public void setId(long id) {
		this.id = id;
	}
	
	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {

		return price;
	}

	public void setPrice(double price) {
		if(this.discountRate != 0) {
			this.price = price - (price * this.discountRate);
		}else {
			this.price = price;
		}
	}

	public byte[] getCoverPhoto() {
		return coverPhoto;
	}

	public void setCoverPhoto(byte[] coverPhoto) {
		this.coverPhoto = coverPhoto;
	}

	public double getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(double discountRate) {
		this.discountRate = discountRate;
	}

	public String getStorageType() {
		return storageType;
	}

	public void setStorageType(String storageType) {
		this.storageType = storageType;
	}

	public ArtistEntity getArtist() {
		return artist;
	}

	public void setArtist(ArtistEntity artist) {
		this.artist = artist;
	}

	public GenreEntity getGenre() {
		return genre;
	}

	public void setGenre(GenreEntity genre) {
		this.genre = genre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(coverPhoto);
		result = prime * result + Objects.hash(artist, discountRate, genre, id, name, price, storageType);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AlbumEntity other = (AlbumEntity) obj;
		return Objects.equals(artist, other.artist) && Arrays.equals(coverPhoto, other.coverPhoto)
				&& Double.doubleToLongBits(discountRate) == Double.doubleToLongBits(other.discountRate)
				&& Objects.equals(genre, other.genre) && id == other.id && Objects.equals(name, other.name)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& Objects.equals(storageType, other.storageType);
	}

	@Override
	public String toString() {
		return "AlbumEntity [id=" + id + ", name=" + name + ", price=" + price + ", coverPhoto="
				+ Arrays.toString(coverPhoto) + ", discountRate=" + discountRate + ", storageType=" + storageType
				+ ", artist=" + artist.getName() + " " +artist.getSurname() + ", genre=" + genre.getName() + "]";
	}



	

}
