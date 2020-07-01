package com.iplteam.IPL_CURD_SERVER.player;

public class PlayerNotFoundException extends Exception {
	public PlayerNotFoundException(int playerId)
	{
		super("Record for player with id " + playerId + " not found");
	}

}
