package com.microsoft.hackathon.utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.model.PresenceResponse;

public class GetUserPresence {
	private final String USER_AGENT = "Mozilla/5.0";
	
	public PresenceResponse GetUserCurrentPresence()
	{
		PresenceResponse presenceResponse = null;

		try {

			ObjectMapper objMapper = new ObjectMapper();
			
			  String url = "https://graph.microsoft.com/beta/me/presence";
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

			BufferedReader br = new BufferedReader(new InputStreamReader(
				(con.getInputStream())));

			String output = null;
			String outputStr = "";
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
				outputStr+=output;
			}
			
			presenceResponse = objMapper.readValue(outputStr, PresenceResponse.class);
			

			con.disconnect();
			br.close();

		  } catch (MalformedURLException e) {
			  

			e.printStackTrace();

		  } catch (IOException e) {

			e.printStackTrace();

		  }
			return presenceResponse;

		}

}
