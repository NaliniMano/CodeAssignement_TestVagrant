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
			System.out.println("Unable to Parse"+e);
		}
		catch(IOException e)
		{
			System.out.println("File not found"+e);
		}
		catch(Exception e)
		{
			System.out.println("print exception"+e);
		}
	}
	
	/**
	 * get data from JSON  and the count of
	 * foreignplayercount and wicketkeepercount
	 * @return void
	 */
	public static void fetchData(){
		try
		{
			if(rcbTeam_Object!=null) {
				JSONArray rcbplayerArr = (JSONArray) rcbTeam_Object.get("player");
				
				for(int i=0;i<rcbplayerArr.size();i++) { 
					JSONObject rcbplayer=(JSONObject)rcbplayerArr.get(i);
					String country=(String)rcbplayer.get("country");
                   if(!country.equals("India")) foreignPlayerCount++;
                   
					String role=(String)rcbplayer.get("role");
					if(role.equals("Wicket-keeper")) wicketKeeperCount++;			
				}
			}else {
				System.out.println("No data foud in JSON");
			}
		 }catch(Exception e)
		    {
			 printException(e);
		    }
		
	}

	private static void printException(Exception e) {
		// TODO Auto-generated method stub
		System.out.println("Exception Message: "+e.getMessage());
		System.out.println("Stack Trace: "+e.getStackTrace());		
	}
}
