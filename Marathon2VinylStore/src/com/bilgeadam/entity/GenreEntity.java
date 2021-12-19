package com.bilgeadam.entity;

import java.util.*;

import javax.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "genre")
@Getter
@Setter
public class GenreEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "genre_id")
	private long genreId;
	
	@Column(name = "genre_name")
	private String genreName;
	
	@Column(name = "genre_description")
	private String genreDescription;
	
	@OneToMany(mappedBy = "genre", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<AlbumEntity> album = new HashSet<>();
	
	@OneToMany(mappedBy = "genre", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<ProductEntity> product = new HashSet<>();
	
	@Column(name = "version")
	@Version
	private Long version;

	@Override
	public String toString() {
		return "GenreEntity ["+ "genreName=" + genreName + ", genreDescription=" + genreDescription
				+ ", album=" + album + ", product=" + product + "]";
	}
	
	
}
