package com.microsoft.hackathon.utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.net.ssl.HttpsURLConnection;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.model.CalendarEventResponse;
import com.microsoft.model.PresenceResponse;

public class LoadCalendar {
	
	private final String USER_AGENT = "Mozilla/5.0";
	String outputStr = "";
	
	public CalendarEventResponse LoadUserTodaysCalendar()
	{
		CalendarEventResponse calendarEventResponse = null;
		

		try {

			ObjectMapper objMapper = new ObjectMapper();
			Date dt = new Date();
			Date dtAfter24Hour = new Date();

			SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
			Calendar c = Calendar.getInstance(); 
			c.setTime(dt); 
			c.add(Calendar.DATE, 1);
			dtAfter24Hour = c.getTime();

			String startDateTime = dateFormatter.format(dt);
			String endDateTime = dateFormatter.format(dtAfter24Hour);
			String url = "https://graph.microsoft.com/v1.0/me/calendarview?startdatetime="+startDateTime+"&enddatetime="+endDateTime;
				URL obj = new URL(url);
				HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
				con.setRequestMethod("GET");
				con.setRequestProperty("User-Agent", USER_AGENT);
				con.setRequestProperty("Content-Type", "application/json");
				con.setRequestProperty("Authorization", Token.graphToken);
				con.setRequestProperty("Host", "postman");
				con.setRequestProperty("Accept", "*/*");
				
				//con.setInstanceFollowRedirects(false);

			  
				
				int responseCode = con.getResponseCode();

			/*if (responseCode != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ con.getResponseCode());
			}*/
				objMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

			BufferedReader br = new BufferedReader(new InputStreamReader(
				(con.getInputStream())));

			String output = null;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
				outputStr+=output;
			}
			
			calendarEventResponse = objMapper.readValue(outputStr,CalendarEventResponse.class);
			

			con.disconnect();
			br.close();

		  } catch (MalformedURLException e) {
			  

			e.printStackTrace();

		  } catch (IOException e) {

			e.printStackTrace();

		  }
			return calendarEventResponse;

		}

}
