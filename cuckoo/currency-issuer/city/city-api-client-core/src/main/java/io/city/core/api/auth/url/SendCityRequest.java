package io.city.core.api.auth.url;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import okio.Buffer;

import com.cuckoo.core.constant.ApplicationConstant;

import io.city.core.api.configuration.CitiRewardBalanceConfiguration;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public abstract class SendCityRequest {

	public String sendApiRequest(String url, Map<String, String> buildRewardHearder,
			Map<String, String> queryParameters, String method, String body) throws IOException {

		OkHttpClient client = new OkHttpClient();
		Request.Builder builder = null;

		HttpUrl httpUrl = HttpUrl.parse(url);
		HttpUrl.Builder httpUrlBuilder = httpUrl.newBuilder();

		for (Map.Entry<String, String> query : queryParameters.entrySet()) {
			httpUrlBuilder.addQueryParameter(query.getKey(), query.getValue());
		}

		if (method.equalsIgnoreCase("get")) {
			builder = new Request.Builder().url(httpUrlBuilder.build()).get();
		} else if (method.equalsIgnoreCase("put")) {
			builder = new Request.Builder().url(httpUrlBuilder.build())
					.put(RequestBody.create(ApplicationConstant.JSON_MEDIA_TYPE, body));
		}

		for (Map.Entry<String, String> header : buildRewardHearder.entrySet()) {
			builder.addHeader(header.getKey(), header.getValue());
		}

		if (builder != null) {
			Request request = builder.build();
			System.out.println("request :" + request.toString());
			System.out.println("request headers :" + request.headers());
			System.out.println("request url :" + request.url());
			Response response = client.newCall(request).execute();
			return response.body().string();
		} else {
			return "someting went wrong";
		}
	}

	public String sendPostRequest(String authUrl, Map<String, String> buildRewardHearder,
			RequestBody body) throws IOException {

		OkHttpClient client = new OkHttpClient();
		Request.Builder builder = null;

		HttpUrl httpUrl = HttpUrl.parse(authUrl);
		HttpUrl.Builder httpUrlBuilder = httpUrl.newBuilder();

		builder = new Request.Builder().url(httpUrlBuilder.build()).post(body);

		for (Map.Entry<String, String> header : buildRewardHearder.entrySet()) {
			builder.addHeader(header.getKey(), header.getValue());
		}
		if (builder != null) {
			Request request = builder.build();
			System.out.println("request :" + request.toString());
			System.out.println("request headers :" + request.headers());
			System.out.println("request url :" + request.url());
			System.out.println("request url :" + stringifyRequestBody(request));
			Response response = client.newCall(request).execute();
			return response.body().string();
		} else {
			return "someting went wrong";
		}
	}

	/*
	 * Get the properties from application.properties file to the Map as a key
	 * value.
	 */
	public Map<String, String> getHeaderProerties() {
		Map<String, String> headerProperties = new HashMap<>();
		try {
			CitiRewardBalanceConfiguration balanceConfiguration = new CitiRewardBalanceConfiguration();
			headerProperties = balanceConfiguration.getPropValues();
		} catch (IOException ex) {
			System.out.println("Exception " + ex);
		}
		return headerProperties;
	}
	
	private static String stringifyRequestBody(Request request) {
	    try {
	        final Request copy = request.newBuilder().build();
	        final Buffer buffer = new Buffer();
	        copy.body().writeTo(buffer);
	        return buffer.readUtf8();
	    } catch (final IOException e) {
	        return "did not work";
	    }
	}
	
	public String getAuthorisationToken(String response) {
		JSONObject obj = new JSONObject(response);
        String access_token = obj.getString("access_token");
        String token_type = obj.getString("token_type");
        String authorisation = token_type.concat(" " + access_token);
        System.out.println("Client Authorization for API :" + authorisation);
		return authorisation;
	}

}
