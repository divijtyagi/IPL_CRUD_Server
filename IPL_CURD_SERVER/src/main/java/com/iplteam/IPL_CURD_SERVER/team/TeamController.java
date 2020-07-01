package com.iplteam.IPL_CURD_SERVER.team;

import java.net.URI;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.iplteam.IPL_CURD_SERVER.player.Player;


//{
//    "id": 13,
//    "team": "RCB",
//    "description": "Royal challengers",
//    "owner": "ME",
//    "totalPlayed": 10,
//    "totalWon": 5,
//    "totalLost": 4,
//    "noResult": 1,
//    "players": []
//}
@RestController
@RequestMapping("/teams")
public class TeamController {
	
	@Autowired
	private TeamRepository teamRepository;

	@GetMapping()
	public List<Team> getTeams() {
		return teamRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Team> getTeamById(@PathVariable int id) throws TeamNotFoundException{
		if(!teamRepository.findById(id).isPresent()) throw new TeamNotFoundException(id);
		return teamRepository.findById(id);
	}
	
	@GetMapping("/{id}/players")
	public List<Player> getTeamplayersByTeamId(@PathVariable int id) throws TeamNotFoundException{
		if(!teamRepository.findById(id).isPresent()) throw new TeamNotFoundException(id);
		return teamRepository.findById(id).get().getPlayers();
	}
	
	
	@PostMapping()
	public ResponseEntity<Object>  saveTeam(@RequestBody Team team) {
		Team tm=teamRepository.save(team);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
		        .buildAndExpand(tm.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Team> updateTeam(@RequestBody Team team,@PathVariable int id) throws TeamNotFoundException {
		if(!teamRepository.findById(id).isPresent()) throw new TeamNotFoundException(id);
		team.setId(id);
		teamRepository.save(team);
		return new ResponseEntity<Team>(team,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Team> deleteTeam(int id)  throws TeamNotFoundException{
		if(!teamRepository.findById(id).isPresent()) throw new TeamNotFoundException(id);
		teamRepository.deleteById(id);
		return new ResponseEntity<Team>(HttpStatus.OK);
	}

}
 