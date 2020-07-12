package io.city.core.api.security;

import java.io.IOException;
import java.util.Map;

import io.city.core.api.auth.url.SendCityRequest;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class AuthorizationToken extends SendCityRequest{

	Map<String, String> headerValues = getHeaderProerties();
	
	String httpMethod = "GET";
    String clientId = headerValues.get("clientId");
    String clientSecret =  headerValues.get("clientSecret");
    String targetURL =  headerValues.get("cityRewardUrl");
    
    void callAuthorization() throws IOException {
    	OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "grant_type=kuvbokic&scope=kugjed");
        Request request = new Request.Builder()
          .url("https://sandbox.apihub.citi.com/gcb/api/clientCredentials/oauth2/token/us/gcb")
          .post(body)
          .addHeader("authorization", "REPLACE_THIS_VALUE")
          .addHeader("content-type", "REPLACE_THIS_VALUE")
          .addHeader("accept", "application/json")
          .build();

        Response response = client.newCall(request).execute();
	}
    
    
    
}
