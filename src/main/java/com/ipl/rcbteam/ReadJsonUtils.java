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
	
	/***
	 * read the JSON file 
	 * 
	 */
	public static void readJsonFile() {
		try {
	JSONParser jsonparser = new JSONParser();
	FileReader file_reader = new FileReader("./src/test/resources/testdata/TeamRCB.json");
	Object object = jsonparser.parse(file_reader);
	rcbTeam_Object = (JSONObject) object;
		}
		catch(ParseException e)
		{
			System.out.println("Unable to Parse : "+e);
		}
		catch(IOException e)
		{
			System.out.println("File not found ! "+e);
		}
		catch(Exception e)
		{
			System.out.println("Exception Message : "+e);
		}
	}
	
	/**
	 * get data from JSON  and find the count 
	 * foreignplayercount and wicketkeepercount
	 * @return void
	 */
	public static void fetchData(){
		try
		{
			if(rcbTeam_Object!=null) {
				JSONArray rcbteamArr = (JSONArray) rcbTeam_Object.get("player");
				
				if(rcbteamArr.size()>=1) {
			     	 for(int i=0;i<rcbteamArr.size();i++) { 
				  	  JSONObject rcbplayer=(JSONObject)rcbteamArr.get(i);
					  String country=(String)rcbplayer.get("country");
                     if(!country.equals("India")) foreignPlayerCount++;
					   String role=(String)rcbplayer.get("role");
					   if(role.equals("Wicket-keeper")) wicketKeeperCount++;
			     	 }
			     	
				 }
				 else
		     	 {
		     		System.out.println("Players details not found in JSON");
		     	 }
			}else {
				System.out.println("Input JSON is empty");
			}
		 }catch(Exception e)
		    {
			 printException(e);
		    }
		
	}

	private static void printException(Exception e) {
		// TODO Auto-generated method stub
		System.err.println("Exception happened due to invalid data: "+e.getMessage());
		System.err.println("Stack Trace: "+e.getStackTrace());	
	}
}
