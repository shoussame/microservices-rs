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

import com.houssame.user.dao.AmisRepo;
import com.houssame.user.entities.Amis;

@RestController
public class AmisRest {
	@Autowired
	private AmisRepo amisRepo;
	@GetMapping("/amis")
	  List<Amis> all() {
	    return amisRepo.findAll();
	  }

	  @PostMapping("/amis")
	  Amis newMission(@RequestBody Amis mission) {
	    return amisRepo.save(mission);
	  }

	  // Single item

	  @GetMapping("/amis/{id}")
	  Amis one(@PathVariable Long id) throws Exception {
		  
	    return amisRepo.findById(id)
	      .orElseThrow(() -> new Exception());
	  }
	  
	  @PutMapping("/amis/{id}")
	  Amis replaceMission(@RequestBody Amis missionn, @PathVariable Long id) {

	    return amisRepo.findById(id)
	      .map(mission -> {
	    	mission.setId(missionn.getId());
	    	mission.setIdp1(missionn.getIdp1());
	    	mission.setIdp2(missionn.getIdp2());
	    	mission.setEtat(missionn.getEtat());
	    	mission.setDate(missionn.getDate());
	        return amisRepo.save(mission);
	      })
	      .orElseGet(() -> {
	        missionn.setId(id);
	        return amisRepo.save(missionn);
	      });
	  }
	  @DeleteMapping("/amis/{id}")
	  void deleteEmployee(@PathVariable Long id) {
	    amisRepo.deleteById(id);
	  }

}
