package com.api.status.constants;

/**
 * 
 * @author Lavanya
 * All the URLs are mapped here
 */
public enum UrlMappings {
	AMAZON_URL("https://www.amazon.com"),
	GOOGLE_URL("https://www.google.com");

    public final String url;

    private UrlMappings(String url) {
        this.url = url;
    }
}
