package com.bilgeadam.entity;

import java.util.*;

import javax.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "vinyl")
@Getter
@Setter
public class VinylEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "vinyl_id")
	private long vinylId;
	
	@Column(name = "version")
	@Version
	private Long version;
	
	@Column(name = "vinyl_speed_rpm")
	private String speed;
	
	@Column(name = "vinyl_disc_diameter")
	private String diameter;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "product_id")
	private ProductEntity product;
}
