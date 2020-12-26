package com.houssame.post.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.houssame.post.entities.Post;

@Repository
public interface PostRepo extends JpaRepository<Post, Long>{

}
