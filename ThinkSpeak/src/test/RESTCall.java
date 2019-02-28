package test;

import java.io.InputStream;
import java.rmi.server.UnicastRemoteObject;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.async.Callback;
import com.mashape.unirest.http.exceptions.UnirestException;


public class RESTCall implements Callback<JsonNode>{

	public void sendDataOverRest(double temp) {
		
		Unirest.post("https://api.thingspeak.com/update.json")
		  .header("accept", "application/json")
		  .field("api_key", "X9IY9JVENWYETNGA")
		  .field("field1",temp)
		  .asJsonAsync(this);
	}

	@Override
	public void cancelled() {
		// TODO Auto-generated method stub
        System.out.println("The request has been cancelled");
	}

	@Override
	public void completed(HttpResponse<JsonNode> response) {
		// TODO Auto-generated method stub
		  int code = response.getStatus();
	       //  Map<String, String> headers = response.getHeaders();
	         JsonNode body =response.getBody();
	         InputStream rawBody = response.getRawBody();

		        System.out.println(code);
		        //System.out.println(body);
		        //System.out.println(rawBody);
		        try {
		        	//Unirest.shutdown();
		        	
		        }
		        catch(Exception e)
		        {
		        	e.printStackTrace();
		        }
	}

	@Override
	public void failed(UnirestException arg0) {
		arg0.printStackTrace();
		// TODO Auto-generated method stub
        System.out.println("The request has failed");
	}

}