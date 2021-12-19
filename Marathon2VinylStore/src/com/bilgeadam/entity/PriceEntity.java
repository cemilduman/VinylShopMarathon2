package com.bilgeadam.entity;

import java.util.*;

import javax.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "price")
@Getter
@Setter
public class PriceEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "price_id")
	private long priceId;
	
	@Column(name = "version")
	@Version
	private Long version;
	
	@Column(name = "price")
	private double price;
	
	@Column(name = "discount_rate")
	private double discountRate;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "product_id")
	private ProductEntity product;
}
