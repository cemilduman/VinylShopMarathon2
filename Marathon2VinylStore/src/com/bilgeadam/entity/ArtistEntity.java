package com.bilgeadam.entity;

import java.util.*;

import javax.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "artist")
@Getter
@Setter
public class ArtistEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "artist_id")
	private long artistId;
	
	@Column(name = "version")
	@Version
	private Long version;
	
	@Column(name = "artist_name")
	private String artistName;
	
	@Column(name = "artist_surname")
	private String artistSurname;
	
	@Column(name = "artist_description")
	private String artistDescription;
	
	@OneToMany(mappedBy = "artist", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<AlbumEntity> album = new HashSet<>();
	
	@OneToMany(mappedBy = "artist", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<ProductEntity> product;
	
}
