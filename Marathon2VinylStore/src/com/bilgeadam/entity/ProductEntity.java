package com.bilgeadam.entity;

import java.util.*;

import javax.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "products")
@Getter
@Setter
public class ProductEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private long id;
	
	@Column(name = "version")
	@Version
	private Long version;
	
	@Column(name = "order_quantity")
	private int orderQuantity;
	
	@Column(name = "stock_quantity")
	private int stockQuantity;
	
	@Column(name = "is_on_Sale")
	private boolean isOnSale;
	
	@Column(name = "medium")
	private String medium;
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<VinylEntity> vinyl = new HashSet<>();
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<DVDEntity> dvd = new HashSet<>();
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<PriceEntity> price = new HashSet<>();
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "album_id")
	private AlbumEntity album;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "artist_id")
	private ArtistEntity artist;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "genre_id")
	private GenreEntity genre;

}
