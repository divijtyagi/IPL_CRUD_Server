package com.iplteam.IPL_CURD_SERVER.player;

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

import com.iplteam.IPL_CURD_SERVER.team.Team;
import com.iplteam.IPL_CURD_SERVER.team.TeamNotFoundException;
import com.iplteam.IPL_CURD_SERVER.team.TeamRepository;

//{
//    "id": 9,
//    "playerName": "virat",
//    "preference": "hhh",
//    "matchesPlayed": 1,
//    "runs": 0,
//    "wickets": 0,
//    "highestScore": 0,
//    "bestWicket": "0.0",
//    "fifties": 0,
//    "centuries": 0,
//    "thirties": 0,
//    "catches": 0,
//    "stumpings": 0,
//    "fours": 0,
//    "sixes": 0,
//    "strikeRate": 0,
//    "average": 40
//}
@RestController
@RequestMapping("/players")
public class PlayerController {
	
	@Autowired
	private PlayerRepository playerRepository;
	@Autowired
	private TeamRepository teamRepository;
	
	//GET
	@GetMapping()
	public List<Player> getPlayers() {
		return playerRepository.findAll();
	}
	
	@GetMapping("/{id}") 
	public Optional<Player> getPlayerById(@PathVariable int id) throws PlayerNotFoundException {
		if(!playerRepository.findById(id).isPresent()) throw new PlayerNotFoundException(id);
		return playerRepository.findById(id);
	}
	
	@PostMapping()
	public ResponseEntity<Object> savePlayer(@RequestBody Player player) {
		Player pl=playerRepository.save(player);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
		        .buildAndExpand(pl.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Player> updatePlayer(@RequestBody Player player,@PathVariable int id) throws PlayerNotFoundException {
		if(!playerRepository.findById(id).isPresent()) throw new PlayerNotFoundException(id);
		player.setId(id);
		playerRepository.save(player);
		return new ResponseEntity<Player>(player,HttpStatus.OK);
	}
	@PutMapping("/{playerId}/teams/{teamId}")
	public ResponseEntity<Player> addPlayerToTeam(@PathVariable int teamId,@PathVariable int playerId) throws TeamNotFoundException,PlayerNotFoundException {
		Optional<Player> player=playerRepository.findById(playerId);
		Optional<Team> team=teamRepository.findById(teamId);
		if(!team.isPresent()) throw new TeamNotFoundException(teamId);
		if(!player.isPresent()) throw new PlayerNotFoundException(playerId);
		player.get().setTeam(team.get());
		playerRepository.save(player.get());
		return new ResponseEntity<Player>(player.get(),HttpStatus.OK);
	}
	@DeleteMapping("/{playerId}/teams")
	public ResponseEntity<Player> removePlayerToTeam(@PathVariable int playerId) throws TeamNotFoundException,PlayerNotFoundException {
		Optional<Player> player=playerRepository.findById(playerId);
		if(!player.isPresent()) throw new PlayerNotFoundException(playerId);
		player.get().setTeam(null);
		playerRepository.save(player.get());
		return new ResponseEntity<Player>(player.get(),HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Player> deletePlayer(@PathVariable int id) throws PlayerNotFoundException{
		if(!playerRepository.findById(id).isPresent()) throw new PlayerNotFoundException(id);
		playerRepository.deleteById(id);
		return new ResponseEntity<Player>(HttpStatus.OK);
	}

}
 