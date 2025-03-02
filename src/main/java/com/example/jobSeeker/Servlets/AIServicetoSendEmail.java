package com.example.jobSeeker.Servlets;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import okhttp3.*;

@Service
public class AIServicetoSendEmail {
	
	private static final String API_KEY = ""; // Replace with your API Key
	private static final String GEMINI_API_URL = "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash:generateContent?key="
			+ API_KEY;
	
	public String getChatReplies(String prompt) {
		// TODO Auto-generated method stub
		try {
	        OkHttpClient client = new OkHttpClient();

	        // Correct JSON format expected by Gemini API
	        JSONObject requestBody = new JSONObject();
	        requestBody.put("contents", new JSONArray()
	                .put(new JSONObject()
	                        .put("parts", new JSONArray()
	                                .put(new JSONObject()
	                                        .put("text", prompt)))));

	        RequestBody body = RequestBody.create(requestBody.toString(), MediaType.get("application/json"));

	        Request request = new Request.Builder()
	                .url(GEMINI_API_URL)
	                .post(body)
	                .build();

	        Response response = client.newCall(request).execute();
//	        return response.body() != null ? response.body().string() : "No response";
	        String jsonResponse = response.body().string();
            JSONObject jsonObject = new JSONObject(jsonResponse);

            // Extracting "text" field from JSON response
            String text = jsonObject.getJSONArray("candidates")
                    .getJSONObject(0)
                    .getJSONObject("content")
                    .getJSONArray("parts")
                    .getJSONObject(0)
                    .getString("text");
	        
	        return text;

	    } catch (Exception e) {
	        return "Error: " + e.getMessage();
	    }
	    }

	}
	
	
	

