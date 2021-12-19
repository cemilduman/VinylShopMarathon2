package com.bilgeadam.entity;

import java.util.*;

import javax.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "dvd")
@Getter
@Setter
public class DVDEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dvd_id")
	private long dvdId;
	
	@Column(name = "version")
	@Version
	private Long version;
	
	@Column(name = "stream_quality")
	private String quality;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "product_id")
	private ProductEntity product;
}
