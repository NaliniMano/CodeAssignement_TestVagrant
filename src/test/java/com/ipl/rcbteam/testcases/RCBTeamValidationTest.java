package com.ipl.rcbteam.testcases;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ipl.rcbteam.ReadJsonUtils;

import org.testng.annotations.Test;

public class RCBTeamValidationTest extends ReadJsonUtils {
	
	@BeforeTest
	public void preSetUp() throws IOException, ParseException{
		ReadJsonUtils.readJsonFile();
		ReadJsonUtils.fetchData();
	}
	
	@Test
	@Parameters("foreign_player")
	public void validateForeignPlayer(int foreign_player_count)
	{
		Assert.assertTrue(ReadJsonUtils.foreignPlayerCount==foreign_player_count);
		
	}

	
	@Test
	@Parameters("wicket_keeper")
	public void validateWicketKeeper(int wicket_keeper_count)
	{
		Assert.assertTrue(ReadJsonUtils.wicketKeeperCount>=wicket_keeper_count);
	}
}
