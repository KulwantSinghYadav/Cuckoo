package io.city.core.api.client.reward.auth;

import java.io.IOException;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.stereotype.Component;

import io.city.core.api.auth.url.BuildRequestHeader;
import io.city.core.api.auth.url.HeaderProvider;
import io.city.core.api.auth.url.SendCityRequest;
import okhttp3.MediaType;
import okhttp3.RequestBody;

@Component
public class CallAuthorization extends SendCityRequest{

	Map<String, String> headerValues = getHeaderProerties();
	
    String authUrl =  headerValues.get("authUrl");
    String authMediaType =  headerValues.get("authMediaType");
    
    public String callAuthorization() throws IOException {
    	
    	HeaderProvider headerProvider = new BuildRequestHeader();
    	
    	MediaType mediaType = MediaType.parse(authMediaType);
    	RequestBody body = RequestBody.create(mediaType, getResponseBody(headerValues));
    	
    	//call the city Authorization api by passing requied parameters.
    	String response = sendPostRequest(authUrl, headerProvider.buildAuthorization(headerValues),body);

		System.out.println("Client Authorization Response :" + response);
		
		return getAuthorisationToken(response);
	}

	private String getResponseBody(Map<String, String> headerValues) {

		 String authScope =  headerValues.get("authScope");
    	 return "grant_type=".concat("client_credentials").concat("&scope=").concat(authScope);
	}
    
    
    
}
