package com.houssame.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.houssame.user.entities.Utilisateur;

@Repository
public interface UserRepo extends JpaRepository<Utilisateur, Long>{

}
