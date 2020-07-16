package io.city.core.api.configuration;

/**
 * Defines the interface that configuration providers must implement.
 */
public interface ConfigurationProvider {

    String getValue(String key);
}
