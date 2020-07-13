package io.city.core.api.client.reward.auth;

import java.io.IOException;
import java.util.Map;

import io.city.core.api.auth.url.BuildRequestHeader;
import io.city.core.api.auth.url.HeaderProvider;
import io.city.core.api.auth.url.SendCityRequest;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class CallAuthorization extends SendCityRequest{

	Map<String, String> headerValues = getHeaderProerties();
	
	String httpMethod = "Post";
    String authUrl =  headerValues.get("authUrl");
    String authMediaType =  headerValues.get("authMediaType");
    
    public String callAuthorization() throws IOException {
    	
    	HeaderProvider headerProvider = new BuildRequestHeader();
    	
    	MediaType mediaType = MediaType.parse(authMediaType);
    	RequestBody body = RequestBody.create(mediaType, getResponseBody(headerValues));
    	
    	//call the city Authorization api by passing requied parameters.
    	String response = sendAuthApiRequest(authUrl, headerProvider.buildAuthorization(headerValues),httpMethod,body);

		System.out.println("Client Authorization :" + response);

		return response;
	}

	private String getResponseBody(Map<String, String> headerValues) {

		String clientSecret =  headerValues.get("clientSecret");
		 String authScope =  headerValues.get("authScope");
		 
		return "grant_type=".concat(clientSecret).concat("&scope=").concat(authScope);
	}
    
    
    
}
