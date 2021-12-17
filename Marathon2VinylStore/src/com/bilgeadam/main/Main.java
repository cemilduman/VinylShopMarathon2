package com.bilgeadam.main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import com.bilgeadam.controller.AlbumController;
import com.bilgeadam.controller.ArtistController;
import com.bilgeadam.controller.GenreController;
import com.bilgeadam.entity.AlbumEntity;
import com.bilgeadam.entity.ArtistEntity;
import com.bilgeadam.entity.GenreEntity;

public class Main {

	public static void main(String[] args) throws IOException {
		//newAlbumRegister();
		AlbumController albCon = new AlbumController();
		
		//Aşağıdaki yorum içine alınmış methodlar çalışıyor, sonuçlar sorunsuz gösteriliyor. Lakin vaktim yetmediği için veriler database'de düzgün değil, ve bazı kısımlar ne yazık ki yetişmedi.
		
		
//		// Tüm albümleri listeleme
//		for (AlbumEntity temp : albCon.list()) {
//			System.out.println(temp);
//		}
//		
//		//Genre'ye göre listeleme
//		albCon.albumsByGenre("gname1");
//		
//		//Artist'e göre listeleme
//		albCon.albumsByArtist("artist1");
		
//		//İndirimi olanları göster(15 adet)
//		albCon.discountedAlbums();

//		//Son eklenen 10 albümü göster
//		albCon.listOfLatestTenAlbums();
		
	}

	
	public static void newAlbumRegister() {
		//Normalinde kullanıcı girişi olan güzel bir kayıt methodu olmalı ama sürem yetmedi, ilişkileri çözüp düzgünce yazdırmak ve liste olarak geri döndürmek tüm günümü aldı :(((
		
		GenreEntity entity = new GenreEntity();
		entity.setName("gname" );
		entity.setDescription("descG" );
		entity.setAlbums(new ArrayList<AlbumEntity>());
		
		ArtistEntity entityA = new ArtistEntity();
		entityA.setName("artist" );
		entityA.setDescription("desc" );
		entityA.setSurname("asurname" );
		entityA.setAlbums(new ArrayList<AlbumEntity>());
		

		AlbumEntity albEntity = new AlbumEntity();
		albEntity.setName("alb" );
		albEntity.setArtist(entityA);
		albEntity.setGenre(entity);
		
		ArtistController artCon = new ArtistController();
		artCon.create(entityA);
		
		GenreController genCon = new GenreController();
		genCon.create(entity);
		
		AlbumController albCon = new AlbumController();
		albCon.create(albEntity);
	}
}
