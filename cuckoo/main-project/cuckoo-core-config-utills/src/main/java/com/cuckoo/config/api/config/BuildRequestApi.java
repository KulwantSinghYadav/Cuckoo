package com.cuckoo.config.api.config;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.cuckoo.config.property.config.CitiRewardBalanceConfiguration;
import com.model.core.constant.ApplicationConstant;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@Component
public class BuildRequestApi implements RequestBuilder {

	/*
	 * This function is used for sending the request to the External-API's with Get and Put method.
	 */
	@Override
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
			Response response = client.newCall(request).execute();
			return response.body().string();
		} else {
			return "someting went wrong during sending of Api request";
		}
	}

	/*
	 * This function is used for sending the request to the External-API's with Post method.
	 */
	@Override
	public String sendApiRequest(String authUrl, Map<String, String> buildRewardHearder, RequestBody body)
			throws IOException {

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
			Response response = client.newCall(request).execute();
			return response.body().string();
		} else {
			return "someting went wrong during sending of Api request";
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
//	
//	//This function is used to return request URL of Authorization API.
//	private static String stringifyRequestBody(Request request) {
//	    try {
//	        final Request copy = request.newBuilder().build();
//	        final Buffer buffer = new Buffer();
//	        copy.body().writeTo(buffer);
//	        return buffer.readUtf8();
//	    } catch (final IOException e) {
//	        return "did not work";
//	    }
//	}

	/*
	 *  This function is used to get Authorization token value and set the response into a map.
	 */
	@Override
	public Map<String,String> getAuthorisationReqRes(String response, String authUrl, String encodedAuth, String status, String clientCredentials) {
		JSONObject obj = new JSONObject(response);
		String access_token = obj.getString("access_token");
		String token_type = obj.getString("token_type");
		Integer expires_in = Integer.valueOf(obj.getInt("expires_in"));
		Integer consentedOn =  Integer.valueOf(obj.getInt("consented_on"));
		String scope = obj.getString("scope");
		String authorisation = token_type.concat(" " + access_token);
		
		Map<String, String> authorisationReqRes = new HashMap<>();
		authorisationReqRes.put("authUrl",authUrl);
		authorisationReqRes.put("encoded_auth",encodedAuth);
		authorisationReqRes.put("access_token",access_token);
		authorisationReqRes.put("client_credentials",clientCredentials);
		authorisationReqRes.put("authorisation",authorisation);
		authorisationReqRes.put("expires_in",expires_in.toString());
		authorisationReqRes.put("scope",scope);
		authorisationReqRes.put("consented_on",consentedOn.toString());
		return authorisationReqRes;
	}

	/*
	 *  This function is to set dynamic query parameter
	 */
	@Override
	public Map<String, String> setQueryParameter(Map<String,String> queryParameter) {

		// Set the query parameter for city reward api.
		Map<String, String> queryParameters = new LinkedHashMap<>();

		if (validateString(queryParameter.get(ApplicationConstant.Cloaked_Credit_Card_Numbers))) {
			
			queryParameters.put(ApplicationConstant.Cloaked_Credit_Card_Numbers, queryParameter.get(ApplicationConstant.Cloaked_Credit_Card_Numbers));
		}
		if (validateString(queryParameter.get(ApplicationConstant.Merchant_Code))) {

			queryParameters.put(ApplicationConstant.Merchant_Code, queryParameter.get(ApplicationConstant.Merchant_Code));
		}
		if (validateString(queryParameter.get(ApplicationConstant.Reward_Program))) {

			queryParameters.put(ApplicationConstant.Reward_Program, queryParameter.get(ApplicationConstant.Reward_Program));
		}
		if (validateString(queryParameter.get(ApplicationConstant.Reward_Link_Code))) {

			queryParameters.put(ApplicationConstant.Reward_Link_Code, queryParameter.get(ApplicationConstant.Reward_Link_Code));
		}

		return queryParameters;
	}

	/*
	 *  This function is to validate query parameter
	 */
	private boolean validateString(String value) {
		if (StringUtils.isEmpty(value)) {
			return false;
		} else {
			return true;
		}

	}
}
