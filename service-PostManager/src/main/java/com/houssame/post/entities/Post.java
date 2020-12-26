package com.houssame.post.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity @Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Post {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String dtae;
	private String titre;
	private String contenu;
	private long iduser;

}
