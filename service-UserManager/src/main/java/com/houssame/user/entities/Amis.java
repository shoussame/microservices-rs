package com.houssame.user.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity @Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Amis {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private long idp1;
	private long idp2;
	private String etat;
	private String date;
}
