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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "genres")
public class GenreEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "genre_id")
	private long genreId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@OneToMany(mappedBy = "genre", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<AlbumEntity> albums;

	public long getGenreId() {
		return genreId;
	}

	public void setGenreId(long genreId) {
		this.genreId = genreId;
	}

	public long getId() {
		return genreId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	@Override
	public int hashCode() {
		return Objects.hash(albums, description, genreId, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GenreEntity other = (GenreEntity) obj;
		return Objects.equals(albums, other.albums) && Objects.equals(description, other.description) && genreId == other.genreId
				&& Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "GenreEntity [genreId=" + genreId + ", name=" + name + ", description=" + description + ", albums="
				+ albums + "]";
	}





	
}
