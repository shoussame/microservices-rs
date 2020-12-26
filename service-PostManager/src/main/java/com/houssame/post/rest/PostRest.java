package com.houssame.post.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.houssame.post.entities.Post;
import com.houssame.post.repo.PostRepo;

@RestController
public class PostRest {
	@Autowired
	private PostRepo postRepo;
	@GetMapping("/posts")
	  List<Post> all() {
	    return postRepo.findAll();
	  }

	  @PostMapping("/posts")
	  Post newMission(@RequestBody Post mission) {
	    return postRepo.save(mission);
	  }

	  // Single item

	  @GetMapping("/posts/{id}")
	  Post one(@PathVariable Long id) throws Exception {
		  
	    return postRepo.findById(id)
	      .orElseThrow(() -> new Exception());
	  }
	  
	  @PutMapping("/posts/{id}")
	  Post replaceMission(@RequestBody Post missionn, @PathVariable Long id) {

	    return postRepo.findById(id)
	      .map(mission -> {
	    	mission.setId(missionn.getId());
	    	mission.setDtae(missionn.getDtae());
	    	mission.setTitre(missionn.getTitre());
	    	mission.setContenu(missionn.getContenu());
	    	mission.setIduser(missionn.getIduser());
	        return postRepo.save(mission);
	      })
	      .orElseGet(() -> {
	        missionn.setId(id);
	        return postRepo.save(missionn);
	      });
	  }
	  @DeleteMapping("/posts/{id}")
	  void deleteEmployee(@PathVariable Long id) {
	    postRepo.deleteById(id);
	  }
	

}
