package com.iplteam.IPL_CURD_SERVER.player;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.iplteam.IPL_CURD_SERVER.team.Team;

@Entity
@Table(name="PLAYER")
public class Player {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="PLAYER_ID")
	private int id;
	@Column(name="PLAYER_NAME")
	private String playerName;
	@Column(name = "preference")
	private String preference;
	@Column(name = "match_played")
	private int matchesPlayed;
	@Column(name = "runs")
	private int runs;
	@Column(name = "wickets")
	private int wickets;
	@Column(name = "highest_score")
	private int highestScore;
	@Column(name = "best_wicket")
	private String bestWicket;
	@Column(name = "fifties")
	private int fifties;
	@Column(name = "centuries")
	private int centuries;
	@Column(name = "thirties")
	private int thirties;
	@Column(name = "catches")
	private int catches;
	@Column(name = "stumpings")
	private int stumpings;
	@Column(name = "fours")
	private int fours;
	@Column(name = "sixes")
	private int sixes;
	@Column(name = "strike_rate")
	private double strikeRate;
	@Column(name = "average")
	private double average;
	@ManyToOne
	@JoinColumn(name = "team_id")
	private Team team;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public String getPreference() {
		return preference;
	}
	public void setPreference(String preference) {
		this.preference = preference;
	}
	public int getMatchesPlayed() {
		return matchesPlayed;
	}
	public void setMatchesPlayed(int matchesPlayed) {
		this.matchesPlayed = matchesPlayed;
	}
	public int getRuns() {
		return runs;
	}
	public void setRuns(int runs) {
		this.runs = runs;
	}
	public int getWickets() {
		return wickets;
	}
	public void setWickets(int wickets) {
		this.wickets = wickets;
	}
	public int getHighestScore() {
		return highestScore;
	}
	public void setHighestScore(int highestScore) {
		this.highestScore = highestScore;
	}
	public String getBestWicket() {
		return bestWicket;
	}
	public void setBestWicket(String bestWicket) {
		this.bestWicket = bestWicket;
	}
	public int getFifties() {
		return fifties;
	}
	public void setFifties(int fifties) {
		this.fifties = fifties;
	}
	public int getCenturies() {
		return centuries;
	}
	public void setCenturies(int centuries) {
		this.centuries = centuries;
	}
	public int getThirties() {
		return thirties;
	}
	public void setThirties(int thirties) {
		this.thirties = thirties;
	}
	public int getCatches() {
		return catches;
	}
	public void setCatches(int catches) {
		this.catches = catches;
	}
	public int getStumpings() {
		return stumpings;
	}
	public void setStumpings(int stumpings) {
		this.stumpings = stumpings;
	}
	public int getFours() {
		return fours;
	}
	public void setFours(int fours) {
		this.fours = fours;
	}
	public int getSixes() {
		return sixes;
	}
	public void setSixes(int sixes) {
		this.sixes = sixes;
	}
	public double getStrikeRate() {
		return strikeRate;
	}
	public void setStrikeRate(double strikeRate) {
		this.strikeRate = strikeRate;
	}
	public double getAverage() {
		return average;
	}
	public void setAverage(double average) {
		this.average = average;
	}
	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}
	

}
