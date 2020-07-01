package com.iplteam.IPL_CURD_SERVER.team;

public class TeamNotFoundException extends Exception{
	public TeamNotFoundException(int teamId)
	{
		super("Record for Team with id " + teamId + " not found");
	}

}
