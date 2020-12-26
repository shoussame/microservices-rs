package com.houssame.user.entities;

import java.io.File;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity @Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Utilisateur {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String log;
	private String mdp;
	private String nom;
	private File photo;
}
