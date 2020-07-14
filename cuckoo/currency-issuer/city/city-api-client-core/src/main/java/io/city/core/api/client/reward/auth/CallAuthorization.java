package io.city.core.api.client.reward.auth;

import java.io.IOException;
import java.util.Map;

import io.city.core.api.auth.url.BuildRequestHeader;
import io.city.core.api.auth.url.HeaderProvider;
import io.city.core.api.auth.url.SendCityRequest;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.json.JSONObject;

public class CallAuthorization extends SendCityRequest{

	Map<String, String> headerValues = getHeaderProerties();
	
	String httpMethod = "Post";
    String authUrl =  headerValues.get("authUrl");
    String authMediaType =  headerValues.get("authMediaType");
    
    public String callAuthorization() throws IOException {
    	
    	HeaderProvider headerProvider = new BuildRequestHeader();
    	
    	MediaType mediaType = MediaType.parse(authMediaType);
    	RequestBody body = RequestBody.create(mediaType, getResponseBody(headerValues));
    	/*RequestBody body = new FormBody.Builder()
    	        .addEncoded("grant_type", "client_credentials")
    	        .addEncoded("scope", "/api")
    	        .build();*/
    	//call the city Authorization api by passing requied parameters.
    	String response = sendAuthApiRequest(authUrl, headerProvider.buildAuthorization(headerValues),httpMethod,body);

		System.out.println("Client Authorization Response :" + response);
		JSONObject obj = new JSONObject(response);
        String access_token = obj.getString("access_token");
        String token_type = obj.getString("token_type");
        String authorisation = token_type.concat(" " + access_token);
        System.out.println("Client Authorization for API :" + authorisation);
		return authorisation;
	}

	private String getResponseBody(Map<String, String> headerValues) {

		String clientSecret =  headerValues.get("clientSecret");
		 String authScope =  headerValues.get("authScope");
		 
		return "grant_type=".concat("client_credentials").concat("&scope=").concat(authScope);
	}
    
    
    
}
