package com.houssame.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.houssame.user.entities.Amis;

@Repository
public interface AmisRepo extends JpaRepository<Amis, Long>{

}
