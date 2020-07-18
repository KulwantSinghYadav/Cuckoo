package com.cuckoo.config.property.config;

/**
 * Defines the interface that configuration providers must implement.
 */
public interface ConfigurationProvider {

    String getValue(String key);
}
