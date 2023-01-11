package com.ipl.rcbteam;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadJsonUtils {
	
	public static JSONObject rcbTeam_Object;
	protected static int wicketKeeperCount;
	protected static int foreignPlayerCount;
	
	public static void readJsonFile() throws IOException, ParseException {
	JSONParser jsonparser = new JSONParser();
	FileReader reader = new FileReader("./src/test/resources/testdata/TeamRCB.json");
	Object object = jsonparser.parse(reader);
	rcbTeam_Object = (JSONObject) object;
	}
	
	/**
	 * Fetch data from JSON Array
	 * 
	 * @return void
	 */
	public static void fetchData(){
		try {
			if(rcbTeam_Object!=null) {
				JSONArray playerArr = (JSONArray) rcbTeam_Object.get("player");
				for(int i=0;i<playerArr.size();i++) { 
					JSONObject player=(JSONObject)playerArr.get(i);
					String country=(String)player.get("country");
					
					if(!country.equals("India")) foreignPlayerCount++;
					String role=(String)player.get("role");
					if(role.equals("Wicket-keeper")) wicketKeeperCount++;			
				}
			}else {
				System.out.println("Unable to fetch data");
			}
		}catch(Exception e) {
			printException(e);
		}
	}

	private static void printException(Exception e) {
		// TODO Auto-generated method stub
		System.out.println("Exception Message: "+e.getMessage());
		System.out.println("Stack Trace: "+e.getStackTrace());		
	}
}
