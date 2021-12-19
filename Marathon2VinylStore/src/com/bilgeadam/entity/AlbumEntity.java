package com.bilgeadam.entity;

import java.util.*;

import javax.persistence.*;

import lombok.*;

//tostringlerini çöz

@Entity
@Table(name = "album")
@Getter
@Setter
public class AlbumEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "album_id")
	private long albumId;
	
	@Column(name = "album_name")
	private String albumName;
	
	@Lob
	private byte[] coverPhoto;
	
	@OneToMany(mappedBy = "album", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<ProductEntity> product = new HashSet<>();
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "genre_id")
	private GenreEntity genre;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "artist_id")
	private ArtistEntity artist;
	
	@Column(name = "version")
	@Version
	private Long version;

	@Override
	public String toString() {
		return "AlbumEntity [albumId=" + albumId + ", albumName=" + albumName + ", coverPhoto="
				+ Arrays.toString(coverPhoto) + ", product=" + product + ", genre=" + ", artist=" + artist
				+ "]";
	}
	
	
}
