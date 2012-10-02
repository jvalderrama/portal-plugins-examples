/*
 * Portal App
 * Copyright (C) 2012 Stackops Technologies
 */
package com.stackops.portal.plugins;

import java.io.IOException;

import net.xeoh.plugins.base.annotations.PluginImplementation;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.stackops.portal.plugin.api.CheckerPlugin;
import com.stackops.portal.plugin.api.Settings;

/**
 * Weather check.
 * It does a request to weather.url in settings.
 */
@PluginImplementation
public class WeatherPluginCheck implements CheckerPlugin {
    
    private static final String CHECK_WEATHER_ENDPOINT = "check.weather.endpoint";

    /**
     * Logger.
     */
    private static final Log LOGGER = LogFactory.getLog(WeatherPluginCheck.class);

    /**
     * Checker method.
     */
    public Boolean check(final Settings settings) {
        Boolean result = Boolean.TRUE;
        LOGGER.debug("Checking Weather Plugin...");
        String url = settings.getString(CHECK_WEATHER_ENDPOINT);
        if(url == null || url.isEmpty()) {
            LOGGER.warn("Property " + CHECK_WEATHER_ENDPOINT + " not found (or blank) in settings. Return FALSE.");
            return Boolean.FALSE;
        }
        LOGGER.debug("Using URL: " + url);
        HttpClient client = new DefaultHttpClient();
        HttpGet get = new HttpGet(url);
        try {
            HttpResponse response = client.execute(get);
            if(response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
                LOGGER.warn("Checker returning false: " + WeatherPluginCheck.class.toString());
                result = Boolean.FALSE;
            } else {
                LOGGER.debug("Check: OK");
            }
        } catch (ClientProtocolException e) {
            LOGGER.warn("Checker returning false: " + WeatherPluginCheck.class.toString());
            result = Boolean.FALSE;
        } catch (IOException e) {
            LOGGER.warn("Checker returning false: " + WeatherPluginCheck.class.toString());
            result = Boolean.FALSE;
        } finally {
            client.getConnectionManager().shutdown();
        }
        LOGGER.debug("System check done");
        return result;
    }

    @Override
    public String getSystemName() {
        return "Weather";
    }

    @Override
    public String getCheckName() {
        return "Weather Service Check";
    }

}
