package io.city.core.api.auth.url;

import java.io.IOException;
import java.util.Map;

public interface HeaderProvider {
	Map<String, String> buildRewardHearder() throws IOException;
	Map<String, String> buildAuthorization(Map<String,String> headerValues);
	String setUrlPattern(String url, String vi, String apiProduct, String endpoint);
}
