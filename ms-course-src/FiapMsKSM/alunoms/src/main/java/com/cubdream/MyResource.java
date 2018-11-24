package com.cubdream;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.Gson;


/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }
    
 @Path("savealuno")
 @POST
 @Consumes(MediaType.APPLICATION_JSON)
 public String savealuno(String tobuffer) throws ParseException
 {
	 JSONObject json = (JSONObject) new JSONParser().parse(tobuffer); 
	 JSONObject jdatamedium = (JSONObject) json.get("data");
	 String jdatahot = (String) jdatamedium.get("tobuffer");
	 Gson gson = new Gson();
	 Aluno aluno = gson.fromJson(jdatahot, Aluno.class);
	 
	 System.out.println(json);
	//adiciona no banco de dados
	 //Chama o kafka
	 
	
	 JSONObject jsons = new JSONObject();
	 jsons.put("nome", aluno.getNome());
	 
	 
	return json.toJSONString();
			
	 
 }
}
