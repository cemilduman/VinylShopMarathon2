package com.bilgeadam.entity;

import java.util.*;

import javax.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user")
@Getter
@Setter
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private long userId;
	
	@Column(name = "version")
	@Version
	private Long version;
	
	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "user_surname")
	private String userSurname;
	
	@Column(name = "user_password")
	private String userPassword;
	
	@Column(name = "user_email")
	private String userEmail;
	
	@Column(name = "user_adress")
	private String userAdress;
	
	@Column(name = "user_phone")
	private String userPhone;

	
}
