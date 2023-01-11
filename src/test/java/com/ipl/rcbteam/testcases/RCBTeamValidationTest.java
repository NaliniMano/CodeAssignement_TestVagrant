package com.ipl.rcbteam.testcases;



import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ipl.rcbteam.ReadJsonUtils;

public class RCBTeamValidationTest extends ReadJsonUtils {
	
	@BeforeTest
	
	public void preSetUp() {
		ReadJsonUtils.readJsonFile();
		ReadJsonUtils.fetchData();
	}
	
	@Test
	@Parameters("foreign_player")
	/***
	 * Validate the foreign player in the team based on the  parameter passed in suite file
	 * 
	 */

	public void validateForeignPlayer(@Optional("4") int foreign_player_count)
	{
		Assert.assertTrue(ReadJsonUtils.foreignPlayerCount==foreign_player_count);
		
		
	}

	
	@Test
	@Parameters("wicket_keeper")
	/***
	 * Validate the atleast one WicketKeeper in the team 
	 * 
	 */
	public void validateWicketKeeper(@Optional("1") int wicket_keeper_count)
	{
		Assert.assertTrue(ReadJsonUtils.wicketKeeperCount>=wicket_keeper_count);
	}
	
	
}
