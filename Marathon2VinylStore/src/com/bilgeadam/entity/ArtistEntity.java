package com.bilgeadam.entity;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "artists")
public class ArtistEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "artist_id")
	private long artistId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "surname")
	private String surname;
	
	@Column(name = "description")
	private String description;
	
	@OneToMany(mappedBy = "artist", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<AlbumEntity> albums;

	public long getId() {
		return artistId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<AlbumEntity> getAlbums() {
		return albums;
	}

	public void setAlbums(List<AlbumEntity> albums) {
		this.albums = albums;
	}

	
	public long getArtistId() {
		return artistId;
	}

	public void setArtistId(long artistId) {
		this.artistId = artistId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(albums, description, artistId, name, surname);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ArtistEntity other = (ArtistEntity) obj;
		return Objects.equals(albums, other.albums) && Objects.equals(description, other.description) && artistId == other.artistId
				&& Objects.equals(name, other.name) && Objects.equals(surname, other.surname);
	}

	@Override
	public String toString() {
		return "ArtistEntity [artistId=" + artistId + ", name=" + name + ", surname=" + surname + ", description="
				+ description + ", albums=" + albums + "]";
	}




	
}
