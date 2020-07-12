package io.city.core.api.auth.url;

import java.util.Map;

public interface HeaderProvider {
	Map<String, String> buildRewardHearder(Map<String,String> headerValues);
}
