package io.city.core.api.auth.url;

import java.util.Map;

public interface HeaderProvider {
	Map<String, String> buildRewardHearder(Map<String,String> headerValues);
	Map<String, String> buildAuthorization(Map<String,String> headerValues);
	String setUrlPattern(String url, String vi, String apiProduct, String endpoint);
}
