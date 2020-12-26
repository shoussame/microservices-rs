package com.houssame.user.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.houssame.user.dao.UserRepo;
import com.houssame.user.entities.Utilisateur;

@RestController
public class UtilisateurRest {
	@Autowired
	private UserRepo userRepo;
	
	@GetMapping("/utilisateurs")
	  List<Utilisateur> all() {
	    return userRepo.findAll();
	  }

	  @PostMapping("/utilisateurs")
	  Utilisateur newMission(@RequestBody Utilisateur mission) {
	    return userRepo.save(mission);
	  }

	  // Single item

	  @GetMapping("/utilisateurs/{id}")
	  Utilisateur one(@PathVariable Long id) throws Exception {
		  
	    return userRepo.findById(id)
	      .orElseThrow(() -> new Exception());
	  }
	  
	  @PutMapping("/utilisateurs/{id}")
	  Utilisateur replaceMission(@RequestBody Utilisateur missionn, @PathVariable Long id) {

	    return userRepo.findById(id)
	      .map(mission -> {
	    	mission.setId(missionn.getId());
	    	mission.setLog(missionn.getLog());
	    	mission.setMdp(missionn.getMdp());
	    	mission.setNom(missionn.getNom());
	    	mission.setPhoto(missionn.getPhoto());
	        return userRepo.save(mission);
	      })
	      .orElseGet(() -> {
	        missionn.setId(id);
	        return userRepo.save(missionn);
	      });
	  }
	  @DeleteMapping("/utilisateurs/{id}")
	  void deleteEmployee(@PathVariable Long id) {
	    userRepo.deleteById(id);
	  }
}
