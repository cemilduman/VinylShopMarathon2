package com.bilgeadam.dto;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.hibernate.action.internal.EntityAction;

import com.bilgeadam.controller.AlbumController;
import com.bilgeadam.controller.ArtistController;
import com.bilgeadam.controller.GenreController;
import com.bilgeadam.dto.StorageMedium.Quality;
import com.bilgeadam.entity.AlbumEntity;
import com.bilgeadam.entity.ArtistEntity;
import com.bilgeadam.entity.GenreEntity;

public class AnotherTrial {

	public static void main(String[] args) throws IOException {
		StorageMedium medium = new StorageMedium();
		byte[] cover1 = Files.readAllBytes(Paths.get("1.jpg"));

		for(int i = 1; i < 18; i++) {
			GenreEntity entity = new GenreEntity();
			entity.setName("gname" + i);
			entity.setDescription("descG" + i);
			//entity.setAlbums(new ArrayList<AlbumEntity>());
			
			ArtistEntity entityA = new ArtistEntity();
			entityA.setName("artist" + i);
			entityA.setDescription("desc" + i);
			entityA.setSurname("asurname" + i);
			//entityA.setAlbums(new ArrayList<AlbumEntity>());
			

			AlbumEntity albEntity = new AlbumEntity();
			albEntity.setName("alb" + i);
			albEntity.setDiscountRate(i*0.01);
			albEntity.setPrice(5+i);
			albEntity.setStorageType(medium.getDVD(Quality.UHD));
			albEntity.setCoverPhoto(cover1);
			albEntity.setArtist(entityA);
			albEntity.setGenre(entity);
			

			ArtistController artCon = new ArtistController();
			artCon.create(entityA);
			
			GenreController genCon = new GenreController();
			genCon.create(entity);
			
			AlbumController albCon = new AlbumController();
			albCon.create(albEntity);
			
		}

//		AlbumController albCon = new AlbumController();
//		
//		for (AlbumEntity entity : albCon.list()) {
//			System.out.println(entity);
//		}

	}

}
